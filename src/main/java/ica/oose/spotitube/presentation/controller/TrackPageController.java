/* requirement 9  */
/* requirement 12 */
/* Track servlet. */
/* Used by: tracks.jsp , viewTracks.jsp */

package ica.oose.spotitube.presentation.controller;

import ica.oose.spotitube.domain.Track;
import ica.oose.spotitube.services.TrackService;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * TrackPageController is used for catching urls concerning tracks.
 * @author Vincent Heemskerk
 */
@Singleton
@WebServlet(name = "TrackPageController",
        loadOnStartup = 1,
        urlPatterns = {"/tracks",
                "/tracksByPerformer",
                "/addTrack",
                "/deleteTrack"})
public class TrackPageController extends HttpServlet {

    private TrackService trackService = new TrackService();
    private List<Track> tracks;

    /**
     * @author Vincent Heemskerk
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException {
        String userPath = request.getServletPath();
        System.out.println(userPath);

        if (userPath.equals("/tracks")) {
            tracks = trackService.findAll();
            request.setAttribute("tracks", tracks);
        } else if (userPath.equals("/tracksByPerformer")) {
            String performer = request.getParameter("performer");
            tracks = trackService.getTracksByBandname(performer);
            request.setAttribute("tracks", tracks);
        }

        String url = "/WEB-INF/view/tracks.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {
        String userPath = request.getServletPath();

        if (userPath.equals("/addTrack")) {
            String performer = request.getParameter("performer");
            String title = request.getParameter("title");
            String url = request.getParameter("url");
            double duration = Double.parseDouble(request.getParameter("duration"));

            trackService.create(performer, title, url, duration);
            //TODO: 13-5-2016 : create popup box with "track created" message
            tracks = trackService.findAll();
            request.setAttribute("tracks", tracks);
        } else if (userPath.equals("/deleteTrack")) {
            System.out.println("deleting track");
            int trackId = Integer.parseInt(request.getParameter("trackId"));
            trackService.delete(trackId);
            tracks = trackService.findAll();
            request.setAttribute("tracks", tracks);
        }

        String url = "/WEB-INF/view/tracks.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
