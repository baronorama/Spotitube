/* This is for JSP */
/* Is used by viewPlaylists.jsp */

package ica.oose.spotitube.services.servlets;

import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.TrackDAO;
import ica.oose.spotitube.domain.Track;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Vincent on 22-1-2016.
 */
@WebServlet
public class TrackServlet extends HttpServlet {
    private DatabaseProperties databaseProperties;
    private TrackDAO trackDAO;

    @Override
    public void init() throws ServletException {
        // required initialization
        databaseProperties = new DatabaseProperties();
        trackDAO= new TrackDAO(databaseProperties);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get all tracks from database
        List<Track> tracks = trackDAO.findAll();

        // put data on screen
        PrintWriter out = response.getWriter();
        out.println ( "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html> \n" +
                "<head> \n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
                "<title>Overview tracks</title> \n" +
                "</head> \n" +
                "<body> \n" +
                "<table>" +
                "<thead>" +
                "<th>TrackId</th>" +
                "<th>Bandname</th>" +
                "<th>Title</th>" +
                "<th>URL</th>" +
                "<th>Duration</th>" +
                "</thead>" +
                "<tbody>");
        for(Track track: tracks) {
            out.println(
                    "<tr>" +
                            "<td>" + track.getTrackId() + "</td>" +
                            "<td>" + track.getPerformer() + "</td>" +
                            "<td>" + track.getTitle() + "</td>" +
                            "<td>" + track.getUrl() + "</td>" +
                            "<td>" + track.getDuration() + "</td>");
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
