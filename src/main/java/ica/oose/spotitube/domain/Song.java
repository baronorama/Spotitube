package ica.oose.spotitube.domain;

/**
 * Created by Vincent on 4-12-2015.
 */
public class Song extends Track {
   private String album;

    public Song(int trackId, String performer,
                String title, String url, Double duration, String album) {
        super(trackId, performer, title, url, duration);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return super.toString() +
                "album = "
                + album
                + '\''
                + '}';
    }

}
