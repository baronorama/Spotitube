<%-- First page of app --%>
<%-- Requirement 11 --%>
<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 5-12-2015
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Spotitube</title>
    </head>
    <body>
        <h1>Welcome to Spotitube, ++-edition!</h1>
        <p>It's a work in progress, but that's okay: We're here to learn.<br/>
        Cheers.</p>
        <p>
            <a href="viewPlaylists.jsp">opvragen playlists per gebruiker</a> <br />
            <a href="viewTracks.jsp">opvragen tracks per band</a> <br />
            <a href="managePlaylists.jsp">Manage playlists</a><br/>
            <a href="manageTracks.jsp">Manage tracks</a><br/>
            <a href="manageUsers.jsp">Manage users</a><br/>
            <a href="viewManager.jsp">Beheerders pagina</a><br/>

            <br/>
            <a href="/spotitube/tracks">tracks</a><br/>
            <a href="/spotitube/users">users</a><br/>

        </p>
    </body>
</html>
