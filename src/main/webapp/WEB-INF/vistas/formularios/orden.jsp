<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<span class="nav navbar-nav"> <a
			href="${pageContext.request.contextPath}/cerrar-sesion"><span
				class="glyphicon glyphicon-log-in" style="color: white"></span>
				Logout</a>
		</span>
	</div>
	<nav>
	
		<div class="w3-bar w3-dark-grey">
				<a href="<c:url value="/reserva/lista"/>" class="w3-bar-item w3-button w3-mobile" style="width:20%">Consultar Reservas</a>
  				<a href="<c:url value="/stockRepuestos/abmRepuestos" />" class="w3-bar-item w3-button w3-mobile" style="width:20%">Listado de Repuestos</a>
  				<a href="<c:url value="/factura/datosFacturacion" />" class="w3-bar-item w3-button w3-mobile" style="width:20%">Datos Facturacion</a>
  				<a href="<c:url value="/taller/homeTaller" />" class="w3-bar-item w3-button w3-mobile" style="width:20%">Datos Taller</a>
  				<a href="<c:url value="/turno/abmTurnos" />" class="w3-bar-item w3-button w3-mobile" style="width:20%">Listado Turnos</a>
	  			
		</div>
	
	</nav>
	<br>
	<div class="container">
		<c:url value="/orden/nueva" var="action" />
		<form:form action="${ action }" method="POST" id="ordenForm"
			modelAttribute="orden">
			<h2>Generar Orden de trabajo</h2>

			<ul class="list-group list-group-flush">
				<li class="list-group-item"><strong>Taller:</strong><br>
					${ orden.reserva.taller.nombreDelTaller }</li>
				<li class="list-group-item"><strong>Cliente:</strong><br>
					${ orden.reserva.cliente.nombre } ${ orden.reserva.cliente.apellido }</li>
				<li class="list-group-item"><strong>Mano de obra por
						hora:</strong><br> $ ${ orden.reserva.taller.manoDeObra }</li>
				<li class="list-group-item"><strong>Problema:</strong><br>
					${ orden.reserva.problema }</li>
			</ul>

			<form:hidden path="id" />
			<form:hidden path="reserva.id" />
			<div class="form-group">
				<label for="horasDeTrabajo" class="control-label">Horas de
					Trabajo:</label>
				<c:choose>
					<c:when test="${ orden.reserva.estado eq 'APROBADA' }">
						${ orden.horasDeTrabajo }
					</c:when>
					<c:otherwise>
						<form:input path="horasDeTrabajo" class="form-control"
							type="number" required="required"
							value="${ orden.horasDeTrabajo }" />
					</c:otherwise>
				</c:choose>

			</div>



			<div class="form-group">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Repuesto</th>
							<th scope="col">Precio U.</th>
							<th scope="col">Cantidad</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ listaRepuestos }" var="ordRep">
							<tr>
								<td>${ ordRep.repuesto.nombre }</td>
								<td>${ ordRep.repuesto.precio }</td>
								<td>${ ordRep.cantidad }</td>
								<td><c:choose>
										<c:when test="${ orden.reserva.estado eq 'APROBADA' }">
										</c:when>
										<c:otherwise>
											<a class="btn btn-default btn-circle"
												href="<c:url value="/orden/eliminarRepuesto?ordRep=${ ordRep.id }&reserva=${ orden.reserva.id }" />"><span
												class="glyphicon glyphicon-trash"></span> </a>
										</c:otherwise>
									</c:choose></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
				<br>
				<c:choose>
					<c:when test="${ orden.reserva.estado eq 'APROBADA' }">
						<div class="form-group">
							<!-- Submit Button -->
							<a
								href="<c:url value="/factura/generarFactura?ordenId=${ orden.id }"/>"
								class="btn btn-primary sm">Generar Factura</a>
						</div>
					</c:when>
					<c:otherwise>
						<a
							href="<c:url value="/orden/agregarRepuesto?reserva=${ orden.reserva.id }"/>"
							class="btn btn-warning sm">Agregar Repuesto</a>
						<br>
						<br>

						<div class="form-group">
							<!-- Submit Button -->
							<button type="submit" class="btn btn-primary">Generar
								Presupuesto</button>
						</div>

					</c:otherwise>
				</c:choose>
			</div>

		</form:form>
	</div>
	<br>
	<br>
	<a href="<c:url value="/reserva/lista"/>"
		class="btn btn-lg btn-info" role="button"><span
		class="glyphicon glyphicon-hand-left"></span></a>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="<c:url value="/js/bootstrap.min.js" />"
		type="text/javascript"></script>
</body>
</html>