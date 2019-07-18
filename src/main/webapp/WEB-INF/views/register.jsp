<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body class="text-center">
<spring:form class="form-signin" action="/register" modelAttribute="user" method="post">
    <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72"
         height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label for="inputUsername" class="sr-only">Username</label>
    <spring:input path="username" type="text" id="inputUsername" class="form-control" placeholder="Username" autofocus="true"/>

    <label for="inputEmail" class="sr-only">Email</label>
    <spring:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email"/>

    <label for="inputPassword" class="sr-only">Password</label>
    <spring:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password" />

    <label for="inputRepeatedPassword" class="sr-only">Repeated Password</label>
    <spring:input path="repeatedPassword" type="password" id="inputRepeatedPassword" class="form-control" placeholder="RepeatedPassword" />

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</spring:form>
</body>
</html>
