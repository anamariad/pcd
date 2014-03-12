package main.music;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MusicoveryResponse {

    private TrackList tracks;

    public TrackList getTracks() {
        return tracks;
    }

    public void setTracks(TrackList tracks) {
        this.tracks = tracks;
    }
}
