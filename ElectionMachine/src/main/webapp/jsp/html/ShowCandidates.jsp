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
      .red{
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        font-size: 18px;
        
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
          <img 
          src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
  
  </header>
  </br>
  
  

<table>
<tr class="red">
<!--<th>Ehdokas ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
	<th>Puolue</th>
	<th>Kotipaikkakunta</th>
	<th>Ikä</th>
	<th>Miksi eduskuntaan</th>
	<th>Mitä asioita haluat edistää</th>
	<th>Ammatti</th>-->
</tr>

<c:forEach var="vaalikone" items="${sessionScope.allvaalikone }">

	<tr>
	
		<td><b>${vaalikone.ehdokas_id }: <b></b></td>
		<td><b>${vaalikone.sukunimi } ${vaalikone.etunimi }</b></td>
		<th>Puolue:</th>
		<td>${vaalikone.puolue }</td>
			<th>Kotipaikkakunta:</th>
		<td>${vaalikone.kotipaikkakunta }</td>
			<th>Ikä:</th>
		<td>${vaalikone.ika }</td>
		<th>Miksi eduskuntaan:</th>
		<td>${vaalikone.miksi_eduskuntaan }</td>
			<th>Mitä asioita haluat edistää:</th>
		<td>${vaalikone.mita_asioita_haluat_edistaa }</td>
		<th>Ammatti:</th>
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
