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

  				 <span class="nav navbar-nav">
					<a href="${pageContext.request.contextPath}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a>
				 </span>
				</div>
	<nav>
	
		<div class="w3-bar w3-dark-grey">
				<a href="<c:url value="/reserva/lista"/>" class="w3-bar-item w3-button w3-mobile" style="width:33%">Consultar Reservas</a>
  				<a href="<c:url value="/stockRepuestos/abmRepuestos" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Listado de Repuestos</a>
  				<a href="<c:url value="/taller/homeTaller" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Datos Taller</a>
	  			
		</div>
	
	</nav>
	
	<div class="" style="margin:20px;">
	<h1>Bienvenido Sr. ${ taller.nombreDelDuenio }</h1> 
	<br>
	
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Nombre Del Taller: </span>${ taller.nombreDelTaller }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Direccion: </span>${ taller.calle } <span>  </span>${ taller.numero } <span> - </span>${ taller.localidad.nombre }<span> , </span>${ taller.localidad.provincia.nombre }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Email: </span>${ taller.usuario.email }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Telefono:  </span>${taller.telefono }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Pagina Web: </span>${ taller.paginaWeb }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Especialidad: </span>${ taller.especialidad.name }
	<br><br>	
	
	<a href="modificarTaller" class="btn btn-success" style="width:20%">Modificar Datos</a>
	</div>
	<br><br>
	<a href="<c:url value="/login"/>" class="btn btn-lg btn-info" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
	</body>
</html>