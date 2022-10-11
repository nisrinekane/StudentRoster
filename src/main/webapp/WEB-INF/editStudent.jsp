<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/10/22
  Time: 9:15 AM
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
<a href="/students" class="btn btn-primary">dashboard</a>
<form:form action="/students/${student.id}/update" method="post" modelAttribute="student" class="form">
    <input type="hidden" name="_method" value="put">
    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName" />
    <div>
        <form:errors path="firstName" class="text-danger"/>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName" />
        <div>
            <form:errors path="lastName" class="text-danger"/>
        </div>
    </div>
    <div class="form-group">
        <form:select path="dorm">
            <c:forEach var="dorm" items="${dorms}">
                <!--- Each option VALUE is the id of the dorm --->
                <option value="${dorm.id}">
                    <!--- This is what shows to the user as the option --->
                    <c:out value="${dorm.name}"/>
                </option>
            </c:forEach>
        </form:select>
    </div>
    <input type="submit" value="Submit" class="btn btn-dark" />
</form:form>
</body>
</html>


