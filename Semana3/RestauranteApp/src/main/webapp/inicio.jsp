<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<title>Restaurante App</title>
</head>
<body>

	<div class="container">
		<h2>Restaurante App</h2>
		<div class="card">
			<div class="card-header">Grupo 5</div>
			<div class="card-body">
				<ul class="list-group">
					<li class="list-group-item">Gustavo Coronel</li>
					<li class="list-group-item">Pablo</li>
					<li class="list-group-item">Armando</li>
				</ul>
			</div>
		</div>


		<c:if test="${control==1}">
		
			<div class="card">
				<div class="card-header">Ingreso de datos</div>
				<div class="card-body">
					<form method="post" action="Procesar">
						<div class="form-group row">
							<label for="personas" class="col-sm-2 col-form-label">Cantidad
								personas:</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="personas"
									name="personas" placeholder="Cantidad de personas">
							</div>
						</div>
						<div class="form-group row">
							<label for="dias" class="col-sm-2 col-form-label">Cantidad
								Dias:</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="dias" name="dias"
									placeholder="Cantidad días">
							</div>
						</div>
						<div class="form-group row">
							<label for="dias" class="col-sm-2 col-form-label">Tipo de
								hospaje:</label>
							<div class="col-sm-10">
								<select class="custom-select" id="hospedaje" name="hospedaje">
									<c:forEach var="r" items="${hospedaje}">
										<option value="${r.id}">${r.nombre}</option>
									</c:forEach>
								</select>
								<div id="detalleHospedaje">0.0</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="desayuno" class="col-sm-2 col-form-label">Tipo
								de desayuno:</label>
							<div class="col-sm-10">
								<select class="custom-select" id="desayuno" name="desayuno">
									<c:forEach var="r" items="${desayuno }">
										<option value="${r.id}">${r.nombre}</option>
									</c:forEach>
								</select>
								<div id="detalleDesayuno">0.0</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="almuerzo" class="col-sm-2 col-form-label">Tipo
								de almuerzo:</label>
							<div class="col-sm-10">
								<select class="custom-select" id="almuerzo" name="almuerzo">
									<c:forEach var="r" items="${almuerzo}">
										<option value="${r.id}">${r.nombre}</option>
									</c:forEach>
								</select>
								<div id="detalleAlmuerzo">0.0</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="cena" class="col-sm-2 col-form-label">Tipo de
								cena:</label>
							<div class="col-sm-10">
								<select class="custom-select" id="cena" name="cena">
									<c:forEach var="r" items="${cena}">
										<option value="${r.id}">${r.nombre}</option>
									</c:forEach>
								</select>
								<div id="detalleCena">0.0</div>
							</div>
						</div>
						<div class="form-group row">
							<button type="submit" class="btn btn-primary btn-lg btn-block">Procesar</button>
						</div>
					</form>
				</div>
			</div>
			
		</c:if>

		<c:if test="${control==2}">
			<div class="card">
				<div class="card-header">Resultado</div>
				<div class="card-body">
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Cantidad
							personas:</label>
						<div class="col-sm-4">${model.personas}</div>
					</div>
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Cantidad
							dias:</label>
						<div class="col-sm-4">${model.dias}</div>
					</div>
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Tipo
							de hospedaje: ${model.strHospedaje }</label>
						<div class="col-sm-4">${model.impHospedaje}</div>
					</div>
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Desayuno:
							${model.strDesayuno }</label>
						<div class="col-sm-4">${model.impDesayuno}</div>
					</div>
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Almuerzo:
							${model.strAlmuerzo }</label>
						<div class="col-sm-4">${model.impAlmuerzo}</div>
					</div>
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Cena:
							${model.strCena }</label>
						<div class="col-sm-4">${model.impCena}</div>
					</div>
					<div class="form-group row">
						<label for="personas" class="col-sm-8 col-form-label">Importe
							Total</label>
						<div class="col-sm-4">${model.total}</div>
					</div>
					<div>
						<form action="home" class="form-group row">
							<button type="submit" class="btn btn-primary btn-lg btn-block">Nuevo</button>
						</form>
					</div>

				</div>
			</div>
		</c:if>

	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function() {
			$("#hospedaje").change(fnCargaPrecioHospedaje);
			$("#desayuno").change(fnCargaPrecioDesayuno);
			$("#almuerzo").change(fnCargaPrecioAlmuerzo);
			$("#cena").change(fnCargaPrecioCena);
		});

		function fnCargaPrecioHospedaje() {
			let hospedaje = $("#hospedaje").val();
			if (hospedaje == 0) {
				$("#detalleHospedaje").html("Seleccione un valor correcto.");
				return;
			}
			let url = "traerPrecio";
			let data = "categoria=1&item=" + hospedaje;
			$.get(url, data, function(texto) {
				$("#detalleHospedaje").html(texto);
			});
		}
		
		function fnCargaPrecioDesayuno() {
			let desayuno = $("#desayuno").val();
			if (desayuno == 0) {
				$("#detalleDesayuno").html("Seleccione un valor correcto.");
				return;
			}
			let url = "traerPrecio";
			let data = "categoria=2&item=" + desayuno;
			$.get(url, data, function(texto) {
				$("#detalleDesayuno").html(texto);
			});
		}
		

		function fnCargaPrecioAlmuerzo() {
			let almuerzo = $("#almuerzo").val();
			if (almuerzo == 0) {
				$("#detalleAlmuerzo").html("Seleccione un valor correcto.");
				return;
			}
			let url = "traerPrecio";
			let data = "categoria=3&item=" + almuerzo;
			$.get(url, data, function(texto) {
				$("#detalleAlmuerzo").html(texto);
			});
		}
		

		function fnCargaPrecioCena() {
			let cena = $("#cena").val();
			if (cena == 0) {
				$("#detalleCena").html("Seleccione un valor correcto.");
				return;
			}
			let url = "traerPrecio";
			let data = "categoria=4&item=" + cena;
			$.get(url, data, function(texto) {
				$("#detalleCena").html(texto);
			});
		}
	</script>
</body>
</html>
