<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/10/22
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">dorm name</th>
        <th scope="col">students assigned</th>
    </tr>
    </thead>
    <tbody>
    <!-- loop over all the dorms and show students who live there -->
    <c:forEach items="${dorms}" var="dorm">
        <tr>
            <td><c:out value="${dorm.name}"/> </td>
            <td><a href="/dorms/${dorm.id}/students" class="text-info">see students</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/students/new" class="btn btn-primary">new student</a>
<a href="/courses" class="btn btn-primary">all courses</a>
</body>
</html>
