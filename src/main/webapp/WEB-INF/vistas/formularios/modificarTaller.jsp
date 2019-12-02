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

  				 <span class="nav navbar-nav navbar-right">
					<a href="${pageContext.request.contextPath}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a>
				 </span>
				</div>
	<nav>
	
		<div class="w3-bar w3-dark-grey">
				<a href="<c:url value="/reserva/lista"/>" class="w3-bar-item w3-button w3-mobile" style="width:25%">Consultar Reservas</a>
  				<a href="<c:url value="/stockRepuestos/abmRepuestos" />" class="w3-bar-item w3-button w3-mobile" style="width:25%">Listado de Repuestos</a>
  				<a href="<c:url value="/factura/datosFacturacion" />" class="w3-bar-item w3-button w3-mobile" style="width:25%">Datos Facturacion</a>
  				<a href="<c:url value="/taller/homeTaller" />" class="w3-bar-item w3-button w3-mobile" style="width:25%">Datos Taller</a>
	  			
		</div>
	
	</nav>
	<div class="container">

		<form:form class="form-horizontal" action="modificarTaller" method="POST"
			commandName="taller" id="validar-form">

			<p class="h2 mb-4">Modificar Datos del Taller</p>
			<br>
			<form:hidden path="id" />
			<div class="form-group">
				<label class="control-label col-sm-2">Nombre del Taller:</label>
				<div class="col-sm-10">
					<form:input type="text" path="nombreDelTaller" class="form-control"
						placeholder="Nombre del Taller" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Nombre del Dueño: </label>
				<div class="col-sm-10">
					<form:input type="text" path="nombreDelDuenio" class="form-control"
						placeholder="Nombre del Dueño" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2">Calle: </label>
				<div class="col-sm-10">
					<form:input type="text" path="calle" class="form-control"
						placeholder="Calle" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Numero: </label>
				<div class="col-sm-10">
					<form:input type="text" path="numero" class="form-control"
						placeholder="Numero" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Provincia: </label>
				<div class="col-sm-10">
					<form:select type="text" id="provinciaSelect"
						path="localidad.provincia.id" class="form-control mb-4">
						<form:options items="${provincias}" itemValue="id"
							itemLabel="nombre" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Localidad: </label>
				<div class="col-sm-10">
					<form:select id="localidadSelect" path="localidad.id"
						class="form-control mb-4">
						<form:options items="${localidades}" itemValue="id"
							itemLabel="nombre" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Telefono: </label>
				<div class="col-sm-10">
					<form:input type="text" path="telefono" class="form-control"
						placeholder="Telefono" />
				</div>
			</div>
			<form:hidden path="usuario.id" />
			<form:hidden path="usuario.email" />
			<form:hidden path="usuario.password" />
			<form:hidden path="usuario.rol" />
			<div class="form-group">
				<label class="control-label col-sm-2">Pagina Web: </label>
				<div class="col-sm-10">
					<form:input type="text" path="paginaWeb" class="form-control"
						placeholder="Pagina Web" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Especialidad: </label>
				<div class="col-sm-10">
					<form:select path="especialidad" class="form-control mb-4">
						<form:option value="NONE" label="---Seleccionar Especialidad---" />
						<form:options items="${especialidades}" itemLabel="name"/>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Mano de Obra: </label>
				<div class="col-sm-10">
					<form:input type="text" path="manoDeObra" class="form-control"
						placeholder="Valor De La Mano de Obra" />
				</div>
			</div>
			<form:button class="btn btn-info my-4 btn-block" type="Submit">Guardar</form:button>


		</form:form>

	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
			
			$('#provinciaSelect').change( function(){
					$("#localidadSelect").empty()
					let selectValue = $('#provinciaSelect').val();
							
						$.ajax({
						  type: "GET",
						  url: "<c:url value='buscarLocalidades' />",
						  data: 'provinciaId=' + selectValue,
						  success: function (data){
									data.forEach( localidad => {
									  	$("#localidadSelect").append('<option value="'+localidad.id+'">'+localidad.nombre+'</option>')
								
									}									
							 	 )
							  }
							})	  
						  
						});
		
		</script>
	<script src="<c:url value="/js/bootstrap.min.js" />"
		type="text/javascript"></script>
</body>
</html>