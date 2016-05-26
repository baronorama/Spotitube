<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 20-5-2016
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%--
requirement 9
requirement 11
Uses UserPageController.java
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Overview all users</title>
        <%-- get link to css right! --%>
        <%--
                <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/../css/style.css" />
        --%>
        <style><%@include file="../css/style.css" %></style>
    </head>
    <body>
        <div id=header">
            <h1 align="center">View users</h1>
        </div>
        <div id="main">
            <table class="overviewTable">
                <tr>
                    <th>idUsers</th>
                    <th>Name</th>
                    <th>Password</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.userId}"/></td>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.password}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
