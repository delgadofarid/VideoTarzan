<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fdelgado
  Date: 15/12/2018
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Video Tarzan</title>

    <!-- Datatable Jquery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Datatables Jquery JS -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

    <!-- Fontawesome Icons -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

    <!-- Datatables Jquery CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="<c:url value="/" />">Video Tarzan</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">Home <span class="sr-only">(current)</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/movie/movieList" />">Movies</span></a>
                </li>
            </ul>
            <ul class="navbar-nav float-right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a class="nav-link">Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                    <li><form action="<c:url value="/perform_logout" />" method="post" style="display: inline-block;"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><input class="nav-link btn btn-link" type="submit" value="Logout"></form></li>
                    <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name != 'admin'}">
                        <li><a href="<c:url value="/customer/cart" />" class="nav-link">Cart</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="<c:url value="/admin" />" class="nav-link">Admin</a></li>
                    </c:if>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a class="nav-link" href="<c:url value="/login" />">Login</a></li>
                    <li><a class="nav-link" href="<c:url value="/register" />">Register</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

<main role="main">