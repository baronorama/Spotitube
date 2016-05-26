/* Jersey JAX-RS */
/* JSON output */
/* Requirement 6 */
/* Requirement 7 */

package ica.oose.spotitube.presentation.controller;

import com.google.inject.Inject;
import ica.oose.spotitube.domain.Track;
import ica.oose.spotitube.services.TrackService;
import ica.oose.spotitube.services.TrackServiceInterface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created by Vincent on 10-12-2015.
 */

@Path("/tracks")
public class TrackResource {
    private TrackServiceInterface trackService = new TrackService();

    @GET
    @Produces("text/plain")
    public Response main() {
        String output = "This is the main track page";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/plain")
    @Produces("text/plain")
    public Response getTracksPlain() {
        String output = trackService.findAll().toString();
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracks() {
        return trackService.findAll();
    }

    @GET
    @Path("select/{trackId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> select(@PathParam("trackId") int trackId) {
        return trackService.getTrack(trackId);
    }
}

