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
		<br>
	<div class="container">
	<h1>Modificar Turno</h1>
	<form:form action="actualizarTurno" modelAttribute="turno"
		method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">


				<form:hidden path="id"/>
				<form:hidden path="taller.id"/>
					<div class="form-group col-md-12">
					<label for="fecha">Fecha</label>
					<form:input type="text" required="required" class="form-control"
						id="fecha" path="fecha" placeholder="Fecha" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="horario">Horario</label>
					<form:input type="text" required="required" class="form-control"
						id="horario" path="horario" placeholder="Horario" />
				</div>

				<div class="form-group col-md-12">
					<label for="cantidad">Cantidad</label>
					<form:input type="number" required="required" class="form-control"
						id="cantidad" path="cantidad" placeholder="Cantidad" />
				</div>			
								
				</div>

				<input type="submit" class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Modificar Turno">
						<br><br>
	<a href="<c:url value="/turno/abmTurnos"/>" class="w3-button w3-round-xxlarge w3-blue" role="button" ><span class="glyphicon glyphicon-hand-left">  Volver</span></a>
	
			</div>
	</form:form>
</div>

</body > </html> 