<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<h2>Sobre o projeto</h2>
				<br>
				<h4>
					<strong>Objetivo:</strong> Autorização de procedimentos
				</h4>
				<br>
				<p>
					<strong>Como utilizar a aplicação:</strong> Para autorizar
					procedimentos, é necessário, primeiramente, ter cadastrado clientes
					e procedimentos.
				</p>
				<p>
					Para cadastrar clientes siga o link: <a
						href="/zitrus-test/cadastroCliente.jsp">Cadastrar cliente</a>
				</p>
				<p>
					Para cadastrar procedimentos siga o link: <a
						href="/zitrus-test/cadastroProcedimento.jsp">Cadastrar
						procedimento</a>
				</p>
				<p>
					Para autorizar procedimentos siga o link: <a
						href="/zitrus-test/AutorizaProcedimento.jsp">Autorizar
						procedimento</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>