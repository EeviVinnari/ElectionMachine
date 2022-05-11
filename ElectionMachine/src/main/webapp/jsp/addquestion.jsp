<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lisää</title>
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
	header img{
        width: 100px;
        position: absolute;
        left: 22.5px;
        top: 2.5px;
		}
</style>
</head>
<body>
<header>
	<h1>ADMIN - Lisää uusi kysymys</h1>
	<a href="/jsp/html/AdminPage.jsp">
	<img src="https://www.pngrepo.com/png/369105/512/arrow-left-small.png"></a>
</header>
<br>
<form action='/rest/electionservice/addquestion' method='post'>
Kysymys: <input id='kysymys' type='text' name='kysymys' value=''>
<input type='submit' name='ok' value='Send'>
</form>
<br>	
<footer>
	<h4>Sofian ja Eevin vaalikone</h4>
</footer>
</body>
</html>