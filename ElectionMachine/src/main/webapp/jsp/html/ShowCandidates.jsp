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
	<th>Puolue</th>
	<th>Kotipaikkakunta</th>
	<th>Ika</th>
	<th>Miksi eduskuntaan</th>
	<th>Mita asioita haluat edistaa</th>
	<th>Ammatti</th>
</tr>

<c:forEach var="vaalikone" items="${sessionScope.allvaalikone }">

	<tr>
		<td>${ehdokkaat.ehdokas_id }</td>
		<td>${ehdokkaat.sukunimi }</td>
		<td>${ehdokkaat.etunimi }</td>
		<td>${ehdokkaat.puolue }</td>
		<td>${ehdokkaat.kotipaikkakunta }</td>
		<td>${ehdokkaat.ika }</td>
		<td>${ehdokkaat.miksi_eduskuntaan }</td>
		<td>${ehdokkaat.mita_asioita_haluat_edistaa }</td>
		<td>${ehdokkaat.ammatti }</td>
		
		<td>
			<a href="/editgame?id=${game.id }">Edit</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
