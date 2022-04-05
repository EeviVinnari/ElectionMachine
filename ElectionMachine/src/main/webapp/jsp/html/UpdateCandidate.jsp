<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa ja poista ehdokkaita</title>

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
	form{
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        font-size: 20px;      
	}
	header img {
        width: 100px;
        position: absolute;
        left: 22.5px;
        top: 2.5px;
	}
	.purple{
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        font-size: 18px;
  		border-spacing: 0 15px;   
	}
	td{
		text-align: center;
		padding: 5px;
	}
</style>
</head>

<body>
	<header>
		<h1>ADMIN - Muokkaa ja poista ehdokkaita </h1>
		<a href="/jsp/html/AdminPage.jsp">
		<img src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
	</header> 
	</br>
	
<table class="purple">
<!--<tr>
	<th>Ehdokas ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
-->

<c:forEach var="vaalikone" items="${sessionScope.allvaalikone }">

	<tr>
		<td><b>${vaalikone.ehdokas_id  }:<b></b></td>
		<td>${vaalikone.sukunimi } ${vaalikone.etunimi }</td>
		<td> <a href="/editcandidate?ehdokas_id=${vaalikone.ehdokas_id }">Muokkaa</a> </td>
		<td> <a href="/removecandidate?ehdokas_id=${vaalikone.ehdokas_id }">Poista</a> </td>
	</tr>
</c:forEach>
</table>

</br>
    <footer>
    <h4>Sofian ja Eevin vaalikone</h4>
    </footer>
</body>
</html>
