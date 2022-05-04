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
<form action='../readtoupdatequestion/{kysymys_id}' method='post'> </form>
<c:forEach var="kysymykset" items="${requestScope.updatedquestionlist }">
	<li>${kysymykset}  
</c:forEach>
</body>
</html>