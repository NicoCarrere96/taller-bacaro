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
	<h2>Generar Orden de trabajo</h2>
	
	<div class="container">
		<form:form action="${ orden.reserva.id }" method="POST" modelAttribute="orden">

			<%-- <form:hidden path="reserva" /> --%>
			<br>
			 <div class="form-group">
		        <label class="control-label">Taller:</label>
		        <input type="text" class="form-control" value="${ orden.reserva.taller.nombreDelTaller }" disabled>
		    </div>    
		
		    <div class="form-group">
		        <label class="control-label">Cliente:</label>
		        <input type="text" class="form-control" value="${ orden.reserva.cliente.nombre } ${ orden.reserva.cliente.apellido }" disabled>
		    </div>                    
		                            
		    <div class="form-group">
		        <label class="control-label">Mano de obra:</label>
		        <input type="text" class="form-control" value="$ ${ orden.reserva.taller.manoDeObra }" disabled> 
		    </div>    
		
		    <div class="form-group">
		        <label class="control-label">Problema:</label>
		        <textarea class="form-control" disabled>${ orden.reserva.problema }</textarea>
		    </div>                                    
		            
  		    <div class="form-group">
		        <label for="horasDeTrabajo" class="control-label">Horas de Trabajo:</label>
				<form:input path="horasDeTrabajo" class="form-control" name="horasDeTrabajo" id="horasDeTrabajo" type="number" required="required"/>
		    </div>                   
<%-- 		    <div class="form-group">
			    <label class="control-label">Repuestos:</label>
					<c:forEach items="${ orden.repuestos }" var="ordenRepuesto">
				        <input type="text" class="form-control" value="${ ordenRepuesto.repuesto.nombre } - ${ ordenRepuesto.cantidad }" disabled> 
					</c:forEach>
					
					<a href="agregarRepuesto"><button type="button" class="btn btn-warning sm">Agregar Repuesto</button></a>
			  </div>      --%>           
		    
		    <div class="form-group"> <!-- Submit Button -->
		        <button type="submit" class="btn btn-primary">Guardar Orden</button>
		    </div>     
		</form:form>
	</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>