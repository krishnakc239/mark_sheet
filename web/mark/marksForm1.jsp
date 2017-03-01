<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Marksheet####</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="jquery-3.1.1.js"></script>
    <style type="text/css">
        <%@include file="../css/bootstrap.min.css" %>
    </style>
    <script src="bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div class="container">
    <%@include file="../includes/header.jsp"%>
    <%@include file="../includes/menu.jsp"%>
                <div class="content_section">
                    <h2>Add student's marks respectively!!!</h2>

                </div>

                <form action="addMarks" method="post" name="marksheetForm"><!--marksheetForm sevlet name is calling-->
                    <input type="hidden" name="page" value="viewMarksheet">
                    <table class="table">
                        <tr>
                            <th>Student Name</th>
                            <td>
                                <input type="text" value="${student.name}"/>
                                <%--<c:forEach items="${studentList}" var="student">--%>
                                    <%--<select >--%>
                                        <%--<option vlaue="${student.name}">${student.name}</option vlaue="${student.name}">--%>
                                    <%--</select>--%>
                                <%--</c:forEach>--%>
                            </td>

                        </tr>

                        <tr>
                            <th>Roll </th>
                            <td>
                                <input type="text" name="roll" value="${student.roll}" readonly/>
                            </td>

                        </tr>

                        <tr>
                            <th>Feculty</th>
                            <td>
                                <input type="text" name="faculty" value="${student.faculty}" readonly/>
                            </td>

                        </tr>

                        <tr>
                            <td colspan="2"><h3>Marks Obtained</h3> </td>
                        </tr>

                        <tr>
                            <c:forEach items="${subjectList}" var="subject">
                        <tr>
                            <td> ${subject.name}</td>
                            <td> <input type="text" name="${subject.code}" id="${subject.code}" maxlength="2" size="10" required onkeypress='return event.charCode >= 48 && event.charCode <= 57' /> Out of ${subject.FM} </td>
                        </tr>
                        </c:forEach>

                        </tr>


                        <tr>
                            <td><a href="m?page=viewMarkSheet"> View Marksheet</a></td>
                            <td><button type="Reset">Reset</button></td>
                        </tr>

                    </table>
                </form>


            </div>


                <div class="marksheet">

                    <h2>Marksheet of ${student.name}</h2>

                    <table class="table">
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
</body>
</html>

<script>
    function viewMarksheet() {

        var name=document.marksheetForm.name.value;
        document.getElementById("name").innerHTML=name;

        var faculty=document.marksheetForm.faculty.value;
        document.getElementById("faculty").innerHTML=faculty;

        var roll=document.marksheetForm.roll.value;
        document.getElementById("roll").innerHTML=roll;

        document.getElementByID("$(subject.code)").innerHTML=marks;

        <%--<c:set var="total" value="${0}" />--%>

        /*switch(true) {
         case(percentage>=80):
         document.getElementById("grade").innerHTML="A+";
         break;
         case(percentage>=70): document.getElementById("grade").innerHTML="A";
         break;
         case(percentage>=60): document.getElementById("grade").innerHTML="B";
         break;
         case(percentage>=50): document.getElementById("grade").innerHTML="C";
         break;
         case(percentage>=40): document.getElementById("grade").innerHTML="D";
         break;
         case(percentage<40): document.getElementById("grade").innerHTML="Fail";
         break;
         }*/
    }
</script>