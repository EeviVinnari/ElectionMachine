<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Kysymykset" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kysymykset</title>

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
  	<h1>Vaalikone - kysymykset </h1>
    <a href="index.html">
          <img src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
  </header>
  </br>

<table>

<c:forEach var="kysymykset" items="${sessionScope.allkysymykset }">

	<tr>
		<td>${kysymykset.kysymys_id}.</td>
		<td>${kysymykset.kysymys}</td>
	</tr>
</c:forEach>

</table>
	</br>

    <footer>
    <h4>Sofian ja Eevin vaalikone</h4>
    </footer>
    
</body>
</html>
