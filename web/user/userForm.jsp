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
        <%@include file="../includes/header.jsp"%> <!-- end of templatemo_header -->

        <%@include file="../includes/menu.jsp"%> <!-- end of templatemo_menu -->

        <div>
        <form  class="form" method="post" action="adduser">
            <input type="hidden" name="page" value="adduser">
            <table class="table">
                <tr>
                    <th>User Name</th>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <th>Role</th>
                    <td><input type="text" name="role"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add User"></td>
                </tr>
            </table>
        </form>

        </div>

</div>
</body>
</html>
