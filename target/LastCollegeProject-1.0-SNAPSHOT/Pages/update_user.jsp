<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 2/28/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
< <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<div id="wrapper">

    <%@ include file="../include/nav.jsp"%>
    <div class="container">
        <h1>Admin Registration Form</h1>
        <form action="user?page=editUser" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <h3>Step 1 :</h3>
            <div class="form-w3step1">
                <input type="text" name="full_name" value="${student.fullName}" placeholder="Enter full name">
<%--                <input type="text" name="role" value="${user.role}" placeholder="Enter role">--%>
            </div>
            <h3>Step 2 :</h3>
            <div class="form-w3step1 w3ls-formrow">
                <input type="text" name="username" value="${student.userName}" placeholder="Enter a username">
                <input type="password" name="password" value="${student.password}" placeholder="Enter a password">
            </div>
            <input type="submit" value="Update User" name="submit">
            <input type="reset" value="Reset" name="reset">
        </form>
    </div>
</div>

</body>
</html>
