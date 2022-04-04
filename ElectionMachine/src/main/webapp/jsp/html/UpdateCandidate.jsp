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

<table>
<tr>
	<th>Ehdokas ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>

</tr>

<c:forEach var="vaalikone" items="${sessionScope.allvaalikone }">

	<tr>
		<td>${vaalikone.ehdokas_id }</td>
		<td>${vaalikone.sukunimi }</td>
		<td>${vaalikone.etunimi }</td>


		
		<td>
			<a href="/editcandidate?ehdokas_id=${vaalikone.ehdokas_id }">Edit</a>
		</td>
		<td>
			<a href="/removecandidate?ehdokas_id=${vaalikone.ehdokas_id }">Remove</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
