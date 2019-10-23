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
		
			
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<h1>TURNO</h1>
				<form:form action="${pageContext.request.contextPath}/validarTurno" method="POST" modelAttribute="turno" >
				
			 
				
					<div class="form-group">
						<br>
						<label>Fecha de Turno :</label> ${diaDeAtencion.dia}
						
				   	 	<fmt:formatDate type ="date"  value = "${fechaTurno}" />
						<form:input path="diaDeAtencion" id="diaDeAtencion" type="hidden" class="form-control" value="${diaDeAtencion}"  />
						
					 	
				    	<form:input path="fechaTurno" id="fechaTurno" type="hidden" class="form-control" value="${fechaTurno}"  /><br>
						
						
						<label >En el horario de :</label>
						<form:select path="horaTurno" id="horaTurno" class="form-control">
							<form:option value="0">Seleccione Horario</form:option>
							
									<c:forEach items="${horarios}" var="horarios">
										<form:option value="${horarios}"><fmt:formatDate type = "time" pattern="hh:mm"  value = "${horarios}" /></form:option>
									
									</c:forEach>
						
						</form:select>
						<br>
						<button class="btn btn-lg btn-block btn-info" style="color: white" Type="Submit"> Guardar</button>
		
					
					
					</div>
					
				
				</form:form>
			
				<a href="<c:url value="//"/>" class="btn btn-lg btn-block btn-info" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
				
			</div>
		</div>
		


</body>
</html>