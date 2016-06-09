<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 22-5-2016
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spotitube User Manager</title>
</head>
<body>
<h1>Managing users</h1>
<p>Page for managing users</p>

<form name="showUsers" method="get" action="showUsers" class=userForm">
    <label for="showUsers">Show all users</label><input type="submit" name="showUsers" id="ShowUsers" value="Show all users">
</form>

<form name="addUser" method="post" action="addUser" class="userform">
    Add user: <br/>
    <label for="username">Username:</label><input type="text" name="username" id="username"/><br/>
    <label for="password">Password:</label><input type="text" name="password" id="password"/><br/>
    <label for="isPaidAccount">paid account:</label><input type="checkbox" name="isPaidAccount" id="isPaidAccount" value="true" /><br/>
    <label for="isAdmin">is admin account:</label><input type="checkbox" name="isAdmin" id="isAdmin" value="true" /><br/>
    <!-- //TODO: send false and true values through checkboxes -->
    <button type="submit" name="addUserButton">Add user</button>
</form>

<form name="resetPassword" method="post" action="resetPassword" class="userform">
    Reset password:<br/>
    <label for="userId">UserId:</label><input type="text" name="userId" id="userId"/><br/>
    <button type="submit" name="resetPasswordButton">Delete user</button>
</form>

<form name="deleteUser" method="post" action="deleteUser" class="userform">
    Delete user:<br/>
    <label for="username">Username:</label><input type="text" name="username" id="username"/><br/>
    <button type="submit" name="deleteUserButton">Delete user</button>
</form>
</body>
</html>
