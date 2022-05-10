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
<form action='/rest/electionservice/updatequestion' method='post'> 
Muokkaa kysymys ID: <input type='text' name='kysymys ID' value='${requestScope.kysymykset.kysymys_id}'>
Muokkaa kysymystä: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}'>
</form>
<c:forEach var="kysymykset" items="${requestScope.updatedquestionlist }">
	
</c:forEach>
</body>
</html>