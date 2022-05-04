<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='/rest/electionservice/editquestions' method='post'>
Muokkaa kysymystä: <input type='text' name='kysymykset' value='${requestScope.kysymys}'>
<input type='submit' name='ok' value='OK'>
</form>

</body>
</html>