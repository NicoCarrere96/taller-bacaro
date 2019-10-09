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
	<body>
	 <div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
  				<h1>BuscoTaller.com</h1>
  				<p>La manera mas facil y comoda de conseguir taller</p> 
				</div>
		<div class="container">
		
		<form:form class="text-center border border-light p-5" action="registro" method="POST" commandName="taller" id="validar-form">

    <p class="h2 mb-4">Formulario de Registro</p>

    <div class="form-row mb-4">
        <div class="col">
            <form:input type="text" path="nombreDelTaller" class="form-control" placeholder="Nombre del Taller" />
        </div>
        <div class="col">
            
            <form:input type="text" path="nombreDelDuenio" class="form-control" placeholder="Nombre del Dueño" />
        </div>
    </div>
    
    <div class="form-row mb-4">
        <div class="col">
            <form:input type="text" path="calle" class="form-control" placeholder="Calle" />
        </div>
        <div class="col">
            
            <form:input type="text" path="numero" class="form-control" placeholder="Numero" />
        </div>
    </div>
    
            <form:select type="text" id="provinciaSelect" path="localidad.provincia.id" class="form-control mb-4" >
        	 <form:option value="NONE" label="---Seleccionar Provincia---"/>
			 <form:options items="${provincias}" itemValue="id" itemLabel="nombre" />
			</form:select>
			
        	 <form:select id="localidadSelect" path="localidad.id" class="form-control mb-4">
			<form:option value="NONE" label="---Seleccionar Localidad---"/>
			<form:options items="${localidades}" itemValue="id" itemLabel="nombre" />
			</form:select>
			
			<form:input type="text" path="telefono" class="form-control" placeholder="Telefono"/>
			<form:input path="usuario.email" type="email" id="email" class="form-control mb-4" placeholder="E-mail"/>
			<form:password path="usuario.password" id="password" class="form-control" placeholder="Password"/>	
			<form:password  path="usuario.repetirpassword" id="repetirpassword" class="form-control" placeholder="Repetir Password"/>		
			<form:input type="text" path="paginaWeb" class="form-control" placeholder="Pagina Web"/>
			<form:select path="especialidad" class="form-control mb-4">
				 <form:option value="NONE" label="---Seleccionar Especialidad---"/>
								 <form:options items="${especialidades}" />
								</form:select>
			<form:input type="text" path="manoDeObra" class="form-control" placeholder="Valor De La Mano de Obra"/>
			<form:button class="btn btn-info my-4 btn-block" type="Submit">Registrese</form:button>


</form:form>
			 			
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