package com.br.rang.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "faixa_cep")
public class FaixaDeCEP implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String cepInicial;
	
	private String cepFim;
	
	@OneToOne
	private UnidadeDeSaude unidadeDeSaude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UnidadeDeSaude getUnidadeDeSaude() {
		return unidadeDeSaude;
	}

	public void setUnidadeDeSaude(UnidadeDeSaude unidadeDeSaude) {
		this.unidadeDeSaude = unidadeDeSaude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaixaDeCEP other = (FaixaDeCEP) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "FaixaDeCEP [id=" + id + ", cepInicial=" + cepInicial + ", cepFim=" + cepFim + ", unidadeDeSaude="
				+ unidadeDeSaude + "]";
	}
	
}
