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
	
	<div class="container">
		<a href="<c:url value="/taller/filtro?dniCliente=${ dniCliente }"/>" >
			<button type="button" class="btn btn-info  float-right">
				Nueva Reserva
			</button>
		</a>
	</div>

	<div class="container">
	 	 <table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Nº</th>
		      <th scope="col">Fecha</th>
		      <th scope="col">Taller</th>
		      <th scope="col">Cliente</th>
		      <th scope="col">Estado</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		<tbody>
		<c:forEach items="${reservas}" var="reserva">
		  <tr>
		    <td class="row">${ reserva.id }</td>
			<td class="row">${ reserva.fecha }</td>
			<td class="row">${ reserva.taller.nombreDelTaller }</td>
			<td class="row">${ reserva.cliente.nombre } ${ reserva.cliente.apellido }</td>
			<td class="row">${ reserva.estado.name }</td>
			<td class="row">
				<c:if test="${ reserva.estado eq 'PRESUPUESTADA' }">
					<a href="<c:url value="/orden/ordenPresupuestada?idReserva=${ reserva.id }" />">
						<button type="button" class="btn btn-info">
							Ver Presupuesto
						</button>
					</a>
				</c:if>
				<c:if test="${ reserva.estado eq 'FACTURADA' }">
					<a href="<c:url value="/factura/generadaFactura?reservaId=${ reserva.id }" />">
						<button type="button" class="btn btn-info">
							Ver Factura
						</button>
					</a>
				</c:if>
				<c:if test="${ reserva.estado eq 'RECHAZADA' }">
					<a href="<c:url value="/orden/ordenPresupuestada?idReserva=${ reserva.id }" />">
						<button type="button" class="btn btn-info">
							Ver Presupuesto Rechazado
						</button>
					</a>
				</c:if>
			</td>
		  </tr>
		
		</c:forEach>
		</tbody>
	</table>
	</div>
	
	<a href="<c:url value="/cliente?dni=${ dniCliente }"/>" class="btn btn-lg btn-info" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
	
	
			<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>