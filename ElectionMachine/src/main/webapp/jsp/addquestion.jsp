<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='../addquestion' method='post'>
<input type='text' name='breed' value=''>
<input type='text' name='weight' value=''>
<input type='submit' name='ok' value='OK'>
</form>
<ol>
<c:forEach var="kysymykset" items="${requestScope.kysymyksetlist }">
	<li>${kysymykset} <a href='../delete?kysymys_id=${kysymykset.kysymys_id}'>Delete</a> <a href='../readtoupdatequestion?kysymys_id=${kysymykset.kysymys_id}'>Update</a>
</c:forEach>
</ol>
</body>
</html>