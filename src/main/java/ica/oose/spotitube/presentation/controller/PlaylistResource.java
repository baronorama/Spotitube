/* Jersey JAX-RS */
/* JSON output */
/* Requirement 6 */
/* Requirement 7 */

package ica.oose.spotitube.presentation.controller;

import ica.oose.spotitube.domain.Playlist;
import ica.oose.spotitube.services.PlaylistService;
import ica.oose.spotitube.services.PlaylistServiceInterface;

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

@Path("/playlists")
public class PlaylistResource {
    private PlaylistServiceInterface playlistService = new PlaylistService();

    @GET
    @Produces("text/plain")
    public Response main() {
        String output = "This is the main playlist page";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/plain")
    @Produces("text/plain")
    public Response getTracksPlain() {
        String output = playlistService.findAll().toString();
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getTracks() {
        return playlistService.findAll();
    }

    @GET
    @Path("select/{playlistId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> select(@PathParam("playlistId") int playlistId) {
        return playlistService.getPlaylist(playlistId);
    }
}

