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
    <div class="alert-warning" align="center">
        <h3>${message}</h3>
    </div>

<footer>

</footer>
</div>
</body>
</html>

