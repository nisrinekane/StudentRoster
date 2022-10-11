<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/10/22
  Time: 11:25 AM
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
    <th scope="col">Course Id</th>
    <th scope="col">Course Name</th>
    <th scope="col">Edit</th>
    <th scope="col">Delete</th>
    <th scope="col">Students Enrolled</th>
  </tr>
  </thead>
  <tbody>
  <!-- loop over all the courses to show the details as in the wireframe! -->
  <c:forEach items="${courses}" var="course">
    <tr>
      <td><c:out value="${course.id}" /></td>
      <td><a href="/courses/${course.id}"><c:out value="${course.name}"/> </a></td>
      <td><a class="btn btn-warning" href="/courses/${course.id}/edit" >edit</a></td>
      <td>
        <form action="/courses/${course.id}" method="post">
          <input type="hidden" name="_method" value="delete">
          <input type="submit" value="Delete" class="btn btn-danger">
        </form>
      </td>
      <td><a href="/courses/${course.id}/students" class="btn btn-primary">students</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/courses/new" class="btn btn-primary">new course</a>
</body>
</html>

