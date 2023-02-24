<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 2/22/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List User</title>

</head>
<body>

<div id="wrapper">

    <!-- Sidebar -->
<%--    <%@include file="../includes/sidebar.jsp" %>--%>

    <div class="container">
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>Full Name</th>
                    <th>Username</th>
                    <th>password</th>
<%--                    <th>Role</th>--%>
                </tr>

                <c:forEach items="${studentlist}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.fullName}</td>
                        <td>${student.userName}</td>
                        <td>${student.password}</td>

                        <td><a href="user?page=userDetails&id=${student.id}">View Details</a></td>
                    </tr>
                </c:forEach>

<%--                <c:forEach var="i" begin="1" end="5">--%>
<%--                    Item <c:out value="${i}"/><p>--%>

<%--                </p>--%>
<%--                </c:forEach>--%>

            </table>
        </div>

</body>
</html>
