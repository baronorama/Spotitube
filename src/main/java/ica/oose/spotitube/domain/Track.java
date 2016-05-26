package ica.oose.spotitube.domain;

/**
 * Created by Vincent on 16-11-2015.
 */
public class Track {
    private int trackId;
    private String performer;
    private String title;
    private String url;
    private Double duration;

    public Track(int trackId, String performer, String title, String url, Double duration) {
        this.trackId = trackId;
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
 //       System.out.println("I'm a track. Better watch your back...");
    }

    public int getTrackId() {return trackId;}
    public String getPerformer() { return performer; }
    public void setPerformer(String performer) { this.performer = performer; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Double getDuration() { return duration; }
    public void setDuration(Double duration) { this.duration = duration; }

    @Override
    public String toString() {
        return "Track {" +
                "trackId='" + trackId + '\'' +
                "performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

}
