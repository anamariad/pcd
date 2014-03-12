package main.music;

import java.io.Serializable;
import java.util.List;

public class TrackList implements Serializable {

   private List<Track> track;


    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }
}
