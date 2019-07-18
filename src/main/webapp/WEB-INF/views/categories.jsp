<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilkiv
  Date: 06.06.2019
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<div>
    <h2>Add new category</h2>
    <a href="<c:url value="/add-category"/>">Add</a>
</div>
<br>
<table border='1' width='50%'>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td><a href="<c:url value="/edit-category?c_id=${c.id}"/>">Edit</a></td>
            <td><a href="<c:url value="/delete-category?c_id=${c.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
