<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Salasanan tarkistus</h1>
<h3>Kirjaudu sisään</h3>
<form action="/check" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Check">
</form>

<h3>Luo käyttäjänimi ja salasana</h3>
<form action="/add" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Add">
</form>

</body>
</html>