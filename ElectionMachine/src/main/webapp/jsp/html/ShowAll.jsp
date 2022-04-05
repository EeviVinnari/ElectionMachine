<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista ehdokkaista</title>

<style>
body{
background-color: #B0C4DE;
}
    footer{
    	text-align: center;
    	position: static;
    	background-color: white;
    	bottom: 0%;
    	width: 100%;
    	padding: 10px;
    }
    header{
    	text-align: center;
    	position: static;
    	background-color: white;
    	bottom: 0%;
    	width: 100%;
    	padding: 3px;
    }
    h4 {
		font-family: "Times New Roman", Times, serif;
		font-size: 20px;
	}
	      header img {
        width: 100px;
        position: absolute;
        left: 22.5px;
        top: 2.5px;
      }
</style>
</head>
<body>

  <header>
  <h1>ADMIN - Lista ehdokkaista </h1>
      <a href="/jsp/html/AdminPage.jsp">
          <img 
          src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
  </header>
  </br>

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

</br>
    <footer>
    <h4>Sofian ja Eevin vaalikone</h4>
    </footer>

</body>
</html>