<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 2/28/2023
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<%@ include file="../include/nav.jsp"%>

<div class="container">
  <div class="table-responsive">
    <table class="table">
      <tr>
        <th>id</th>
        <th>Full Name</th>
        <th>Username</th>
        <th>password</th>
        <th>Role</th>
      </tr>

      <c:forEach items="${userList}" var="student">
        <tr>
          <td>${student.id}</td>
          <td>${student.fullName}</td>
          <td>${student.userName}</td>
          <td>${student.password}</td>

          <td><a href="user?page=userDetails&id=${student.id}">View Details</a></td>
        </tr>
      </c:forEach>

    </table>
  </div>
  <a href="user?page=newUsers"><h4>Add New User</h4></a>
</div>

</div>

</body>
</html>
