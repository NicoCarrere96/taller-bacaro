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
		<title>Orden de Trabajo</title>
	</head>

	<body>
	
	<div class="container">
		<c:url value="/orden/nueva/${ orden.reserva.id }" var="action"/>
		<form:form action="${ action }" method="POST" id="ordenForm" modelAttribute="orden">
			<h2>Generar Orden de trabajo</h2>

			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><strong>Taller:</strong><br> ${ orden.reserva.taller.nombreDelTaller }</li>
			  <li class="list-group-item"><strong>Cliente:</strong><br> ${ orden.reserva.cliente.nombre } ${ orden.reserva.cliente.apellido }</li>
			  <li class="list-group-item"><strong>Mano de obra por hora:</strong><br> $ ${ orden.reserva.taller.manoDeObra }</li>
			  <li class="list-group-item"><strong>Problema:</strong><br> ${ orden.reserva.problema }</li>
			</ul>            
		                                                          
		            
  		    <div class="form-group">
		        <label for="horasDeTrabajo" class="control-label">Horas de Trabajo:</label>
				<form:input path="horasDeTrabajo" class="form-control" type="number" required="required" value="${ orden.horasDeTrabajo }"/>
		    </div>                   
<%-- 	    	<div class="form-group">
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
			  </div>   --%>
		    
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