<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Restful jar-xs services, Jersey Client Api & Microservicios</title>
</head>
<body>
	<div id="cajaPrincipal">
		<form action="TestRest" method="post">
			<label for="idCveArt">Clave:</label>
			<select name="cveArt" id="idCveArt">
				<c:forEach var="par" items="${mapaArticulos}">
					<option value="${par.value}}"> ${par.key} </option>
				</c:forEach>
			</select>
			<input type="hidden" name="vista" value="DemoGui.jsp" />
			<input type="hidden" name="operacion" value="consulta" />
			<input type="submit"  value="consultar" />
		</form>	
		
		<form action="TestRest" method="post">
			<input type="hidden" name="vista" value="DemoGui.jsp" />
			<input type="hidden" name="operacion" value=alta />
			<input type="submit"  value="postArticulo" />
		</form>
	</div>
</body>
</html>