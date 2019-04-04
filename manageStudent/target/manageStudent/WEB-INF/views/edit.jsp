<%--
  Created by IntelliJ IDEA.
  User: DUNGMAMA
  Date: 4/3/2019
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Information</title>
</head>
<body>
<form:form method="post" action="/editStudent" modelAttribute="student">
    <p>
        <c:if test="${message != null}">
            <span style="color: green">${message}</span>
        </c:if>
    </p>
    <fieldset>
        <legend>Student details</legend>
        <table>
            <tr><form:hidden path="id"></form:hidden></tr>
            <tr>
                <td>Name : </td>
                <td><form:input path="name" value="${student.name}"/></td>
            </tr>
            <tr>
                <td>Age : </td>
                <td><form:input path="age" value="${student.age}"/></td>
            </tr>
            <tr>
                <td>Sex : </td>
                <td><form:input path="sex" value="${student.sex}"/></td>
            </tr>
            <tr>
                <td>Address : </td>
                <td><form:input path="address" value="${student.address}"/></td>
            </tr>
            <tr>
                <td>Classroom : </td>
                <td><form:input path="classroom" value="${student.classroom}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Edit</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
