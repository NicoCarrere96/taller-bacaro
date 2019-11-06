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
	      <link href="<c:url value="/css/w3.css" />" rel="stylesheet" >
		<title>Reserva de turno
		</title>
	</head>
	<body>
	<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
	  <h1>BuscoTaller.com</h1>
	  <p>La manera mas facil y comoda de conseguir taller</p> 
	</div>

	<div class="container">
	 	 <table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Taller</th>
		      <th scope="col">Dueño</th>
		      <th scope="col">Telefono</th>
		      <th scope="col">Calle</th>
		      <th scope="col">Localidad</th>
		      <th scope="col">Provincia</th>
		      <th scope="col">Especialidad</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		<tbody>
		<c:forEach items="${talleres}" var="taller">
		  <tr>
		    <td class="row">${ taller.nombreDelTaller }</td>
			<td class="row">${ taller.nombreDelDuenio }</td>
			<td class="row">${ taller.telefono }</td>
			<td class="row">${ taller.calle } ${ taller.numero }</td>
			<td class="row">${ taller.localidad.nombre }</td>
			<td class="row">${ taller.localidad.provincia.nombre }</td>
			<td class="row">${ taller.especialidad }</td>
			<td><input type="button" value="Ver en Mapa" class="btn btn-success"
			onclick="window.open('https://www.google.com/maps/place/${taller.calle }+${taller.numero },${taller.localidad.nombre }','popUpWindow','height=600,width=1200,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no, status=yes');"></td>	
			<td><input type="button" value="Como llegar?" class="btn btn-warning"
			onclick="window.open('https://www.google.com/maps/dir/${taller.calle }+${taller.numero },${taller.localidad.nombre }','popUpWindow','height=600,width=1200,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no, status=yes');"></td>	
					
			<td class="row">
				<a href="<c:url value="/reserva/nueva?tallerId=${ taller.id }&dniCliente=${ dniCliente }" />">
					<button type="button" class="btn btn-info">
						Seleccionar
					</button>
				</a>
			</td>
		  </tr>
		
		</c:forEach>
		</tbody>
	</table>
	</div>
	
	
	
	
			<!-- Placed at the end of the document so the pages load faster -->
			
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>