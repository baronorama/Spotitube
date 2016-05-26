package ica.oose.spotitube.services;

import ica.oose.spotitube.domain.Track;

import java.util.List;

/**
 * Created by Vincent on 21-1-2016.
 */
public interface TrackServiceInterface {
    List<Track> getTrack(int trackId);
    List<Track> findAll();
    List<Track> getTracksByBandname(String performer);
    void create(String performer, String title, String url, Double duration);
    void delete(int trackId);
}
