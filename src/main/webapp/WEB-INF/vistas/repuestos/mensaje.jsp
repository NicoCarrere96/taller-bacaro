<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<!-- w3 CSS -->
<link href="<c:url value="/css/w3.css" />" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="<c:url value="/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
</head>

<body>
	<div class="jumbotron text-center"
		style="background-color: #0d80b3; color: white">
		<h1>BuscoTaller.com</h1>
		<p>La manera mas facil y comoda de conseguir taller</p>
		 <span class="nav navbar-nav">
					<a href="${pageContext.request.contextPath}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a>
				 </span>
	</div>
	<nav>

		<div class="w3-bar w3-dark-grey">
			<a href="<c:url value="/reserva/lista" />"
				class="w3-bar-item w3-button w3-mobile" style="width: 33%">Consultar
				Reservas</a> <a href="<c:url value="/stockRepuestos/abmRepuestos" />"
				class="w3-bar-item w3-button w3-mobile" style="width: 33%">Listado
				de Repuestos</a> <a href="<c:url value="/taller/homeTaller" />"
				class="w3-bar-item w3-button w3-mobile" style="width: 33%">Datos
				Taller</a>

		</div>

	</nav>
	<br>
	<br>

	<div style="text-align: center" class="alert alert-success">

		<h3>${aviso}</h3>
		<br>
		<h3>${mensaje}</h3>
	</div>
	<div style="text-align: center" class="alert alert-warning">
		<h3>${avisoError}</h3>
		<br>
		<h3>${mensajeError}</h3>
	</div>
	<br>
	<br>
	<br>
	<br>