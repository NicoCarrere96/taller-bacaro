<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	<!-- w3 CSS -->    
	     <link href="<c:url value="/css/w3.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	</head>
	
	<body >
		 <div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
  				<h1>BuscoTaller.com</h1>
  				<p>La manera mas facil y comoda de conseguir taller</p> 

  				<span class="nav navbar-nav navbar-right" style="margin-right:15px;">
					<a href="${pageContext.request.contextPath}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a>
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

	<div class="container" style="margin-top: 20px !important">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<h1>Lista de Turnos</h1>
						<a class="btn btn-default btn-circle"
							href="<c:url value="agregarTurno" />"><span
							class="glyphicon glyphicon"></span> Agregar Turno</a>
						<br>

						<table class="table table-striped custab">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Fecha</th>
									<th scope="col">Horario</th>
									<th scope="col">Cantidad</th>
									<th scope="col">Editar</th>
									<th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="t" items="${turno}">
									<tr>
										<td><c:out value="${t.id}" /></td>
										<td><c:out value="${t.fecha}" /></td>
										<td><c:out value="${t.horario}" /></td>
										<td><c:out value="${t.cantidad}" /></td>
										<td><c:out value="" /><a
											class="btn btn-default btn-circle"
											href="<c:url value="modificarTurno?idTurno=${t.getId()}" />"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td><c:out value="" /> <a
											class="btn btn-default btn-circle"
											href="<c:url value="eliminarTurno?idTurno=${t.getId()}" />"><span
												class="glyphicon glyphicon-trash"></span> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>


			</div>
		</div>
		<a href="<c:url value="/taller/homeTaller"/>" class="w3-button w3-round-xxlarge w3-blue" role="button"><span class="glyphicon glyphicon-hand-left">  Volver</span></a>	 
	</div>
	<br><br>

</body>
</html>
