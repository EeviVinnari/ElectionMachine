<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %>


<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action='./showcandidates' method='post'>
		Q1: <input type='text' name='ika' value='${sessionScope.vaalikone.ika }'><br>
		Q2: <input type='text' name='etunimi' value='${sessionScope.game.etunimi }'><br>
		<input type="hidden" name="id" value="${sessionScope.vaalikone.ehdokas_id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>
