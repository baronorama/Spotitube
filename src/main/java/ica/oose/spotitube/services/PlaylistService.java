package ica.oose.spotitube.services;

import com.google.inject.Inject;
import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.PlaylistDAO;
import ica.oose.spotitube.domain.Playlist;

import java.util.List;

/**
 * Created by Vincent on 21-1-2016.
 */
public class PlaylistService implements PlaylistServiceInterface {
    private DatabaseProperties databaseProperties = new DatabaseProperties();
    private PlaylistDAO playlistDAO = new PlaylistDAO(databaseProperties);

    @Inject
    public void setPlaylistDAO(PlaylistDAO playlistDAO) {
        this.playlistDAO = playlistDAO;
    }

    @Override
    public List<Playlist> getPlaylist(int playlistId) {
        return playlistDAO.select(playlistId);
    }

    @Override
    public List<Playlist> findAll() {
        return playlistDAO.findAll();
    }

    @Override
    public List<Playlist> getPlaylistsByOwner(String owner) { return playlistDAO.findByOwner(owner); }

    @Override
    public void create(String owner, String name) {
        playlistDAO.create(owner, name);
    }

    @Override
    public void delete(int playlistId) {
        playlistDAO.delete(playlistId);
    }
}
