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
				</div>
	<nav>
	
		<div class="w3-bar w3-dark-grey">
				<a href="<c:url value="/reserva/lista" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Consultar Reservas</a>
  				<a href="<c:url value="/stockRepuestos/abmRepuestos" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Listado de Repuestos</a>
  				<a href="<c:url value="/taller/homeTaller" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Datos Taller</a>
	  			
		</div>
	
	</nav>
	<br>
	<div class="container">
		<c:url value="/orden/nueva" var="action"/>
		<form:form action="${ action }" method="POST" id="ordenForm" modelAttribute="orden">
			<h2>Generar Orden de trabajo</h2>

			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><strong>Taller:</strong><br> ${ orden.reserva.taller.nombreDelTaller }</li>
			  <li class="list-group-item"><strong>Cliente:</strong><br> ${ orden.reserva.cliente.nombre } ${ orden.reserva.cliente.apellido }</li>
			  <li class="list-group-item"><strong>Mano de obra por hora:</strong><br> $ ${ orden.reserva.taller.manoDeObra }</li>
			  <li class="list-group-item"><strong>Problema:</strong><br> ${ orden.reserva.problema }</li>
			</ul>            
		                                                          

		            
  		    <div class="form-group">
		       
		    <form:hidden path="reserva.id"/>      
  		    <div class="form-group">
		        <label for="horasDeTrabajo" class="control-label">Horas de Trabajo:</label>
				<form:input path="horasDeTrabajo" class="form-control" type="number" required="required" value="${ orden.horasDeTrabajo }"/>
		    </div>                   
	    	<%-- <div class="form-group">
			    <label class="control-label">Repuestos:</label>
					<c:forEach items="${ orden.repuestos }" var="ordenRepuesto">
					<div id="repuesto-list">
				        <input type="text" class="form-control" value="${ ordenRepuesto.repuesto.nombre } - ${ ordenRepuesto.repuesto.precio }" disabled> 
					</div>
					</c:forEach>
				
					<form:select path="repuestos" class=" form-control custom-select" id="repuestoSelect">
					        <form:options items="${ listaRepuestos }" itemValue="id" itemLabel="nombre"/>
					</form:select>
					<button type="button" class="btn btn-warning sm" onclick="agregaRepuesto()">Agregar Repuesto</button>
			  </div>    --%>   
		    
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