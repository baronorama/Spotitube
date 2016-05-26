/* This is for Jersey  / JAX-RS REST */
/* This should use Guice, I think? */
package ica.oose.spotitube.services;

import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.PlaylistDAO;
import ica.oose.spotitube.domain.Playlist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Vincent on 4-12-2015.
 */
@Path("/playlist")
public class PlaylistService {
    private DatabaseProperties databaseProperties = new DatabaseProperties();
    private PlaylistDAO playlistDAO = new PlaylistDAO(databaseProperties);

    @GET
    public Response mainPagePlaylists() {
        String mainPagePlaylists = "This is the main page of the playlists.\n" +
                "To see the playlists of a specific owner, enter the name after the url.";
        return Response.status(200).entity(mainPagePlaylists).build();
    }

    @GET
    @Produces("text/plain")
    @Path("/{param}")
    public Response getAllPlaylists(@PathParam("param") String owner) {
        // get all playlists from database
        List<Playlist> playlists = playlistDAO.findByOwner(owner);

        String output = "The requested playlists are:\n\n";
        for (Playlist playlist : playlists) {
            output += playlist.toString();
        }
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/json/{param}")
    public List<Playlist> getAllPlaylistsJson(@PathParam("param") String owner) throws Exception {
        // get all playlists from database
        List<Playlist> playlists = playlistDAO.findByOwner(owner);

        System.out.println("playlist length: " + playlists.size());

        return playlists;
    }

/* All methods under this line do not work yet! */
    @GET
    @Produces("text/plain")
    @Path("/create/{owner}&{name}")
    public Response createPlaylists(@PathParam("owner") String owner, @PathParam("name") String name) {
        playlistDAO.create(owner, name);
        String output = "Playlist " + name + " created with owner " + owner + ".\n";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("text/plain")
    @Path("/update/{idplaylist}&{name}")
    public Response updatePlaylists(@PathParam("idplaylist") int idplaylist, @PathParam("name") String name) {
        playlistDAO.update(idplaylist, name);
        String output = "Playlist " + idplaylist + " is updated.";
        return Response.status(200).entity(output).build();
    }
}
