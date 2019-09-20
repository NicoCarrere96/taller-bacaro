<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
		

			<div class="row align-items-center">
				<h1>Bienvenidos a Taller Bacaro</h1>
					<a href="cliente">
						<button type="button" class=" d-inline btn btn-warning col-sm-6" style="height: 40em;">
							<h1 class="display-1">Soy Cliente</h1>
						</button>
					</a>
					<a href="login">
						<button type="button" class=" d-inline btn btn-warning col-sm-6" style="height: 40em;">
							<h1 class="display-1">Soy Taller</h1>
						</button>
					</a>
			</div>	
		</div>
		
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>