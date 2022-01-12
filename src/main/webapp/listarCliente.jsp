<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.zitrus.entity.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
	<div class="container">
		<h2>Lista de clientes</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Sexo</th>
					<th>Data de Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.sexo.nome}</td>
						<td><fmt:formatDate value="${cliente.nascimento}"
								pattern="dd/MM/yyyy" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>