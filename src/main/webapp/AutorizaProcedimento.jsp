<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<c:url value="/autorizaProcedimento"
	var="linkServletAutorizaProcedimento" />

<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autorizar Procedimentos</title>
</head>
<body>
	<div class="container">
		<div class="form-group row">
			<label for="cliente" class="col-xs-2">Buscar Cliente</label> <input
				type="text" class="form-control col-xs-2" id="buscar-clientes"
				name="cliente"
				placeholder="Digite as letras e aperte enter para buscar" required>

		</div>
		<div class="form-group row">
			<label for="procedimento" class="col-xs-2">Buscar
				procedimento</label> <input type="text" class="form-control col-xs-2"
				id="buscar-procedimento" name="procedimento"
				placeholder="Digite numeros e aperte enter para buscar">
		</div>
		<div id="table-clientes"></div>
		<div id="table-procedimento"></div>
		<div id="form-autorizacao">
				 <input type='hidden' name="idCliente" id="idCliente">
				 <input type='hidden' name="idProcedimento" id="idProcedimento">
				<button class="btn btn-primary" onClick="cadastrarProcedimento()">Cadastrar</button>
			
		</div>
	</div>
</body>
</html>
<script src="js/buscarCliente.js"></script>
<script src="js/buscarProcedimento.js"></script>
<script src="js/cadastrarAutorizacaoProcedimento.js"></script>