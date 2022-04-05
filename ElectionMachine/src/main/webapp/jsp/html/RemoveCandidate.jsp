<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %>
<%@ page import="dao.Dao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h2>Poista ehdokas</h2>
	<br>
	
	<c:forEach var="vaalikone" items="${sessionScope.vaalikone }">
	
	<b>Ehdokas id</b>
	${vaalikone.ehdokas_id}<br>
	
	<a id="removeButton" href="removeCandidate?ehdokas_id=${vaalikone.ehdokas_id}">Poista ehdokas</a>
	</c:forEach>

</body>
</html>