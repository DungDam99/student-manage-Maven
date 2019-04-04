<%--
  Created by IntelliJ IDEA.
  User: DUNGMAMA
  Date: 4/3/2019
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<form:form method="post" action="/editStudent" modelAttribute="student">
    <fieldset>
        <legend>Student details</legend>
        <table>
            <tr>
                <td>Id : </td>
                <td>${student.id}</td>
            </tr>
            <tr>
                <td>Name : </td>
                <td>${student.name}</td>
            </tr>
            <tr>
                <td>Age : </td>
                <td>${student.age}</td>
            </tr>
            <tr>
                <td>Sex : </td>
                <td>${student.sex}</td>
            </tr>
            <tr>
                <td>Address : </td>
                <td>${student.address}</td>
            </tr>
            <tr>
                <td>Classroom : </td>
                <td>${student.classroom}</td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
