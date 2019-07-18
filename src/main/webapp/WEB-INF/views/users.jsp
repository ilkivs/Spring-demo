<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilkiv
  Date: 19.06.2019
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border='1' width='50%'>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Password</th>
        <th>Roles</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>
                <c:forEach var="r" items="${u.roles}">
                    <c:out value="${r.id}"/>
                    <c:out value="${r.name}"/>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
