package ica.oose.spotitube.domain;

/**
 * Created by Vincent on 4-12-2015.
 */
public class Availability {
    private boolean offlineAvailable = false;

    public void toggle() {
        offlineAvailable = !offlineAvailable;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }
}
