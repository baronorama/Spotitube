/* This is for JSP */
/* Is used by viewPlaylists.jsp */

package ica.oose.spotitube.services.servlets;

import ica.oose.spotitube.datasource.util.*;
import ica.oose.spotitube.domain.Playlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

/**
 * Created by Vincent on 9-12-2015.
 */

@WebServlet
public class PlaylistServlet extends HttpServlet {
    private DatabaseProperties databaseProperties;
    private PlaylistDAO playlistDAO;

    @Override
    public void init() throws ServletException {
        // required initialization
        databaseProperties = new DatabaseProperties();
        playlistDAO = new PlaylistDAO(databaseProperties);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String owner = request.getParameter("owner");
        // get all playlists from database
        List<Playlist> playlists = playlistDAO.findByOwner(owner);

        // put data on screen
        PrintWriter out = response.getWriter();
        out.println ( "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html> \n" +
                    "<head> \n" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
                        "<title>Overview playlists</title> \n" +
                    "</head> \n" +
                    "<body> \n" +
                        "<table>" +
                            "<thead>" +
                                "<th>PlaylistId</th>" +
                                "<th>Owner</th>" +
                                "<th>playlist name</th>" +
                            "</thead>" +
                            "<tbody>");
                                for(Playlist playlist : playlists) {
                                    out.println(
                                        "<tr>" +
                                        "<td>" + playlist.getPlaylistId() + "</td>" +
                                        "<td>" + playlist.getOwner() + "</td>" +
                                        "<td>" + playlist.getName() + "</td>");
                                }
                    out.println("</tbody>" +
                            "</table>" +
                    "</body>" +
                "</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

}
