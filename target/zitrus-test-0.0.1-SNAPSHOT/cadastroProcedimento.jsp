<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<c:url value="/CadastraProcedimento" var="linkServletNovoCliente" />

<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar procedimento</title>
</head>

<div class="container" style="width: 50%">

	<form action="${linkServletNovoCliente}" method="post">
		<div class="form-group row">
			<label for="nome" class="col-xs-2">Idade m�nima</label> <input
				type="text" class="form-control col-xs-2" name="idadeMinima" id="idadeMinima" required>
		</div>
		<div class="form-group row">
			<label for="sexo" class="col-xs-2">Sexo:</label> <select
				class="form-control col-xs-2" name="sexo">
				<option>M</option>
				<option>F</option>
			</select>
		</div>
		<div class="form-group row">
			<label for="permitido" class="col-xs-2">Permitido:</label> <select
				class="form-control col-xs-2" name="permitido">
				<option>Sim</option>
				<option>N�o</option>
			</select>
		</div>
		<button type="submit" class="btn btn-default">Cadastrar</button>
	</form>
</div>
</body>
</html>