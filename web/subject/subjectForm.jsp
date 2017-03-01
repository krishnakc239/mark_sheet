<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width= device-width" initial-scale="1" media="all">
    <script src="../css/jquery-3.1.1.js"></script>
    <style type="text/css">
        <%@include file="../bootstrap.min.css" %>
    </style>
    <script src="../bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
    <%@include file="../includes/header.jsp"%> <!-- end of templatemo_header -->

    <%@include file="../includes/menu.jsp"%> <!-- end of templatemo_menu -->

    <div>
        <form class="form" method="post" action="addsubject">
            <input type="hidden" name="page" value="addsubject">
            <input type="hidden" name="id" value="${subject.id}">
            <table class="table">
                <tr>
                    <th>Subject Code</th>
                    <td><input type="text" name="code" ></td>
                </tr>
                <tr>
                    <th>Subject Name</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Pass Mark</th>
                    <td><input type="text" name="PM" ></td>
                </tr>
                <tr>
                    <th>Full Mark</th>
                    <td><input type="text" name="FM" ></td>
                </tr>
                <tr>
                    <th>Batch</th>
                    <td><input type="text" name="batch" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add Subject"></td>
                </tr>
            </table>
        </form>

    </div>

</div>
</body>
</html>
