<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rest Cliente</title>
</head>
<body>
<div id="cajaPrincipal">
	<h3>Datos de articulo:</h3>
	
	<label for="idClave">Clave:</label>
	<input type="text" readonly="readonly" value="${articulo.clave}" id="idClave">
	
	<label for="idNombre">Nombre:</label>
	<input type="text" readonly="readonly" value="${articulo.nombre}" id="idNombre">
	
	<label for="idDesc">Descripcion:</label>
	<input type="text" readonly="readonly" value="${articulo.descripcion}" id="idDesc">
	
	<label for="idCosto">Costo:</label>
	<input type="text" readonly="readonly" value="${articulo.costo}" id="idCosto">

	<label for="idPrecio">Precio:</label>
	<input type="text" readonly="readonly" value="${articulo.precio}" id="idPrecio">
	
	<label for="idExist">Existencia:</label>
	<input type="text" readonly="readonly" value="${articulo.stock}" id="idExist"><br>
	
	<form action="TestRest" method="post" id="idFmRegresar">
		<input type="hidden" name="vista" value="salida.jsp" />
		<input type="hidden" name="operacion" value="regresar.jsp" />
		<input type="submit" value="Regresar">
	</form>

	<span id="estado">${articulo}</span>	
</div>
</body>
</html>