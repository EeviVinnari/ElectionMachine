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
<form action="/rest/electionservice/addquestion" method="post">
Lisää uusi kysymys: <input type='text' name='kysymys' value=''>
<input type='submit' name='ok' value='Send'>
</form>


</body>
</html>