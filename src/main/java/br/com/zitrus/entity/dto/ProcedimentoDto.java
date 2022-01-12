package br.com.zitrus.entity.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.zitrus.entity.Procedimento;
import br.com.zitrus.entity.enums.Sexo;

public class ProcedimentoDto {
	
	private Integer id;
	private Integer idade;
	private String sexoPermitido;
	private String isPermitido;
	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdade() {
		return idade;
	}
	private void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexoPermitido() {
		return sexoPermitido;
	}
	private void setSexoPermitido(Sexo sexoPermitido) {
		this.sexoPermitido = sexoPermitido.getNome();
	}
	public String getIsPermitido() {
		return isPermitido;
	}
	private void setIsPermitido(Boolean permitido) {
		this.isPermitido = permitido ? "Sim" : "Não";
	}

	public static List<ProcedimentoDto> criarListaProcedimentosDto(List<Procedimento> procedimentos) {
		List<ProcedimentoDto> procedimentosDto = new ArrayList<ProcedimentoDto>();
		ProcedimentoDto procedimentoDto;
		for(Procedimento procedimento : procedimentos) {
			procedimentoDto = new ProcedimentoDto();
			procedimentoDto.setId(procedimento.getId());
			procedimentoDto.setIdade(procedimento.getIdadeMinima());
			procedimentoDto.setSexoPermitido(procedimento.getSexoPermito());
			procedimentoDto.setIsPermitido(procedimento.getIsPermitido());
			procedimentosDto.add(procedimentoDto);
		}
		return procedimentosDto;
	}
}
