<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/10/22
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/styles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<html>
<head>
    <title>student roster</title>
</head>
<body>
<a href="/courses" class="btn btn-primary">dashboard</a>
<form:form action="/courses/${course.id}/update" method="post" modelAttribute="course" class="form">
    <input type="hidden" name="_method" value="put">
    <form:label path="name">Course Name</form:label>
    <form:input path="name" />
    <div>
        <form:errors path="name" class="text-danger"/>
    </div>
    <input type="submit" value="Submit" class="btn btn-dark" />
</form:form>
</body>
</html>


