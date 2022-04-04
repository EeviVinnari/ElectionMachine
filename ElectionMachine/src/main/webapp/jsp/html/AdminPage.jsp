<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <style>
    body{
    background-color: lightgray;
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
    a {
  background-color: black;
  color: white;
  padding: 5px;
  text-decoration: none;
  font-size:20px;
}

a:hover {
  background-color: #555;
}

a:active {
  background-color: black;
}

a:visited {
  background-color: darkgrey;
}


    </style>
    
<title>Insert title here</title>
</head>
<body>

  <header>
  
  <h1>Election Machine - ADMIN </h1>
  
  </header>

</br>

    <table class="blue">

      <tr>
        <td><a href='/addform.html'>Lisää uusi ehdokas</a></td>
        <!-- '/jsp/html/addcandidate.jsp' -->
        <td><a href='/updatecandidate'>Muokkaa ehdokkaita</a></td>
        <td><a href=" ">Poista ehdokkaita</a></td>


		<td>
			<a href='/addform.html'>Lisää uusi ehdokas</a>
			<!-- '/jsp/html/addcandidate.jsp' -->
			
		</td>
		
		<td>
			<td><a href='/updatecandidate'>Muokkaa ehdokkaita</a></td>
		</td>
		
		<td>
			<a href='/updatecandidate'>Poista ehdokkaita</a>
		</td>

      </tr>
    </table>

</br>

 <td><a href='/logoutservlet'>Kirjaudu ulos</a></td>

</br>
</br>

    <footer>
    <h4>Sofian ja Eevin vaalikone</h4>
    </footer>
</body>
</html>