package ica.oose.spotitube.services;

import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.TrackDAO;
import ica.oose.spotitube.domain.Track;

import java.util.List;

/**
 * Created by Vincent on 21-1-2016.
 */
public class TestTrackService implements TrackServiceInterface {
    private DatabaseProperties databaseProperties = new DatabaseProperties();
    private TrackDAO trackDAO = new TrackDAO(databaseProperties);

    @Override
    public List<Track> getTrack(int trackId) {
        List<Track> tracks = null;
        return tracks;
    }

    @Override
    public List<Track> findAll() {
        return trackDAO.select(1);
    }

    @Override
    public List<Track> getTracksByBandname(String bandname) {
        List<Track> tracks = null;
        return tracks;
    }

    @Override
    public void create(String performer, String title, String url, Double duration) {
        trackDAO.create("testperformer", "testtitle", "testurl", 0.0);
    }

    @Override
    public void delete(int trackId) {
        System.out.println("testdelete");
    }
}
