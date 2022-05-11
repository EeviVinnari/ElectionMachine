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
<form action='/rest/electionservice/updatequestions' method='post'> 
Muokkaa kysymys ID: <input type='text' name='kysymys_id' value='${requestScope.updatedquestion.kysymys_id}'> <br>
Muokkaa kysymystä: <input type='text' name='kysymys' value='${requestScope.updatedquestion.kysymys}'> <br>
<input type='submit' name='ok' value='ok'>
</form>
</body>
</html>