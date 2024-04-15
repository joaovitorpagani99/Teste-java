package com.br.rang.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "unidade_de_saude")
public class UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cnes;

	private String nomeUnidadeSaude;
	
	private String cepInicial;
	
	private String cepFim;

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

	public String getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(String cepInicial) {
		this.cepInicial = cepInicial;
	}

	public String getCepFim() {
		return cepFim;
	}

	public void setCepFim(String cepFim) {
		this.cepFim = cepFim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cepFim, cepInicial, cnes, id, nomeUnidadeSaude);
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
		return Objects.equals(cepFim, other.cepFim) && Objects.equals(cepInicial, other.cepInicial)
				&& Objects.equals(cnes, other.cnes) && Objects.equals(id, other.id)
				&& Objects.equals(nomeUnidadeSaude, other.nomeUnidadeSaude);
	}

	@Override
	public String toString() {
		return "UnidadeDeSaude [id=" + id + ", cnes=" + cnes + ", nomeUnidadeSaude=" + nomeUnidadeSaude
				+ ", cepInicial=" + cepInicial + ", cepFim=" + cepFim + "]";
	}

	
}
