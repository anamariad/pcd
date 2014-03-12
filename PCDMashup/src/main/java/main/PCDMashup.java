package main;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.music.Song;
import main.translate.TranslateRequest;
import main.translate.tempuri.LanguageService;
import main.translate.tempuri.SoapService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;

public class PCDMashup {

    public static void main(String[] args) throws IOException {
        // 1. Getting a song by mood
        String tag = "sad";
        Client client = ClientBuilder.newClient();
        WebTarget musicoveryTarget = client.target("http://musicovery.com/api")
                .path("playlist.php");
        Response multicoveryResponse = musicoveryTarget.queryParam("fct", "tagseed")
                .queryParam("tag", tag)
                .queryParam("popularitymax", "100")
                .queryParam("popularitymin", "50")
                .queryParam("format", "json")
                .queryParam("tracksnumber", "5")
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get();

        String jsonResponse = multicoveryResponse.readEntity(String.class);

        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode root = mapper.readTree(jsonResponse);
        JsonNode tracks = root.findPath("track");
        JsonNode firstSong = tracks.get(0);

        String title = firstSong.path("title").asText();
        String artist = firstSong.path("artist").path("name").asText();

        System.out.println(String.format("Song title for tag \"%s\": %s", tag, title));
        System.out.println(String.format("Song artist: %s", artist));

        // 2. Getting the lyrics for the song
        WebTarget lyricsTarget = client.target("http://lyrics.wikia.com/").path("api.php");
        Response lyricsResponse = lyricsTarget.queryParam("artist", artist)
                                                .queryParam("song", title)
                                                .queryParam("fmt", "json")
                                                .request()
                                                .accept(MediaType.APPLICATION_JSON_TYPE)
                                                .get();

        String lyricsJson = lyricsResponse.readEntity(String.class);
        lyricsJson = lyricsJson.substring(lyricsJson.indexOf("{")).replace("'", "\"");


        Song song = mapper.readValue(lyricsJson, Song.class);
        song.setLyrics(song.getLyrics().replace("\"", "'"));
        System.out.println("\nLyrics (fragment): " + song.getLyrics());
        System.out.println("\nFull lyrics url: " + song.getUrl());
        client.close();

        // 3. Translating the lyrics
        SoapService service = new SoapService(new URL("http://api.microsofttranslator.com/V2/Soap.svc"));
        LanguageService langService = service.getBasicHttpBindingLanguageService();

        String appId = "Bearer " + TranslateRequest.obtainAccessToken();
        String translate = langService.translate(appId, song.getLyrics(), "en", "ro", "text/plain", "general");
        System.out.println("\nTranslated lyrics: " + translate);


    }
}
