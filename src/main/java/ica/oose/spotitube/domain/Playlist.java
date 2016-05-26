package ica.oose.spotitube.domain;

import ica.oose.spotitube.datasource.util.PlaylistDAO;

/**
 * Created by Vincent on 4-12-2015.
 */
public class Playlist {
    private int playlistId;
    private String owner;
    private String name;

    public Playlist() {
    }

    public Playlist(int playlistId, String owner, String name) {
        this.playlistId = playlistId;
        this.owner = owner;
        this.name = name;
    }

    public void setplaylistId(Integer playlistId) {
        this.playlistId = playlistId;
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

    //TODO: implement addTrack
    public void addTrack(Track track, Integer idplaylist) {
    }

    public String toString() {
        return ("PlaylistId: " + playlistId + ", Owner: " + getOwner() + ", Name: " + getName() + "\n");
    }

}
