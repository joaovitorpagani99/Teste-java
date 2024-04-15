package com.br.rang.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.rang.model.UnidadeDeSaude;

@Named
@ViewScoped
public class UnidadeDeSaudeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeDeSaude unidadeDeSaude;

	public UnidadeDeSaude getUnidadeDeSaude() {
		return unidadeDeSaude;
	}

	public void salvar() {
		System.out.println("" + unidadeDeSaude.toString());
	}

}
