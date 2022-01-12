function cadastrarProcedimento() {
	var inputClienteId = document.querySelector("#idCliente").value;
	var inputProcedimentoId = document.querySelector("#idProcedimento").value;

	if (inputClienteId == "" || inputProcedimentoId == "") {
		alert("Todos os campos devem ser preenchidos.")
	} else {
		cadastrar(inputClienteId, inputProcedimentoId);
	}
}

function cadastrar(idCliente, idProcedimento) {
	$.get("autorizaProcedimento?op=cadastrar&idCliente=" + idCliente + "&idProcedimento=" + idProcedimento, function(responseJson) {
		console.log(responseJson.erro);
		if (responseJson.erro == null) {
			window.location.href = "../zitrus-test/listarAutorizacaoProced";
		}else{
			alert(responseJson.erro);
			window.location.href = "../zitrus-test/AutorizaProcedimento.jsp";
		}


	});
}