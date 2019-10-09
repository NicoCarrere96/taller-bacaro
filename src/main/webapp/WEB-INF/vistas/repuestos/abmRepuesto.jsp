<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
	
<br>

<div class="container" style="margin-top: 60px !important">
	<div class="row color-invoice">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<h1>Lista de Repuestos</h1>
					<a class="btn btn-default btn-circle"
						href="${url}/agregarRepuesto"><span
						class="glyphicon glyphicon"></span> Agregar Repuesto</a>


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
										href="${url}/modificarRepuesto?idRepuesto=${r.getId()}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${url}/eliminarRepuesto?idRepuesto=${r.getId()}"><span
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
			
	</jsp:attribute>
</t:nav-admin>	
	