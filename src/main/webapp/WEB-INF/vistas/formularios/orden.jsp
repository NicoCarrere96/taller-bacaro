<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
		<title>Orden de Trabajo</title>
	</head>

	<body>
		<form:form action="orden" method="POST" modelAttribute="orden">
			
			
			<form:label path="horasDeTrabajo">Horas de Trabajo: </form:label>
			<form:input path="horasDeTrabajo" id="horasDeTrabajo" type="text" class="form-control"/>

			
			<form:button>Guardar Orden</form:button>
		</form:form>
	</body>
</html>