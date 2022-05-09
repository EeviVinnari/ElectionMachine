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
<form action='rest/electionservice/readquestion' method='post'>
<section class="questions">
<c:forEach var="kysymykset" items="${requestScope.questionlist }">
	<li>${kysymykset} <a href='http://localhost:8080/rest/electionservice/delete/${kysymykset.kysymys_id}' onclick="return window.confirm('Haluatko varmasti poistaa?');">Poista</a></a> <a href='/rest/electionservice/readtoupdatequestion?kysymys_id=${kysymykset.kysymys_id}'>Update</a>
</c:forEach>
</section>
</body>
</html>