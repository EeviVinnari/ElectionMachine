<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa ja poista kysymyksi�</title>
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
  	<h1>ADMIN - Muokkaa ja poista kysymyksi�</h1>
		<a href="/jsp/html/AdminPage.jsp">
		<img src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
	</header>
	</br>
<form action='rest/electionservice/readquestion' method='post'>
<section class="questions">
<c:forEach var="kysymykset" items="${requestScope.questionlist }">
	<li>${kysymykset} <a href='http://localhost:8080/rest/electionservice/delete/${kysymykset.kysymys_id}' onclick="return window.confirm('Haluatko varmasti poistaa?');">Poista</a></a> <a href='/rest/electionservice/readtoupdatequestion?kysymys_id=${kysymykset.kysymys_id}'>Update</a>
</c:forEach>
</section>

	</br>
		</br>
		
    <footer>
	<h4>Sofian ja Eevin vaalikone</h4>
    </footer>



</body>
</html>