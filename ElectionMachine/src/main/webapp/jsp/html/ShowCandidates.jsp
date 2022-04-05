<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ehdokkaat</title>
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
    h4{
		font-family: "Times New Roman", Times, serif;
		font-size: 20px;
	}
	header img {
        width: 100px;
        position: absolute;
        left: 22.5px;
        top: 2.5px;
	}
	.red{
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        font-size: 18px;
        font-family: "Times New Roman", Times, serif;
        
  		border-spacing: 5 25px;    
	}
	td {
		text-align: center;
		padding: 5px;
	}
</style>
</head>

<body>
  <header>
  <h1>Vaalikone - ehdokkaat </h1>

  <a href="index.html" target="_blank">
  <img src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
  
  </header>
  </br>

<table>
	<li class="red">
	<!--<ol>Ehdokas ID</ol>
	<ol>Sukunimi</ol>
	<ol>Etunimi</ol>
	<ol>Puolue</ol>
	<ol>Kotipaikkakunta</ol>
	<ol>Ikä</ol>
	<ol>Miksi eduskuntaan</ol>
	<ol>Mitä asioita haluat edistää</ol>
	<ol>Ammatti</ol>-->
	</li>

<c:forEach var="vaalikone" items="${sessionScope.allvaalikone }">

	<li>
	<ol>Ehdokkaan numero: ${vaalikone.ehdokas_id }</ol>
	<ol>Sukunimi: ${vaalikone.sukunimi } </ol>
	<ol>Etunimi: ${vaalikone.etunimi }</ol>
	<ol>Puolue: ${vaalikone.puolue }</ol>
	<ol>Kotipaikkakunta: ${vaalikone.kotipaikkakunta }</ol>
	<ol>Ikä: ${vaalikone.ika }</ol>
	<ol>Miksi eduskuntaan: ${vaalikone.miksi_eduskuntaan }</ol>
	<ol>Mitä asioita haluat edistää: ${vaalikone.mita_asioita_haluat_edistaa }</ol>
	<ol>Ammatti: ${vaalikone.ammatti }</ol>
	</li>
	
</c:forEach>
</table>
	</br>
    <footer>
    <h4>Sofian ja Eevin vaalikone</h4>
    </footer>
</body>
</html>
