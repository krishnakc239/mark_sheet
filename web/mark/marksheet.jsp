<%--
  Created by IntelliJ IDEA.
  User: krishna KC
  Date: 12/27/2016
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Marksheet</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="content_section">
    <div class="marksheet">

        <h2>Marksheet of ${student.name}</h2>

        <table border="1" width="80%">
            <tr >
                <th colspan="2"> <h3 align="center">Student Info </h3></th>
            </tr>
            <tr>
                <td width="20%">Name:</td>
                <td width="60%"><h3 id="name"></h3></td>
            </tr>
            <tr>
                <td>Roll no:</td>
                <td><h3 id="roll"></h3></td>
            </tr>
            <tr>
                <td>Faculty:</td>
                <td><h3  id="faculty"></h3></td>
            </tr>

            <tr >
                <th colspan="2"> <h3 align="center">Subjects Marks</h3> </th>
            </tr>
            <c:forEach items="${subjectList}" var="subject">
                <tr>
                    <td>${subject.name}:</td>
                    <td><h3 id="${subject.id}"></h3></td>
                </tr>
            </c:forEach>

            <tr>
                <th colspan="2"> <h3 align="center"> Overall Result </h3></th>
            </tr>
            <tr>
                <td>Total:</td>
                <td> <h3 id="total"></h3></td>
            </tr>
            <tr>
                <td>Percentage:</td>
                <td><h3 id="percentage"></h3></td>
            </tr>
            <tr>
                <td>Grade:</td>
                <td><h3 id="grade"></h3></td>
            </tr>
            <tr>
                <td><button type="button" onClick="window.print()" >Print</button></td>
                <td><h3 id="btn"></h3></td>
            </tr>
        </table>


    </div>

</div>

</div>
</body>
</html>
