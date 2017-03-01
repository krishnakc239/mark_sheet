<%--
  Created by IntelliJ IDEA.
  User: krishna KC
  Date: 12/28/2016
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="domains.User" %><%
    User user = (User)session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../index.jsp");

    }
%>
<meta name="viewport" content="width= device-width" initial-scale="1" media="all">
<script src="../jquery-3.1.1.js"></script>
<style type="text/css">
    <%@include file="../bootstrap.min.css" %>
</style>
<script src="../bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/style.css">
<header>
    <div class="navbar ">
        <ul class="nav nav-tabs nav-justified ">
            <li><a href="home?page=home">Home</a></li>
            <c:choose>
                <c:when test="${sessionScope.user.role=='admin'}">
                    <li><a href="userList?page=userList">User</a></li>
                    <li><a href="studentList?page=studentList">Student</a></li>
                    <li><a href="subjectList?page=subjectList">Subject</a></li>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${sessionScope.user.role=='teacher'}">
                            <li><a href="studentList?page=studentList">Student</a></li>
                            <li><a href="subjectList?page=subjectList">Subject</a></li>
                            <li><a href="markList?page=markList">Marks</a></li>
                            <li><a href="m?page=viewMarkSheet">View Marksheet</a></li>
                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
            <li><a href="logout?page=logout">Logout</a></li>
        </ul>
    </div>
</header>
