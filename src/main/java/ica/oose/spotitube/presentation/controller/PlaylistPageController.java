/* requirement 9  */
/* requirement 12 */
/* Track servlet. */
/* Used by: tracks.jsp , viewTracks.jsp */

package ica.oose.spotitube.presentation.controller;

import ica.oose.spotitube.domain.Playlist;
import ica.oose.spotitube.services.PlaylistService;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vincent on 4-12-2015.
 */
@Singleton
@WebServlet(name="PlaylistPageController",
        loadOnStartup = 1,
        urlPatterns = {"/playlists",
                "/playlistsByOwner",
                "/addPlaylist",
                "/deletePlaylist"})
public class PlaylistPageController extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    PlaylistService playlistService = new PlaylistService();
    List<Playlist> playlists;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String userPath = request.getServletPath();

        if(userPath.equals("/playlists")) {
            playlists = playlistService.findAll();
            request.setAttribute("playlists", playlists);
        }
        else if (userPath.equals("/playlistsByOwner")) {
            String owner = request.getParameter("owner");
            playlists = playlistService.getPlaylistsByOwner(owner);
            request.setAttribute("playlists", playlists);
        }

        String url = "/WEB-INF/view/playlists.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //TODO: implement doPost for putting data in database or deleting or updating data
        String userPath = request.getServletPath();

        if(userPath.equals("/addPlaylist")) {
            String owner = request.getParameter("owner");
            String name = request.getParameter("name");

            playlistService.create(owner, name);
            //TODO: create popup box with "playlist created" message
            playlists = playlistService.getPlaylistsByOwner(owner);
            request.setAttribute("playlists", playlists);
        }

        else if(userPath.equals("/deletePlaylist")) {
            String owner = request.getParameter("owner");
            System.out.println("deleting playlist");
            int playlistId = Integer.parseInt(request.getParameter("playlistId"));
            playlistService.delete(playlistId);
            playlists = playlistService.getPlaylistsByOwner(owner);
            request.setAttribute("playlists", playlists);
        }

        String url = "/WEB-INF/view/playlists.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
