<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<% ArrayList<String> listado = (ArrayList<String>) session.getAttribute("listadoJuegos"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Juegos</title>
</head>
<body>

	<h1>Listado Juegos</h1>
	
		<% if( listado == null) {  %>
		<p> No hay Juegos en esta lista<p></br>
		<% } else { %>
		<c:forEach items="${listadoJuegos}" var="elemento">
         	<p>Titulo -> ${elemento.getTitulo()}</p>
         	<p>Consola -> ${elemento.getConsola()}</p>
         	<p>Género -> ${elemento.getGenero()}</p>
         	<br>
    	</c:forEach>
		<% } %>
</body>
</html>