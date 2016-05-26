package ica.oose.spotitube.domain;

import java.util.Calendar;

/**
 * Created by Vincent on 4-12-2015.
 */
public class Video extends Track {
    private int playCount;
    private Calendar publicationDate;
    private String description;

    public Video(int trackId, String performer, String title, String url, Double duration) {
        super(trackId, performer, title, url, duration);
    }

    public Video(int trackId, String performer, String title, String url, Double duration, int playCount, Calendar publicationDate, String description) {
        super(trackId, performer, title, url, duration);
        this.playCount = playCount;
        this.publicationDate = publicationDate;
        this.description = description;
    }

    public int getPlayCount() { return playCount; }
    public void setPlayCount(int playCount) { this.playCount = playCount; }
    public Calendar getPublicationDate() { return publicationDate; }
    public void setPublicationDate(Calendar publicationDate) { this.publicationDate = publicationDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description;}
}
