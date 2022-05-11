<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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
    .blue {
  		max-width: 500px;
  		margin: auto;
	}
    a{
  		background-color: #4682b4;
  		color: white;
 		padding: 20px;
 		text-decoration: none;
 		font-size:25px;
 		display: inline;
 		font-family: "Times New Roman", Times, serif;
	}
	a:hover{
  		background-color: #555;
	}
	a:active{
  		background-color: black;
	}
	p{
		text-align: center;
		font-size: 20px;
	}
	h4{
		font-family: "Times New Roman", Times, serif;
		font-size: 20px;
	}
	.green{
  		max-width: 500px;
  		margin: auto;
	}

</style>
    
<title>Admin-sivu</title>
</head>

<body>
<header>
	<h1>Vaalikone - ADMIN </h1>
</header>
</br>
	<p>Ehdokkaiden hallinta</p>
	<table class="blue">
	<tr>
    <br>
        <td><a href='/addform.html'>Uusi</a></td>
        <!-- '/jsp/html/addcandidate.jsp' -->
        <td><a href='/updatecandidate'>Muokkaa</a></td>
        <td><a href="/updatecandidate">Poista</a></td>
    </tr>
    </table>
    <br>
    
    <p>Kysymysten hallinta</p>
    <table class="blue">
	<tr>
    
        <td><a href='/jsp/addquestion.jsp'>Uusi</a></td>
        <td><a href='/rest/electionservice/readquestion'>Muokkaa</a></td>
    	<td><a href='/rest/electionservice/readquestion'>Poista</a></td>
	</tr>
    </table>
	<br>
	<br>
    <table class="green">
    <tr>
 		<td><a href='/logoutservlet'>Kirjaudu ulos</a></td>
 	</tr>
    </table>
    
 	<br>
 	<br>
	<br>
	<br>

<footer>
	<h4>Sofian ja Eevin vaalikone</h4>
    <td><a href='/logintesti'>Tarkista</a></td>
</footer>
    
</body>
</html>