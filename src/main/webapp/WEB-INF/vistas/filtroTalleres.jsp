<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
  	</head>
	<body>
	<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
	  <h1>BuscoTaller.com</h1>
	  <p>La manera mas facil y comoda de conseguir taller</p> 
	</div>
	
		<div class = "container">
		<div class="form-group row">
            <label class="col-sm-2 col-form-label">Provincia</label>
            <select type="text" id="provinciaSelect" class="form-control mb-4" >
			 	<option label="---Seleccionar Provincia---"/>
			 	<c:forEach items="${provincias}" var="provincia">
					 <option value="${provincia.id}" label="${ provincia.nombre }"/>
				 </c:forEach>
			</select>
		</div>	
		<div class="form-group row">	
       	 	<label class="col-sm-2 col-form-label">Localidad</label>
       	 	<select id="localidadSelect"  class="form-control mb-4">
				<option label="---Seleccionar Provincia---"/>
			</select>
		</div>
		<div class="form-group row">	
			<label class="col-sm-2 col-form-label">Especialidad</label>
			<select class="form-control mb-4" id="especialidadSelect">
				 <c:forEach items="${especialidades}" var="especialidad">
					 <option value="${especialidad}" label="${ especialidad }"/>
				 </c:forEach>
			</select>
		</div>
		
			<button type="button" class="btn btn-info" id="btnBuscarTalleres">
				Buscar Talleres
			</button>
			<br>
			<br>
			
			<a href="<c:url value="/reserva/cliente?dni=${ dniCliente }"/>" class="btn btn-lg btn-info" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
					
		</div>
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
		
		$('#btnBuscarTalleres').click( function(){
			
			let parametros = '?provincia=' + $('#provinciaSelect').val() + '&localidad=' + $('#localidadSelect').val() 
			+ '&especialidad=' + $('#especialidadSelect').val() + '&dniCliente=' + ${ dniCliente };
			
			$(location).attr('href', "<c:url value='filtrado' />" + parametros);
		});
		
		</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>