package ica.oose.spotitube.services.servlets;

import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.UserDAO;
import ica.oose.spotitube.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Vincent on 25-5-2016.
 */
public class UserServlet extends HttpServlet {

    private DatabaseProperties databaseProperties;
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        // required initialization
        databaseProperties = new DatabaseProperties();
        userDAO= new UserDAO(databaseProperties);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get all tracks from database
        List<User> users = userDAO.findAll();

        // put data on screen
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html> \n" +
                "<head> \n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
                "<title>Overview tracks</title> \n" +
                "</head> \n" +
                "<body> \n" +
                "<table>" +
                "<thead>" +
                "<th>UserId</th>" +
                "<th>Username</th>" +
                "<th>Password</th>" +
                "</thead>" +
                "<tbody>");
        for (User user: users) {
            out.println(
                    "<tr>" +
                            "<td>" + user.getUserId() + "</td>" +
                            "<td>" + user.getUserName() + "</td>" +
                            "<td>" + user.getPassword() + "</td>");
        }
        out.println("</tbody>" +
                "</table>" +
                "</body>" +
                "</html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
