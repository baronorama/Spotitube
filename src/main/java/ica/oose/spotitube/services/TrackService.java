package ica.oose.spotitube.services;

import com.google.inject.Inject;
import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.TrackDAO;
import ica.oose.spotitube.domain.Track;

import java.util.List;

/**
 * Created by Vincent on 21-1-2016.
 */
public class TrackService implements TrackServiceInterface {
    private DatabaseProperties databaseProperties = new DatabaseProperties();
    private TrackDAO trackDAO = new TrackDAO(databaseProperties);

    @Inject
    public void setTrackDAO(TrackDAO trackDAO) {
        this.trackDAO = trackDAO;
    }

    @Override
    public List<Track> getTrack(int trackId) {
        return trackDAO.select(trackId);
    }

    @Override
    public List<Track> findAll() {
        return trackDAO.findAll();
    }

    @Override
    public List<Track> getTracksByBandname(String performer) {
        return null;
    }

    @Override
    public void create(String performer, String title, String url, Double duration) {
        trackDAO.create(performer, title, url, duration);
    }

    @Override
    public void delete(int trackId) {
        trackDAO.delete(trackId);
    }
}
