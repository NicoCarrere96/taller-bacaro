<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	    <!-- w3 CSS -->
		<link href="<c:url value="/css/w3.css" />" rel="stylesheet">
	    
	</head>
	<body>
	<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
	  <h1>BuscoTaller.com</h1>
	  <p>La manera mas facil y comoda de conseguir taller</p> 
	</div>
	<div class="container">
		<h2>Estimado Cliente, por favor ingrese su DNI </h2>

		<c:choose>
			<c:when test="${ empty encontrado }">
				<form:form action="cliente/buscarCliente" method="POST" id="clienteForm" modelAttribute="cliente">				            
		  		    <div class="form-inline">
				        <label for="dni" class="control-label">DNI:</label>
						<form:input path="dni" class="form-control" size="8" name="dni" id="dni" type="text" required="required"/>
				    </div>                    
				    <br>
				    <div class="form-group">
				        <button type="submit" class="btn btn-primary">Buscar</button>
				    </div>     
				</form:form>
			</c:when>
			<c:otherwise>
				<form:form action="guardarCliente" method="POST" id="clienteForm" modelAttribute="cliente">
					<c:choose>
						<c:when test="${ encontrado }">
							<div class="alert alert-dark" role="alert">
							  	Por favor confirme sus datos
							</div>
						</c:when>
						<c:otherwise>
							<div class="alert alert-warning" role="alert">
							  	Usted no esta registrado en nuestra base de datos, por favor complete el siguiente formulario.
							</div>
						</c:otherwise>
					</c:choose>
		   		    <div class="form-group">
				        <label for="fecha" class="control-label">DNI:</label>
						<form:input path="dni" type="number" class="form-control" value="${ cliente.dni }"/>
				    </div>
		  		    <div class="form-group">
				        <label for="fecha" class="control-label">Nombre:</label>
						<form:input path="nombre" type="text" class="form-control" value="${ cliente.nombre }"/>
				    </div> 
		   		    <div class="form-group">
				        <label for="fecha" class="control-label">Apellido:</label>
						<form:input path="apellido" type="text" class="form-control" value="${ cliente.apellido }"/>
				    </div> 
				       		    <div class="form-group">
				        <label for="fecha" class="control-label">Mail:</label>
						<form:input path="mail" type="email" class="form-control" value="${ cliente.mail }"/>
				    </div>
		   		    <div class="form-group">
				        <label for="fecha" class="control-label">Telefono:</label>
						<form:input path="telefono" type="text" class="form-control" value="${ cliente.telefono }"/>
				    </div>
   				    <div class="form-group">
				        <form:button type="submit" class="btn btn-lg btn-block btn-info" >
				        	<c:choose>
				        		<c:when test="${ encontrado }">
									Avanzar
				        		</c:when> 
				        		<c:otherwise>
						        	Guardar
				        		</c:otherwise>
				        	</c:choose>
				        </form:button>
				    </div>     
			    </form:form>
			</c:otherwise>
		</c:choose>
		
		<a href="<c:url value="/"/>" class="w3-button w3-round-xxlarge w3-blue" role="button"><span
		class="glyphicon glyphicon-hand-left w3-center"></span>  Volver</a>
	</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
		</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>