<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<span class="nav navbar-nav navbar-right"> <a
			href="${pageContext.request.contextPath}/cerrar-sesion"><span
				class="glyphicon glyphicon-log-in" style="color: white"></span>
				Logout</a>
		</span>
	</div>
	<nav>

		<div class="w3-bar w3-dark-grey">
			<a href="<c:url value="/reserva/lista"/>"
				class="w3-bar-item w3-button w3-mobile" style="width: 25%">Consultar
				Reservas</a> <a href="<c:url value="/stockRepuestos/abmRepuestos" />"
				class="w3-bar-item w3-button w3-mobile" style="width: 25%">Listado
				de Repuestos</a> <a href="<c:url value="/factura/datosFacturacion" />"
				class="w3-bar-item w3-button w3-mobile" style="width: 25%">Datos
				Facturacion</a> <a href="<c:url value="/taller/homeTaller" />"
				class="w3-bar-item w3-button w3-mobile" style="width: 25%">Datos
				Taller</a>

		</div>

	</nav>

	<div class="container" style="margin-top: 20px !important">
		<div class="col-md-12">
			<h1>Facturacion Por Cliente</h1>


			<div style="float: left; width: 70%;">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th scope="col">Fecha</th>
							<th scope="col">Cliente</th>
							<th scope="col">Problema</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reserva}" var="reserva">

							<tr>
								<td class="row">${ reserva.turno.fecha }</td>
								<td class="row">${ reserva.cliente.nombre }${ reserva.cliente.apellido }</td>
								<td class="row">${ reserva.problema }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div style="float: left;">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th scope="col">Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ordenes}" var="orden">

							<tr>
								<td class="row">$ ${ orden.total }</td>
							</tr>

						</c:forEach>
					</tbody>



					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>
</html>