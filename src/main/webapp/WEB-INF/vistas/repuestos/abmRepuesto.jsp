<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<!-- w3 CSS -->
<link href="<c:url value="/css/w3.css" />" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="<c:url value="/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
</head>

<body>
	<div class="jumbotron text-center"
		style="background-color: #0d80b3; color: white">
		<h1>BuscoTaller.com</h1>
		<p>La manera mas facil y comoda de conseguir taller</p>
		<span class="nav navbar-nav navbar-right">
					<a href="${pageContext.request.contextPath}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a>
				 </span> 
	</div>
	<nav>
	
		<div class="w3-bar w3-dark-grey">
				<a href="<c:url value="/reserva/lista" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Consultar Reservas</a>
  				<a href="<c:url value="/stockRepuestos/abmRepuestos" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Listado de Repuestos</a>
  				<a href="<c:url value="/taller/homeTaller" />" class="w3-bar-item w3-button w3-mobile" style="width:33%">Datos Taller</a>
	  			
		</div>
	
	</nav>

	<div class="container" style="margin-top: 20px !important">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<h1>Lista de Repuestos</h1>
						<a class="btn btn-default btn-circle"
							href="<c:url value="agregarRepuesto" />"><span
							class="glyphicon glyphicon"></span> Agregar Repuesto</a>
						<br>

						<table class="table table-striped custab">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Nombre</th>
									<th scope="col">Precio</th>
									<th scope="col">Stock</th>
									<th scope="col">Editar</th>
									<th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="r" items="${repuesto}">
									<tr>
										<td><c:out value="${r.id}" /></td>
										<td><c:out value="${r.nombre}" /></td>
										<td><c:out value="${r.precio}" /></td>
										<td><c:out value="${r.stock}" /></td>
										<td><c:out value="" /><a
											class="btn btn-default btn-circle"
											href="<c:url value="modificarRepuesto?idRepuesto=${r.getId()}" />"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td><c:out value="" /> <a
											class="btn btn-default btn-circle"
											href="<c:url value="eliminarRepuesto?idRepuesto=${r.getId()}" />"><span
												class="glyphicon glyphicon-trash"></span> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>


			</div>
		</div>
	</div>
	<br><br>
	<a href="<c:url value="/taller/homeTaller"/>" class="btn btn-lg btn-block btn-info" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
</body>
</html>
