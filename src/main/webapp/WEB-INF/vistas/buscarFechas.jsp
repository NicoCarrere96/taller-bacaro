<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	    <link href="<c:url value="/css/bootstrap-datetimepicker.css" />"rel="stylesheet" type="text/css">
		<title>Reserva de Turnos</title>
	</head>

	<body>
	<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
  				<h1>BuscoTaller.com</h1>
  				<p>La manera mas facil y comoda de conseguir taller</p> 
				</div>
				<div class="container">
			<h1>Turnos disponibles a dos meses</h1>
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
			
				
				
				
				<div class="form-group"> 
				<br>
				<label for="fecha">Seleccione fecha:</label>
				
				
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Fecha </th>
							
							
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${fechas}" var="fecha">
							<tr>
								<th scope="row"></th>
									
									<td><fmt:formatDate pattern = "dd/MM/yyyy" type = "date"  value = "${fecha}" /></td>
									<td></td>
									<td></td>
									<td><a  href="${pageContext.request.contextPath}/horarios/<fmt:formatDate pattern = "dd/MM/yyyy" type = "date"  value = "${fecha}"/>/${diaDeAtencion}" 
									class="btn btn-lg btn-block btn-info" style="color: white" role="button" >Seleccionar</a>
									</td>
							</tr>
						</c:forEach>				
					</tbody>
				</table>
						
						
				
				</div>
				
				
			 	<a href="<c:url value="//"/>" class="btn btn-lg btn-block btn-info" style="color: white" role="button"><span class="glyphicon glyphicon-hand-left"></span></a>	 
				
			</div>
		</div>	

</body>
</html>