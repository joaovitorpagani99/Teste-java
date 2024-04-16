package com.br.rang.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.rang.model.UnidadeDeSaude;
import com.br.rang.repository.UnidadeSaudeRepository;
import com.br.rang.util.FacesMessages;
import com.br.rang.util.Transacional;

public class UnidadeDeSaudeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages facesMessages;

	@Inject
	private UnidadeSaudeRepository repository;

	@Transacional
	public void save(UnidadeDeSaude unidadeDeSaude) {
		// Verificar se o CNES já existe
		UnidadeDeSaude unidadeExistente = repository.buscarUnidadeSaudePorCNES(unidadeDeSaude.getCnes());
		if (unidadeExistente != null) {
			facesMessages.info("Erro ao salvar. CNES já existe.");
			return;
		}

		// Verificar se a faixa de CEP se sobrepõe a de outra unidade
		boolean cepSobreposto = repository.verificaFaixaCep(Integer.parseInt(unidadeDeSaude.getCepInicial()),
				Integer.parseInt(unidadeDeSaude.getCepFim()));
		if (cepSobreposto) {
			facesMessages.info("Erro ao salvar. Faixa de CEP se sobrepõe a de outra unidade.");
			return;
		}

		// Se passar nas verificações, salvar a unidade de saúde
		UnidadeDeSaude object = repository.save(unidadeDeSaude);
		if (object != null) {
			facesMessages.info("Salvo com sucesso.");
		} else {
			facesMessages.info("Erro ao salvar.");
		}
	}

	@Transacional
	public void excluir(UnidadeDeSaude unidadeDeSaude) {
		repository.remover(unidadeDeSaude);
	}

	public boolean validarFaixasCEP(String cepInicial, String cepFinal) {
		return false;
	}

	public UnidadeDeSaude buscarUnidadeSaudePorCEP(String cep) {
		UnidadeDeSaude unidadeDeSaude = repository.buscarUnidadeSaudePorCEP(cep);
		if (unidadeDeSaude == null) {
			facesMessages.info("Não tem registros.");
			return null;
		} else {
			facesMessages.info("Unidade encontrada.");
			return unidadeDeSaude;
		}
	}

}
