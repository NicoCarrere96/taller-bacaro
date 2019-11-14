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
	</div>
	<c:if test="${ ! cliente }">
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
	</c:if>
	<br>
	<div class="container">
		<h2>Factura</h2>

		<ul class="list-group list-group-flush">
			<li class="list-group-item"><strong>Taller:</strong><br> ${ factura.reserva.taller.nombreDelTaller }</li>
			<li class="list-group-item"><strong>Mano de obra por
					hora:</strong><br> ${ factura.reserva.taller.manoDeObra }</li>
			<li class="list-group-item"><strong>Horas de Trabajo:</strong><br>
				${ factura.horasDeTrabajo }</li>
			<li class="list-group-item">
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
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</li>
			<li class="list-group-item"><strong>Total:</strong><br> $
				${ factura.total }</li>
		</ul>

		<a
			href="<c:url value="/factura/getPdf?reservaId=${ factura.reserva.id }"/>"
			class="btn btn-danger" role="button">Imprimir factura</a>
	</div>



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