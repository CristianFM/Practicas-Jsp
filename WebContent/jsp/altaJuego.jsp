<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Juego</title>
</head>
<body>
	<h1>Añadir Juegos</h1>
	
	<form method="post" action="?peticion=insert">
	<input type="text" name="titulo" placeholder="titulo"></br></br>
	<input type="text" name="consola" placeholder="plataforma"></br></br>
	<input type="text" name="genero" placeholder="genero"></br></br>
	<input type="submit" value="Añadir">
	</form>
</body>
</html>