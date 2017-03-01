<%--
  Created by IntelliJ IDEA.
  User: krishna KC
  Date: 12/28/2016
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

  <title>login page</title>
  <meta name="viewport" content="width= device-width" initial-scale="1" media="all">
  <script src="jquery-3.1.1.js"></script>
  <style type="text/css">
    <%@include file="css/bootstrap.min.css" %>
  </style>
  <script src="bootstrap.min.js"></script>
    <script src="jquery.validate.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script >
        $(document).ready(function () {
            $('#form').validate({
                rules:{
                    username:{
                        required:true,
                    },
                    password:{
                        required:true,
                    }
                }
            });
        });
    </script>
</head>

<body>
<div class="container">
    <header class="nav navbar-default">
        <div align="center"><h2>ABC University, Nepal</h2></div>
        <div align="center"><a>Login Page!!</a></div>
    </header>
    <br>
  <div class="modal-content modal-body">
    <div align="center">
      <div class="alert-warning">
        <h3>${message}</h3>
      </div>

      <form class="form" method="post" action="login" id="form">
        <input type="hidden" name="page" value="login">
        <table class="table-responsive">
          <tr>
            <td>User Name:</td><td><input type="text" name="username" id="user"  required> </td>
            <td><label id="Userlabel"></label></td>
          </tr>
          <tr>
            <td><label id="labelUser"></label></td>
            <td><label id="Passwordlabel"></label></td>
          </tr>

          <tr>
            <td>Password:</td><td><input type="password" name="password" id="pass"  required><td>
          </tr>
          <tr>
            <td><label id="labelPass"></label></td>
          </tr>

          <tr>
            <td colspan="2" align="right"><input type="submit" value="Login"></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  <footer>

  </footer>
</div>
</body>
</html>

