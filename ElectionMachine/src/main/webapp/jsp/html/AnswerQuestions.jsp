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

<form method="post" action="./answerquestions">  
     
    <h1>${sessionScope.kysymykset.kysymys }</h1>  
    <input type="radio" name="favorite_pet" value="Cats" value='${sessionScope.kysymykset.kysymys }'><br>  
   
    <input type="radio" name="favorite_pet" value="Dogs" onclick="return ValidatePetSelection();">Dogs<br>  
    <input type="radio" name="favorite_pet" value="Birds" onclick="return ValidatePetSelection();">Birds<br>  
        <br>  
    <input type="submit" value="Submit now">  
    
</form>  


<table>
<c:forEach var="id" items="${sessionScope.kysymys }">

	<tr>
		<td>${kysymykset.kysymys}</td>
		
		
		<td>
			<a href="/answerquestions?id=${kysymykset.id }">Edit</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
