<%-- This is for JSP --%>
<%-- Is used PlaylistServlet.java --%>
<%-- How to get data from database? --%>
<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 7-12-2015
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Playlist</title>
    </head>
    <body>
    <form action="playlistsByOwner"> Please enter a name <br>
        <input type="text" name="owner"size="20px">
        <input type="submit" value="submit">
    </form>
</body>
</html>