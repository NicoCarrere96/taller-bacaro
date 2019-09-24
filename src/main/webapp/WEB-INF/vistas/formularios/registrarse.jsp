<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	    <title>Registro</title>
	</head>
	<body style="margin:50px">
		<div class="container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<h1 class="form-signin-heading">Formulario de registro de Talleres</h1>
				<hr class="colorgraph"><br>
			 
				<form:form action="registro" method="POST" commandName="taller">
				 
					<table>
						<tr>
							<td>Nombre del Taller : </td>
							<td><form:input path="nombreDelTaller" /></td>
						</tr>
						<tr>
							<td>Nombre del Dueño : </td>
							<td><form:input path="nombreDelDuenio" /></td>
						</tr>
						<tr>
							<td>Calle : </td>
							<td><form:input path="calle" /></td>
						</tr>
						<tr>
							<td>Numero : </td>
							<td><form:input path="numero" /></td>
						</tr>
						<tr>
							<td>Provincia : </td>
							<td>
								<form:select id="provinciaSelect" path="localidad.provincia.id">
									 <form:option value="NONE" label="---Seleccionar---"/>
									 <form:options items="${provincias}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</td>
						</tr>
						<tr>
							<td>Localidad : </td>
							<td>
								<form:select id="localidadSelect" path="localidad.id">
									 <form:option value="NONE" label="---Seleccionar---"/>
									 <%-- <form:options items="${localidades}" itemValue="id" itemLabel="nombre" /> --%>
								</form:select>
							</td>
						</tr>
						<tr>
							<td>Telefono : </td>
							<td><form:input path="telefono" /></td>
						</tr>
						<tr>
							<td>Mail : </td>
							<td><form:input path="usuario.email" id="email" type="email" class="form-control"/></td>
						</tr>
						<tr>
							<td>Password : </td>
							<td><form:input path="usuario.password" id="password" type="password" class="form-control"/></td>
						</tr>
						
						<tr>
							<td>Pagina Web : </td>
							<td><form:input path="paginaWeb" /></td>
						</tr>
						<tr>
						<td>Especialidad : </td>
							<td>
								<form:select path="especialidad">
								 <form:option value="NONE" label="---Seleccionar---"/>
								 <form:options items="${especialidades}" />
								</form:select>
							</td>
						</tr>
  						<tr>
							<td>Mano de Obra: </td>
							<td>$<form:input path="manoDeObra" /></td>
						</tr>
						<tr>
							<td><form:button class="btn btn-lg btn-primary btn-block" Type="Submit">Registrar</form:button></td>
						</tr>
					</table>
				</form:form>
			 </div>
		 </div>
	 
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
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
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>