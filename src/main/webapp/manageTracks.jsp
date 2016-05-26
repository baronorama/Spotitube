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
            <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/../css/tracks.css" />
    --%>
    <style><%@include file="/WEB-INF/css/tracks.css" %></style>
</head>
<body>
    <div id=header">
        <h1 align="center">Add tracks</h1>
    </div>
    <div id="main">
        <form name="addTrack" method="post" action="addTrack">
            Add track: <br/>
            Performer: <input type="text" name="performer" /><br/>
            Title: <input type="text" name="title" /><br/>
            URL: <input type="text" name="url" /><br/>
            Duration: <input type="text" name="duration" /><br/>
            <button type="submit" name="addTrackButton">Add track</button>
        </form>

        <form name="deleteTrack" method="post" action="deleteTrack">
            Delete track:<br/>
            Enter trackId: <input type="text" name="trackId"><br/>
            <button type="submit" name="deleteTrackButton">Delete track</button>
        </form>
    </div>
</body>
</html>
