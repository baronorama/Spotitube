<%--
requirement 9
requirement 11
Uses TrackPageController.java
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 12-12-2015
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Overview all tracks</title>
        <%-- get link to css right! --%>
<%--
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/../css/style.css" />
--%>
        <style><%@include file="../css/style.css" %></style>
    </head>
    <body>
        <div id=header">
            <h1 align="center">View tracks</h1>
        </div>
        <div id="main">
            <table class="overviewTable">
                <tr>
                    <td>trackId</td>
                    <td>Performer</td>
                    <td>Title</td>
                    <td>URL</td>
                    <td>Duration</td>
                </tr>
                <c:forEach items="${tracks}" var="track">
                    <tr>
                        <td><c:out value="${track.trackId}"/></td>
                        <td><c:out value="${track.performer}"/></td>
                        <td><c:out value="${track.title}"/></td>
                        <td><c:out value="${track.url}"/></td>
                        <td><c:out value="${track.duration}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
