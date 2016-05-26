/* This is for JAX-RS / REST */
package ica.oose.spotitube.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Vincent on 26-11-2015.
 */
@Path("/hello")
public class JerseyService {

    @GET
    @Path("/{param}")
    public Response getMessage(@PathParam("param") String message) {
        String output = "Computer says: Hello, you're in Spotitube! " + message;
        return Response.status(200).entity(output).build();
    }
}
