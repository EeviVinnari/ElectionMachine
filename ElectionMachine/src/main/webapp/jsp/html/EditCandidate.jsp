<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa ehdokkaita</title>

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
</style>
</head>
<body>

  <header>
  <h1>ADMIN - Muokkaa ehdokasta </h1>
      <a href="/jsp/html/AdminPage.jsp">
          <img 
          src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>

 
    </header>
    </br>

	<form action='./updatecandidate' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value='${sessionScope.vaalikone.sukunimi }'><br>
		Etunimi: <input type='text' name='etunimi' value='${sessionScope.vaalikone.etunimi }'><br>
		Puolue: <input type='text' name='puolue' value='${sessionScope.vaalikone.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${sessionScope.vaalikone.kotipaikkakunta }'><br>
		Ika: <input type='text' name='ika' value='${sessionScope.vaalikone.ika }'><br>
		Miksi eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${sessionScope.vaalikone.miksi_eduskuntaan }'><br>
		Mitä asioita haluat edistaa: <input type='text' name='mita_asioita_haluat_edistaa' value='${sessionScope.vaalikone.mita_asioita_haluat_edistaa }'><br>
		Ammatti: <input type='text' name='ammatti' value='${sessionScope.vaalikone.ammatti }'><br>
		
		<input type="hidden" name="ehdokas_id" value="${sessionScope.vaalikone.ehdokas_id }">		
		<input type='submit' name='ok' value='Muokkaa'>
	</form>
</br>
    <footer>
    <h4>Sofian ja Eevin vaalikone</h4>
    </footer>
</body>
</html>