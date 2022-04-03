<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Kysymykset" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
	<th>Kysymys ID</th>
	<th>Kysymys</th>
	
</tr>

<c:forEach var="kysymykset" items="${sessionScope.allkysymykset }">

	<tr>
		<td>${kysymykset.kysymys_id}</td>
		<td>${kysymykset.kysymys}</td>
	
		
		
	</tr>
</c:forEach>
</table>

</body>
</html>
