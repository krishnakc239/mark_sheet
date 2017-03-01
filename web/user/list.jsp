<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <meta name="viewport" content="width= device-width" initial-scale="1" media="all">
    <script src="../jquery-3.1.1.js"></script>
    <style type="text/css">
        <%@include file="../bootstrap.min.css" %>
    </style>
    <script src="../bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="container">
    <%@include file="../includes/header.jsp"%>
    <%@include file="../includes/menu.jsp"%>
    <div>
        <div align="center"><h3>${message}</h3></div>
        <h3><a href="userForm?page=userForm">Add New User</a></h3>
        <table class="table">
              <tr>
                <th>User Name</th>
                <th>Password</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>

            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>
                    <td><a href="userEdit?id=${user.id}&page=edit"><img src="../images/edit.png"></a></td>
                    <td><a href="userDelete?id=${user.id}&page=delete"><img src="../images/delete.png"></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <footer>

    </footer>
</div>
</body>
</html>

