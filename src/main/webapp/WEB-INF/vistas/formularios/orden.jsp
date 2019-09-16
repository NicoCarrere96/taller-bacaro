<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Orden de Trabajo</title>
	</head>

	<body>
	<h2>Generar Orden de trabajo</h2>
		<form:form action="${ orden.reserva.id }" method="POST" modelAttribute="orden">
			<label >Taller: ${ orden.reserva.taller.nombreDelTaller } </label> <br>
			<label >Cliente: ${ orden.reserva.cliente.nombre } ${ orden.reserva.cliente.apellido }</label><br>
			<label >Mano de obra: $${ orden.reserva.taller.manoDeObra } </label><br>
			
			<label class="form-control">Horas de Trabajo: </label>
			<form:input path="horasDeTrabajo" id="horasDeTrabajo" type="number" class="form-control"/>

			<br>
			<form:button>Guardar Orden</form:button>
		</form:form>
		
	</body>
</html>