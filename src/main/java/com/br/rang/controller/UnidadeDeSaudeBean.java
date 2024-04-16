package com.br.rang.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.rang.model.UnidadeDeSaude;
import com.br.rang.service.UnidadeDeSaudeService;

@Named
@ViewScoped
public class UnidadeDeSaudeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeDeSaudeService service;

	private String cep;

	private UnidadeDeSaude unidadeDeSaude;

	public UnidadeDeSaudeBean() {
		unidadeDeSaude = new UnidadeDeSaude();
	}

	public void salvar() {
		try {
			service.save(unidadeDeSaude);
			this.unidadeDeSaude = new UnidadeDeSaude();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void buscarUnidadeSaudePorCEP() {
		this.unidadeDeSaude = new UnidadeDeSaude();
		this.unidadeDeSaude = service.buscarUnidadeSaudePorCEP(this.cep);
		System.out.println(this.unidadeDeSaude);
	}

	public UnidadeDeSaude getUnidadeDeSaude() {
		return unidadeDeSaude;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public UnidadeDeSaude getResultado() {
		return unidadeDeSaude;
	}

}
