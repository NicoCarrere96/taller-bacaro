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
	</head>
	<body >
		 <div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
  				<h1>BuscoTaller.com</h1>
  				<p>La manera mas facil y comoda de conseguir taller</p> 
				</div>
	<nav>
	
		<div class="w3-bar w3-dark-grey">
  				<a href="<c:url value="/reserva/lista" />" class="w3-bar-item w3-button w3-mobile" style="width:20%">Consultar Orden</a>
  				<a href="/listados/repuestos.jsp" class="w3-bar-item w3-button w3-mobile" style="width:20%">Repuestos</a>
	  			<a href="/formularios/tallerD.jsp" class="w3-bar-item w3-button w3-mobile" style="width:20%">Ver Datos del Taller</a>
	
		</div>
	
	</nav>
	
	
	
	${ taller.nombreDelTaller }
	</body>
</html>