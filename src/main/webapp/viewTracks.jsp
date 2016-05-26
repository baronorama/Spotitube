<%-- This is for JSP --%>
<%-- Is used TrackServlet.java --%>
<%-- Requirement 11 --%>
<%--
Created by IntelliJ IDEA.
User: Vincent
Date: 11-12-2015
Time: 12:10
To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Tracks</title>
    </head>
    <body>
        <form action="tracksByPerformer">To search the tracks, please enter a performer<br />
            <input type="text" name="performer"size="20px">
            <input type="submit" value="submit">
        </form>
    </body>
</html>