package com.br.rang.service;

import java.io.Serializable;

import com.br.rang.model.UnidadeDeSaude;
import com.br.rang.repository.UnidadeSaudeRepository;
import com.br.rang.util.Transacional;

import jakarta.inject.Inject;

public class UnidadeDeSaudeService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UnidadeSaudeRepository repository;
	
	@Transacional
	public void save(UnidadeDeSaude unidadeDeSaude) {
		repository.save(unidadeDeSaude);
	}
	
	@Transacional
	public void excluir(UnidadeDeSaude unidadeDeSaude) {
		repository.remover(unidadeDeSaude);
	}
	
}