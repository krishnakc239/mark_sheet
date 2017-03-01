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
        <h3><a href="subjectForm?page=subjectForm">Add New Subject</a></h3>
        <table class="table">
              <tr>
                <th>Subject Code</th>
                <th>Subject Name</th>
                <th>Pass Mark</th>
                <th>Full Mark</th>
                <th>Batch</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>

            <c:forEach items="${subjectList}" var="subject">
                <tr>
                    <td>${subject.code}</td>
                    <td>${subject.name}</td>
                    <td>${subject.PM}</td>
                    <td>${subject.FM}</td>
                    <td>${subject.batch}</td>
                    <td><a href="subjectEdit?id=${subject.id}&page=edit"><img src="../images/edit.png"></a></td>
                    <td><a href="subjectDelete?id=${subject.id}&page=delete"><img src="../images/delete.png"></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <footer>

    </footer>
</div>
</body>
</html>

