<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width= device-width" initial-scale="1" media="all">
    <script src="../jquery-3.1.1.js"></script>
    <style type="text/css">
        <%@include file="../bootstrap.min.css" %>
    </style>
    <script src="../bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
    <%@include file="../includes/header.jsp"%>

    <%@include file="../includes/menu.jsp"%>

    <div>
        <form  class="form" method="post" action="addstudent">
            <input type="hidden" name="page" value="addstudent">
            <table class="table">
                <tr>
                    <th>Student Name</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Roll</th>
                    <td><input type="text" name="roll"></td>
                </tr>
                <tr>
                    <th>Faculty</th>
                    <td><input type="text" name="faculty"></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <th>Age</th>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td><input type="text" name="gender"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add Student"></td>
                </tr>
            </table>
        </form>

    </div>

</div>
</body>
</html>
