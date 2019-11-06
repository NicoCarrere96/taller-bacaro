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

	<br>
	<div class="container">
			<div class="" style="margin:20px;">
	<h1>Presupuesto Sr. ${ reserva.cliente.nombre  } ${ reserva.cliente.apellido }</h1> 
	<br>
	
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Nombre Del Taller: </span>${ reserva.taller.nombreDelTaller }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Mano De Obra por Hora: </span>${ reserva.taller.manoDeObra } 
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Problema: </span>${ reserva.problema }
	<br><br>
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Hs.Estimadas de Trabajo:  </span>${ orden.horasDeTrabajo }
	<br><br>
	<div class="form-group">
	    			<table class="table">
	    				<thead>
	    					<tr>
   						      <th scope="col">Repuesto</th>
						      <th scope="col">Precio U.</th>
						      <th scope="col">Cantidad</th>
	    					</tr>
	    				</thead>
	    				<tbody>
	    					<c:forEach items="${ repuestos }" var="ordRep">
	    						<tr>
	    							<td>${ ordRep.repuesto.nombre }</td>
	    							<td>${ ordRep.repuesto.precio }</td>
	    							<td>${ ordRep.cantidad }</td>
	    						</tr>
	    					</c:forEach>
	    				</tbody>
	    			</table>
				</div> 
	<span class="w3-white" style="text-shadow:1px 1px 0 #444">Total Presupuestado: </span>${ orden.total }
	<br><br>
	<a href="<c:url value="contestarPresupuesto?aprobado=true&id=${ reserva.id }" />" class="btn btn-success" style="width:20%">Aprobar</a>
	
	<a href="<c:url value="contestarPresupuesto?aprobado=false&id=${ reserva.id }" />" class="btn btn-success" style="width:20%">Rechazar</a>
	</div>
			</div> 
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
		</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>