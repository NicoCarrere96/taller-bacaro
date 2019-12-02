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
	</div>

	<br>
	<br>

	<div style="text-align: center" class="alert alert-success">

		<br>
		<h3>${mensajeError}</h3>
	</div>
	<br>
	
<a href="<c:url value="/cliente?dni=${ dniCliente }"/>" class="btn btn-lg btn-info" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
</body>
</html>