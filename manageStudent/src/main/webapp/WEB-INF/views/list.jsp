<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DUNGMAMA
  Date: 4/1/2019
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>

<form:form action="/searchStudent" method="post">
    <table>
        <tr>
            <td>Student ID </td>
            <td><input type="text" name="ID" value="ID" placeholder="ID"/></td>
            <td><input type="submit" name="search" value="Search"/></td>
        </tr>
    </table>
</form:form>

<a href="/add">Add new student</a>
<form action="/list"  method="post">
    <p>
        <c:if test="${message != null}">
            <span style="color: green">${message}</span>
        </c:if>
    </p>
    <fieldset>
        <legend>Student List</legend>
        <table border="2">
            <tr>
                <b><td>Name</td></b>
                <b><td>Age : </td></b>
                <b><td>Address : </td></b>
                <b><td>Sex : </td></b>
                <b><td>Classroom : </td></b>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><a href="/view?id=${student.id}">${student.name}</a></td>
                    <td>${student.age}</td>
                    <td>${student.address}</td>
                    <td>${student.sex}</td>
                    <td>${student.classroom}</td>
                    <td><a href="/edit?id=${student.id}">edit<br></a> </td>
                    <td><a href="/delete?id=${student.id}">delete<br></a> </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</form>
</body>
</html>
