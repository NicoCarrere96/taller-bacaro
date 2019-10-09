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
<br>

	<div style="text-align: center" class="alert alert-success">
	
	    <h3>${aviso}</h3>
	    <br>
		<h3>${mensaje}</h3>
	</div>
		<div style="text-align: center" class="alert alert-danger">	
		<h3>${avisoError}</h3>
        <br>
		<h3>${mensajeError}</h3>
	</div>
	<br>
    <br>
	<br>
<br>		
	</jsp:attribute>
</t:nav-admin>	
	