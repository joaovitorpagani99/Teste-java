package com.br.rang;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_de_saude")
public class UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cnes;

	private String nomeUnidadeSaude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getNomeUnidadeSaude() {
		return nomeUnidadeSaude;
	}

	public void setNomeUnidadeSaude(String nomeUnidadeSaude) {
		this.nomeUnidadeSaude = nomeUnidadeSaude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnes, id, nomeUnidadeSaude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeDeSaude other = (UnidadeDeSaude) obj;
		return Objects.equals(cnes, other.cnes) && Objects.equals(id, other.id)
				&& Objects.equals(nomeUnidadeSaude, other.nomeUnidadeSaude);
	}

	@Override
	public String toString() {
		return "UnidadeDeSaude [id=" + id + "]";
	}

}
