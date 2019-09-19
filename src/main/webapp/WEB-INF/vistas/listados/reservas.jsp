<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
		<title>Reservas</title>
	</head>
	<body>
		<table>
  		<tr>
    		<th>Nº</th>
    		<th>Fecha</th>
    		<th>Taller</th>
    		<th>Cliente</th>
    		<th></th>
	 	 </tr>

		<c:forEach items="${reservas}" var="reserva">
		  <tr>
		    <td>${ reserva.id }</td>
			<td>${ reserva.fecha }</td>
			<td>${ reserva.taller.nombreDelTaller }</td>
			<td>${ reserva.cliente.nombre } ${ reserva.cliente.apellido }</td>
			<td><a href="<c:url value="/orden/nueva/${ reserva.id }" />">Registrar orden de trabajo</a></td>
		  </tr>
		
		</c:forEach>
	</table>
			<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>