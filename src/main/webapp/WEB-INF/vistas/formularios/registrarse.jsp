
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body style="margin:50px">
 <div class="container">
<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<h1 class="form-signin-heading">Formulario de registro de Talleres</h1>
					<hr class="colorgraph"><br>
 
<form:form method="POST" commandName="taller">
 
<table>
<tr>
<td>Nombre del Taller : </td>
<td><form:input path="nombreDelTaller" /></td>
</tr>
<tr>
<td>Nombre del Dueño : </td>
<td><form:input path="nombreDelDuenio" /></td>
</tr>
<tr>
<td>Calle : </td>
<td><form:input path="calle" /></td>
</tr>
<tr>
<td>Numero : </td>
<td><form:input path="numero" /></td>
</tr>
<tr>
<td>Localidad : </td>
<td><form:input path="localidad" /></td>
</tr>
<tr>
<td>Telefono : </td>
<td><form:input path="telefono" /></td>
</tr>
<tr>
<td>Mail : </td>
<td><form:input path="usuario.email" id="email" type="email" class="form-control"/></td>
</tr>
<tr>
<td>Password : </td>
<td><form:input path="usuario.password" id="password" type="password" class="form-control"/></td>
</tr>

<tr>
<td>Pagina Web : </td>
<td><form:input path="paginaWeb" /></td>
</tr>
<tr>
<td>Especialidad : </td>
<td>
<form:select path="lista">
 <form:option value="NONE" label="--- Select ---"/>
 <form:options items="${ListaEspecialidades}" />
</form:select>
</td>
</tr>
  
<tr>
<td><button class="btn btn-lg btn-primary btn-block" Type="Submit">Enviar</button></td>
</tr>
</table>
</form:form>
 </div>
 </div>
 
 		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>