<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
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
<c:forEach var="vaalikone" items="${sessionScope.allvaalikones }">

	<tr>
		<td>${vaalikone.ehdokas_id }</td>
		<td>${vaalikone.sukunimi }</td>
		<td>${vaalikone.etunimi }</td>
		<td>${vaalikone.puolue }</td>
		<td>${vaalikone.kotipaikkakunta }</td>
		<td>${vaalikone.ika }</td>
		<td>${vaalikone.miksi_eduskuntaan }</td>
		<td>${vaalikone.mita_asioita_haluat_edistaa }</td>
		<td>${vaalikone.ammatti }</td>
	</tr>
</c:forEach>
</table>

</body>
</html>