<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<title>BuscoTaller.com</title>
 	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap core CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
	</head>
	<body>

<div class="jumbotron text-center" style="background-color:#0d80b3; color:white">
  <h1>BuscoTaller.com</h1>
  <p>La manera mas facil y comoda de conseguir taller</p> 
</div>
  

				
					<img alt="taller" src="img/img1.png" style="width: 100%; height: 45em;" />
					<div class="row align-items-center">
					<a href="cliente">
						<button type="button" class=" d-inline btn btn-warning col-sm-5" style="height: 6.5em;position: absolute;top: 85%; left:5%;">
							<h1>Soy Cliente</h1>
						</button>
					</a>
					<a href="login">
						<button type="button" class=" d-inline btn btn-warning col-sm-5" style="height: 6.5em;position: absolute;top: 85%; left:55%;">
							<h1 class="display-1">Tengo un Taller</h1>
						</button>
					</a>
			</div>	
		
		
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>