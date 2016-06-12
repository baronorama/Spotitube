package ica.oose.spotitube.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 4-12-2015.
 */
public class Playlist {
    private int playlistId;
    private String owner;
    private String name;
    private List<Track> tracks;

    public Playlist() {
    }

    public Playlist(int playlistId, String owner, String name) {
        this.playlistId = playlistId;
        this.owner = owner;
        this.name = name;
    }

     public String getOwner() {
        return owner;
    }
/* playlist may not change owners! */
    public String setOwner(String owner) {
        return "Owner may not be changed.";
    }

    public int getPlaylistId() {
        return playlistId;
    }
    public String getName() {
        return name;
    }
    public void changeName(String name) {
        this.name = name;
    }

    //TODO: test addTrack
    public void addTrack(Track track) {
        if (tracks.isEmpty()) {
            tracks = new ArrayList<Track>();
        }
        tracks.add(track);
    }

    public List<String> getTracks() {
        List<String> titles = new ArrayList<String>();
        for (Track track: tracks) {
            titles.add(track.getTitle());
        }
        return titles;
    }

    public String toString() {
        return ("PlaylistId: "
                + playlistId
                + ", Owner: "
                + owner
                + ", Name: "
                + name
                + ", tracks: "
                + tracks
                + "\n");
    }

}
