package ica.oose.spotitube.presentation.controller;

import com.google.inject.Singleton;
import ica.oose.spotitube.domain.User;
import ica.oose.spotitube.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vincent on 20-5-2016.
 * requirement 9
 * requirement 12
 * Manage servlet
 * Used by: manage.jsp
 */

@Singleton
@WebServlet(
        name = "UserPageController",
        loadOnStartup = 1,
        urlPatterns = {
                "/users",
                "/showUsers",
                "/addUser",
                "/deleteUser"
                })
public class UserPageController extends HttpServlet {
    private UserService userService = new UserService();
    private List<User> users;

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        System.out.println(userPath);

        if (userPath.equals("/users")) {
            System.out.println("in users");
            users = userService.getAllUsers();
            request.setAttribute("users", users);
        } else if (userPath.equals("/showUsers")) {
            System.out.println("in showUsers");
            users = userService.getAllUsers();
            request.setAttribute("users", users);
        }

        String url = "/WEB-INF/view/users.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            System.out.println("in catch of GET_ManagerPageController");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {
        String userPath = request.getServletPath();

        if (userPath.equals("/addUser")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            userService.addUser(username, password);
            //TODO: give message that user is created
            users = userService.getAllUsers();
            request.setAttribute("users", users);
        }

        if (userPath.equals("/deleteUser")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            System.out.println("deleting user with userId " + userId + ".");
            userService.deleteUser(userId);
            users = userService.getAllUsers();
            request.setAttribute("users", users);
        }

        String url = "/WEB-INF/view/users.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
