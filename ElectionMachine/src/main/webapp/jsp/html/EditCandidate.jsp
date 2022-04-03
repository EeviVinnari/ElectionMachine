<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Vaalikone" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vaalikone</title>
</head>
<body>

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
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>