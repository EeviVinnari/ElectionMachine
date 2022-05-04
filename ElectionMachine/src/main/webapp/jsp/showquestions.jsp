<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='../readquestion' method='post'>
<c:forEach var="kysymykset" items="${requestScope.questionlist }">
	<li>${kysymykset} <a href='../delete?kysymys_id=${kysymykset.kysymys_id}'>Delete</a> <a href='../readtoupdatequestion?kysymys_id=${kysymykset.kysymys_id}'>Update</a>
</c:forEach>
</body>
</html>