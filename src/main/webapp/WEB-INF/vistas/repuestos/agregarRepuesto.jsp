<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
		
	<br>
	<div class="container">
	<h1>Agregar Repuesto</h1>
	<form:form action="guardarRepuesto" modelAttribute="repuesto" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
			    <div class="form-group col-md-12">
					<label for="nombre">Nombre</label>
					<form:input type="text" required="required" class="form-control"
						id="nombre" path="nombre" placeholder="Nombre" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="precio">Precio</label>
					<form:input type="number" required="required" class="form-control"
						id="precio" path="precio" placeholder="Precio" />
				</div>

				<div class="form-group col-md-12">
					<label for="stock">Stock</label>
					<form:input type="number" required="required" class="form-control"
						id="stock" path="stock" placeholder="Stock" />
				</div>			
								
				</div>

				<input type="submit" class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Guardar Repuesto">
			</div>
		
	</form:form>
</div>

	</jsp:attribute>
</t:nav-admin>	
	