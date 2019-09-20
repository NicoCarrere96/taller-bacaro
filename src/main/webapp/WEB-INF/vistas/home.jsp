<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	</head>
	</head>
	<body>
		<div class = "container">
		
			
			<h1>Bienvenidos a Taller Bacaro</h1>
			<p>Que esta buscando?</p>
			<form action="">
			<select>
			<option>Gomeria</option>
			<option>Mecanica General</option>
			<option>Encendido</option>
			<option>Inyeccion Electronica</option>
			<option>Rectificadora</option>
			</select>
			
			</form>
		
		</div>
		
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>