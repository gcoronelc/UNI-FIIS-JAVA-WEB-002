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
						</div>
					</div>
					<div class="form-group row">
						<button type="submit" class="btn btn-primary btn-lg btn-block">Procesar</button>
					</div>
				</form>
			</div>
		</div>

		<div class="card">
			<div class="card-header">Resultado</div>
			<div class="card-body">
				<div class="form-group row">
					<label for="personas" class="col-sm-2 col-form-label">Cantidad
						personas:</label>
					<div class="col-sm-10">${model.personas}</div>
				</div>
				<div class="form-group row">
					<label for="personas" class="col-sm-2 col-form-label">Cantidad
						dias:</label>
					<div class="col-sm-10">${model.dias}</div>
				</div>

			</div>
		</div>


		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
			crossorigin="anonymous"></script>
</body>
</html>
