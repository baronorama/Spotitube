package ica.oose.spotitube.services;

import ica.oose.spotitube.domain.Playlist;

import java.util.List;

/**
 * Created by Vincent on 21-1-2016.
 */
public interface PlaylistServiceInterface {
    List<Playlist> getPlaylist(int playlistId);
    List<Playlist> findAll();
    List<Playlist> getPlaylistsByOwner(String owner);
    void create(String owner, String name);
    void delete(int playlistId);
}
