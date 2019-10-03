<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
		<title>Reserva de turno
		</title>
	</head>
	<body>
	<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
	  <h1>BuscoTaller.com</h1>
	  <p>La manera mas facil y comoda de conseguir taller</p> 
	</div>

	 	 <table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Nº</th>
		      <th scope="col">Fecha</th>
		      <th scope="col">Taller</th>
		      <th scope="col">Cliente</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		<tbody>
		<c:forEach items="${reservas}" var="reserva">
		  <tr>
		    <td class="row">${ reserva.id }</td>
			<td>${ reserva.fecha }</td>
			<td>${ reserva.taller.nombreDelTaller }</td>
			<td>${ reserva.cliente.nombre } ${ reserva.cliente.apellido }</td>
			<td>
			<c:choose>
				<c:when test="${ reserva.estado eq 'PENDIENTE' }">
					<a href="<c:url value="/orden/nueva/${ reserva.id }" />">
						<button type="button" class="btn btn-warning">
							Registrar orden de trabajo
						</button>
					</a>
				</c:when>
				<c:when test="${ reserva.estado eq 'ORDEN_REGISTRADA' }">
					<a href="<c:url value="/orden/editar/${ reserva.id }" />">
						<button type="button" class="btn btn-info">
							Ver Orden
						</button>
					</a>
				</c:when>
				<c:otherwise>
					<a href="<c:url value="/orden/editar/${ reserva.id }" />">
						<button type="button" class="btn btn-info">
							Ver Factura
						</button>
					</a>
				</c:otherwise>
			</c:choose>
			</td>
		  </tr>
		
		</c:forEach>
		</tbody>
	</table>
			<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>