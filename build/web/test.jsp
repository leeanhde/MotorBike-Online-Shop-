<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <h1>User Profile</h1>

        <h1>Change Password</h1>
        <form action="change" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="opass">Old Password:</label>
            <input type="password" id="opass" name="opass" required><br><br>
            <label for="pass">New Password:</label>
            <input type="password" id="pass" name="pass" required><br><br>
            <input type="submit" value="Change Password">
        </form>

        <%-- Display error message if provided by the servlet --%>
        <c:if test="${not empty requestScope.ms}">
            <p>${requestScope.ms}</p>
        </c:if>
    </body>
</html>