package ica.oose.spotitube.datasource.util.fake;

import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.TrackDAO;
import ica.oose.spotitube.domain.Track;
import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vincent on 13-12-2015.
 */
public class FakeTrackDAO extends TrackDAO {
    public FakeTrackDAO(DatabaseProperties databaseProperties) {
        super(databaseProperties);
    }
    @Override
    public List<Track> findAll() {
        Track track = new Track(1, "test", "test", "www.test.nl", (double) 1);
        List<Track> tracks = new ArrayList<Track>((Collection<? extends Track>) track);
        return tracks;
    }
}
