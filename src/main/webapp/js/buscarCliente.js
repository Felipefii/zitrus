$(document).on("change", "#buscar-clientes", function() {
	var $param = document.querySelector("#buscar-clientes").value;
	$.get("autorizaProcedimento?op=cliente&param=" + $param, function(responseJson) {
		if (document.getElementById('tb-c') != null) {
			document.getElementById('tb-c').remove();
		}
		var $table = $("<table class='table' id='tb-c'>").appendTo($("#table-clientes"));
		var $tbody = $("<tbody>").appendTo($table);
		$.each(responseJson, function(index, cliente) {
			var $tr = $("<tr>").appendTo($tbody);
			var $td = $("<td>").appendTo($tr).text(cliente.nome);
			var $td2 = $("<td>").appendTo($tr);
			var $nome = cliente.nome;
			var $btn = "<input type='button' class='btn btn-primary' value='Selecionar' onClick='selectCliente(" + cliente.id + ")'>";
			$($btn)
				.appendTo($td2).text("selecionar");
		});
	});
});

function selectCliente(id) {

	$.get("autorizaProcedimento?op=selectCliente&param=" + id, function(responseJson) {
		var inputClienteId = document.querySelector("#idCliente");
		inputClienteId.value = id;
		var $inputClient = document.querySelector("#buscar-clientes");
		$inputClient.value = responseJson.nome;
		$inputClient.disabled = true;

	});
	if (document.getElementById('table-clientes') != null) {
		document.getElementById('table-clientes').remove();
	}
}
