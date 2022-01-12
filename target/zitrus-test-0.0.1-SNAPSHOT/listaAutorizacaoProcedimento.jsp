<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.zitrus.entity.AutorizacaoProcedimento"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>Lista de Autorização de procedimentos</title>
</head>
<body>
	<div class="container">
		<h2>Lista de Autorização de procedimentos</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Cliente</th>
					<th>Procedimento</th>
					<th>Data de inclusão</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${autorizacaoProcedimentos}" var="autProd">
					<tr>
						<td>${autProd.id}</td>
						<td>${autProd.cliente.nome}</td>
						<td>${autProd.procedimento.id}</td>
						<td><fmt:formatDate value="${autProd.dataCriacao}"
								pattern="dd/MM/yyyy" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>