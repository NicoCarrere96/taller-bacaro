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
	<br>
	<div class="container">
		<c:url value="/orden/agregarRepuesto" var="action"/>
		<form:form action="${ action }" method="POST" modelAttribute="ordenRep">        
		                                                                    
		    
		    <form:hidden path="orden.id"/>   
		    <form:hidden path="orden.reserva.id"/>     
  		    <div class="form-group">
		        <label for="repuesto" class="control-label">Repuesto:</label>
   		    	<form:select path="repuesto.id" items="${ repuestos }" itemLabel="nombre" itemValue="id"></form:select>
   		    </div>                   
		    
  		    <div class="form-group">
		        <label for="cantidad" class="control-label">Cantidad:</label>
				<form:input path="cantidad" name="cantidad" class="form-control" type="number" required="required"/>
		    </div>                   
		    
		    <div class="form-group"> <!-- Submit Button -->
		        <button type="submit" class="btn btn-primary">Agregar Repuesto</button>
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