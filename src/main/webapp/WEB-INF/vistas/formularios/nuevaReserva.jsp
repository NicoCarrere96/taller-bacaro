<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
		<title>Reserva de Turnos</title>
	</head>

	<body>
	<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
  				<h1>BuscoTaller.com</h1>
  				<p>La manera mas facil y comoda de conseguir taller</p> 
				</div>
	
	<div class="container">
		<form:form action="nuevaReserva" method="POST"  modelAttribute="reserva" >
			<h2>Reserva de Turno</h2>
             
             <div class="form-group">
		        <label for="problema" class="control-label">Taller:</label>
				<p>${ reserva.taller.nombreDelTaller }</p>
		    </div> 
            <div class="form-group">
		        <label for="problema" class="control-label">Direccion:</label>
				<p>${ reserva.taller.calle } ${ reserva.taller.numero } - ${ reserva.taller.localidad.nombre }</p>
		    </div> 
            <div class="form-group">
		        <label for="problema" class="control-label">Telefono:</label>
				<p>${ reserva.taller.telefono }</p>
		    </div> 
                                
            <div class="form-group">
		        <label for="problema" class="control-label">Problema:</label>
				<form:textarea path="problema" class="form-control"/>
		    </div> 
		    <div class="form-group">
		        <label for="fecha" class="control-label">Dia:</label>
				<form:input type="date" path="fecha" />
		    </div>
		             
		    <form:hidden path="taller.id" />
		    <form:hidden path="cliente.dni"/>
		    <form:hidden path="estado" />
		    
		    <div class="form-group"> <!-- Submit Button -->
		        <button type="submit" class="btn btn-primary">Guardar Orden</button>
		    </div>     
		</form:form>
	</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
		</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>