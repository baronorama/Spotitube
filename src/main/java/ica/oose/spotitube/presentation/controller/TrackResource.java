/* Jersey JAX-RS */
/* for REST */
/* JSON output */
/* Requirement 6 */
/* Requirement 7 */

package ica.oose.spotitube.presentation.controller;

import ica.oose.spotitube.domain.Track;
import ica.oose.spotitube.services.TrackService;
import ica.oose.spotitube.services.TrackServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created by Vincent on 10-12-2015.
 * REST resources for tracks
 */

@Path("/tracks")
public class TrackResource {
    private final int ok = 200;
    private TrackServiceInterface trackService = new TrackService();

    @GET
    @Produces("text/plain")
    public Response main() {
        String output = "This is the main track page";
        return Response.status(ok).entity(output).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response createTrack(@FormParam("performer") String performer,
                                @FormParam("title") String title,
                                @FormParam("url") String url,
                                @FormParam("duration") double duration) {
        trackService.create(performer, title, url, duration);
        return Response.status(Response.Status.CREATED)
                .entity("A new track with title " + title + " has been created on /track with POST")
                .header("Location", "localhost:8080/spotitube/tracks")
                .build();
    }

  //  @PUT


    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response deleteTrack(@FormParam("trackId") int trackId) {
        trackService.delete(trackId);
        return Response.status(Response.Status.CREATED)
                .entity("Track with trackId " + trackId + " has been deleted via /track with POST")
                .header("Location", "localhost:8080/spotitube/tracks")
                .build();
    }

    @GET
    @Path("/plain")
    @Produces("text/plain")
    public Response getTracksPlain() {
        String output = trackService.findAll().toString();
        return Response.status(ok).entity(output).build();
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
/*
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response createTrack(@FormParam("performer") String performer,
                                @FormParam("title") String title,
                                @FormParam("url") String url,
                                @FormParam("duration") double duration) {
        trackService.create(performer, title, url, duration);
        return Response.status(Response.Status.CREATED)
                .entity("A new track with title " + title + " has been created")
                .header("Location", "localhost:8080/spotitube/tracks")
                .build();
    }
 */
}

