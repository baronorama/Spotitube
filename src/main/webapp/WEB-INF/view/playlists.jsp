<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 22-04-2016
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%--
requirement 9
requirement 11
Uses PlaylistPageController.java
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Overview all playlists</title>
    <%-- get link to css right! --%>
    <%--
            <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/../css/style.css" />
    --%>
    <style><%@include file="../css/style.css" %></style>
</head>
<body>
<div id=header">
    <h1 align="center">View playlists</h1>
</div>
<div id="main">
            <table class="overviewTable">
                <tr>
                    <th>idPlaylist</th>
                    <th>Owner</th>
                    <th>Name</th>
                </tr>
                <c:forEach items="${playlists}" var="playlist">
                    <tr>
                        <td><c:out value="${playlist.playlistId}"/></td>
                        <td><c:out value="${playlist.owner}"/></td>
                        <td><c:out value="${playlist.name}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
