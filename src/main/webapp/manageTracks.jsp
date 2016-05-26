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
        <h1 align="center">Add tracks</h1>
    </div>
    <div id="main">
        <form name="addTrack" method="post" action="addTrack" class="userform">
            Add track: <br/>
            <label for="performer">Performer:</label><input type="text" name="performer" id="performer"/><br/>
            <label for="title">Title:</label><input type="text" name="title" id="title"/><br/>
            <label for="url">URL:</label><input type="text" name="url" id="url"/><br/>
            <label for="duration">Duration:</label><input type="text" name="duration" id="duration"/><br/>
            <button type="submit" name="addTrackButton" class="myButton">Add track</button>
        </form>
<br/><br/>
        <form name="createTrack" method="post" action="spotitube/tracks" class="userform">
            create track with REST/POST: <br/>
            <label for="performer">Performer:</label><input type="text" name="performer" id="performer"/><br/>
            <label for="title">Title:</label><input type="text" name="title" id="title"/><br/>
            <label for="url">URL:</label><input type="text" name="url" id="url"/><br/>
            <label for="duration">Duration:</label><input type="text" name="duration" id="duration"/><br/>
            <button type="submit" name="addTrackButton" class="myButton">Add track</button>
        </form>
<br/><br/>
        <form name="deleteTrack" method="delete" action="spotitube/tracks" class="userform">
            Delete track:<br/>
            <label for="trackId">Enter trackId:</label><input type="text" name="trackId" id="trackId"><br/>
            <button type="submit" name="deleteTrackButton" class="myButton">Delete track</button>
        </form>
    </div>
</body>
</html>
