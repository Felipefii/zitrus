package br.com.zitrus.entity.enums;

public enum Sexo {
	
	MASCULINO("M"),
	FEMININO("F");

	private String nome;

	Sexo(String nome) {
		this.nome = nome;
	}
	
	public static Sexo buscarSexoPorNome(String sexo) {
		for(Sexo type : Sexo.values()) {
			if(type.getNome().equals(sexo)) {
				return type;
			}			 
		}
		return null;
	}

	public String getNome() {
		return nome;
	}
	
}
