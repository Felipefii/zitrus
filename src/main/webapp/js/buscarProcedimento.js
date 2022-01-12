
$(document).on("change", "#buscar-procedimento", function() {
	var $param = document.querySelector("#buscar-procedimento").value;
	$.get("autorizaProcedimento?op=procedimento&param=" + $param, function(responseJson) {
		if (document.getElementById('tb-c') != null) {
			document.getElementById('tb-c').remove();
		}
		var $table = $("<table class='table' id='tb-c'>").appendTo($("#table-procedimento"));
		var $tbody = $("<tbody>").appendTo($table);
		$.each(responseJson, function(index, procedimento) {
			var $tr = $("<tr>").appendTo($tbody);
			var $td = $("<td>").appendTo($tr).text(procedimento.id);
			$("<td>").appendTo($tr).text(procedimento.sexo);
			var $td2 = $("<td>").appendTo($tr);
			var $nome = procedimento.nome;
			var $btn = "<input type='button' class='btn btn-primary' value='Selecionar' onClick='selectProcedimento(" + procedimento.id + ")'>";
			$($btn)
				.appendTo($td2).text("selecionar");			
		});
	});
});

function selectProcedimento(id) {

	$.get("autorizaProcedimento?op=selectProcedimento&param=" + id, function(responseJson) {
		var inputProcedimentoId = document.querySelector("#idProcedimento");
		inputProcedimentoId.value = id;
		var $inputProcedimento = document.querySelector("#buscar-procedimento");
		$inputProcedimento.value = id;
		$inputProcedimento.disabled = true;

	});
	if (document.getElementById('table-procedimento') != null) {
		document.getElementById('table-procedimento').remove();
	}
}