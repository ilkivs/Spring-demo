<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ilkiv
  Date: 12.06.2019
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
</head>
<body>
<h2>Edit category</h2>
<spring:form modelAttribute="category" action="/edit-category" method="post">
    <spring:input path="id" hidden="true"/>
    <label for="name">Name</label>
    <spring:input path="name" id="name"/>
    <label for="description">Description</label>
    <spring:input path="description" id="description" />
    <button type="submit">Submit</button>
</spring:form>
<div>
    <a href="<c:url value="/add-product"/>">Add new product</a>
</div>
<br>
<table border='1' width='50%'>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="p" items="${category.products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>${p.price}</td>
            <td><a href="<c:url value="/edit-product?c_id=${p.id}"/>">Edit</a></td>
            <td><a href="<c:url value="/delete-product?c_id=${p.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
