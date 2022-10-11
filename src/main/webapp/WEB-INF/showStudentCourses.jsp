<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/10/22
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
<h1><c:out value="${student.firstName}" />'s Courses</h1>
<div class="card">
  <ul>
    <c:forEach var="studentCourse" items="${student.courses}">
      <p>${studentCourse.name} <a href="/students/${student.id}/removeCourse/${studentCourse.id}">remove</a></p>
    </c:forEach>
  </ul>
<%--  add course to student --%>
  <form action="/students/${student.id}/updateCourses" method="POST">
    <select name="courseId">
      <c:forEach var="course" items="${courses}">
        <!--- Each option VALUE is the id of the course --->
        <option value="${course.id}">
          <!--- This is what shows to the user as the courses option --->
          <c:out value="${course.name}"/>
        </option>
      </c:forEach>
    </select>
    <input type="submit" value="Submit" class="btn btn-dark" />
  </form>
  <a href="/students" class="btn btn-primary">Back To Dashboard</a>
</div>
</body>
</html>

