<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 22-1-2016
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Manage tracks</title>
    <%-- get link to css right! --%>
    <%--
            <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/../css/style.css" />
    --%>
    <style><%@include file="/WEB-INF/css/style.css" %></style>
</head>
<body>
    <div id=header">
        <h1 align="center">Add playlists</h1>
    </div>
    <div id="main">
        <form name="addPlaylist" method="post" action="addPlaylist" class="userform">
            Add playlist: <br/>
            <label for="owner">Owner:</label><input type="text" name="owner" id="owner"/><br/>
            <label for="name">Name of playlist:</label><input type="text" name="name" id="name"/><br/>
            <button type="submit" name="addPlaylistButton">Add playlist</button>
        </form>

        <form name="deletePlaylist" method="post" action="deletePlaylist" class="userform">
            Delete playlist:<br/>
            <label for="owner">Owner:</label><input type="text" name="owner" id="owner"/><br/>
            <label for="playlistId">ID playlist</label><input type="text" name="playlistId" id="playlistId"/><br/>
            <button type="submit" name="deletePlaylistButton">Delete playlist</button>
        </form>
    </div>
</body>
</html>
