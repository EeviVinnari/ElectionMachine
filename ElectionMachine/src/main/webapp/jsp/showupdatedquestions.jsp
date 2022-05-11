<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Muokkaa</title>
</head>
<body>

<form action='/rest/electionservice/updatequestions' method='post'> <!-- shows where the information of this form is forwarded -->
<!-- requestScope receives the information coming from the method. Updatedquestion is the attribute from the requestDispatcher and the kysymys_id is attribute from the Kysymykset model -->
Muokkaa kysymys ID: <input type='text' name='kysymys_id' value='${requestScope.updatedquestion.kysymys_id}'> <br>
Muokkaa kysymystä: <input type='text' name='kysymys' value='${requestScope.updatedquestion.kysymys}'> <br>
<input type='submit' name='ok' value='ok'>
</form>

</body>
</html>