<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/rest/electionservice/addquestion" method="post">
Lisää uusi kysymys: <input type='text' name='kysymys' value=''>
<input type='submit' name='ok' value='Send'>
</form>
<ol>
<c:forEach var="kysymykset" items="${requestScope.questionlist }">
    <li>${kysymykset} <a href='../deletequestion?id=${kysymykset.kysymys_id}'>Delete</a> <a href='../readtoupdatekysymykset?id=${kysymykset.kysymys_id}'>Update</a>
</c:forEach>
</ol>

</body>
</html>