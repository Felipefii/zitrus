package br.com.zitrus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zitrus.entity.enums.Sexo;

@Entity
public class Procedimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idadeMinima;
	private Sexo sexoPermito;
	private Boolean isPermitido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdadeMinima() {
		return idadeMinima;
	}
	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}
	public Sexo getSexoPermito() {
		return sexoPermito;
	}
	public void setSexoPermito(Sexo sexoPermito) {
		this.sexoPermito = sexoPermito;
	}
	public Boolean getIsPermitido() {
		return isPermitido;
	}
	public void setIsPermitido(Boolean isPermitido) {
		this.isPermitido = isPermitido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedimento other = (Procedimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
