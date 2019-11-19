<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<!-- w3 CSS -->
<link href="<c:url value="/css/w3.css" />" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="<c:url value="/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="https://secure.mlstatic.com/sdk/javascript/v1/mercadopago.js"></script>	
</head>

<body>
	<div class="jumbotron text-center"
		style="background-color: #0d80b3; color: white">
		<h1>BuscoTaller.com</h1>
		<p>La manera mas facil y comoda de conseguir taller</p>
	</div>

	<br>
	<div class="container">
		<h2>Factura</h2>

		<ul class="list-group list-group-flush">
			<li class="list-group-item"><strong>Taller:</strong><br> ${ factura.reserva.taller.nombreDelTaller }</li>
			<li class="list-group-item"><strong>Mano de obra por
					hora:</strong><br> ${ factura.reserva.taller.manoDeObra }</li>
			<li class="list-group-item"><strong>Horas de Trabajo:</strong><br>
				${ factura.horasDeTrabajo }</li>
			<li class="list-group-item">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Repuesto</th>
							<th scope="col">Precio U.</th>
							<th scope="col">Cantidad</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${ listaRepuestos }" var="ordRep">
							<tr>
								<td>${ ordRep.repuesto.nombre }</td>
								<td>${ ordRep.repuesto.precio }</td>
								<td>${ ordRep.cantidad }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</li>
			<li class="list-group-item"><strong>Total:</strong><br> $
				${ factura.total }</li>
		</ul>
			</div>
			<div class="w3-center">
		<a
			href="<c:url value="/factura/getPdf?reservaId=${ factura.reserva.id }"/>"
			class="btn btn-danger" role="button">Imprimir factura</a>
			</div>
			<div class=w3-center>
									<form action="http://localhost:8080/taller-bacaro/" method="GET">
  <script
   src="https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js"
   data-preference-id="${preference.id }">
  </script>
</form>
			</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="<c:url value="/js/bootstrap.min.js" />"
		type="text/javascript"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			window.Mercadopago.setPublishableKey("TEST-a8529179-2ca7-4bfd-b640-6dc0599242f0");
			window.Mercadopago.getIdentificationTypes();
			window.Mercadopago.getPaymentMethod({
			    "bin": bin
			}, setPaymentMethodInfo);
			$('.input-group.date').datepicker({
				format : "dd-mm-yyyy"
			}).datepicker("setDate", 'now');
			$('.input-group.date').datepicker({
				"setDate" : new Date(),
				"autoclose" : true
			});
		});
	</script>
	<script type="text/javascript">
	doSubmit = false;
	addEvent(document.querySelector('#pay'), 'submit', doPay);
	function doPay(event){
	    event.preventDefault();
	    if(!doSubmit){
	        var $form = document.querySelector('#pay');
	        window.Mercadopago.createToken($form, sdkResponseHandler); // The function "sdkResponseHandler" is defined below
	        return false;
	    }
	};
	function sdkResponseHandler(status, response) {
	    if (status != 200 && status != 201) {
	        alert("verify filled data");
	    }else{
	        var form = document.querySelector('#pay');
	        var card = document.createElement('input');
	        card.setAttribute('name', 'token');
	        card.setAttribute('type', 'hidden');
	        card.setAttribute('value', response.id);
	        form.appendChild(card);
	        doSubmit=true;
	        form.submit();
	    }
	};
	function getBin() {
		  const cardnumber = document.getElementById("cardnumber");
		  return cardnumber.substring(0,6);
		}
		function guessingPaymentMethod(event) {
		    var bin = getBin();
		    if (event.type == "keyup") {
		        if (bin.length >= 6) {
		            window.Mercadopago.getPaymentMethod({
		                "bin": bin
		            }, setPaymentMethodInfo);
		        }
		    } else {
		        setTimeout(function() {
		            if (bin.length >= 6) {
		                window.Mercadopago.getPaymentMethod({
		                    "bin": bin
		                }, setPaymentMethodInfo);
		            }
		        }, 100);
		    }
		};
		function setPaymentMethodInfo(status, response) {
		    if (status == 200) {
		        const paymentMethodElement = document.querySelector('input[name=paymentMethodId]');
		        if (paymentMethodElement) {
		            paymentMethodElement.value = response[0].id;
		        } else {
		            const input = document.createElement('input');
		            input.setattribute('name', 'paymentMethodId');
		            input.setAttribute('type', 'hidden');
		            input.setAttribute('value', response[0].id);     
		            form.appendChild(input);
		        }
		    } else {
		        alert(`payment method info error: ${response}`);  
		    }
		};
		</script>
		
</body>
</html>