package com.br.rang.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.br.rang.model.UnidadeDeSaude;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UnidadeSaudeRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public UnidadeSaudeRepository() {
	}

	public UnidadeSaudeRepository(EntityManager manager) {
		this.manager = manager;
	}

	public UnidadeDeSaude getId(Long id) {
		return manager.find(UnidadeDeSaude.class, id);
	}

	public List<UnidadeDeSaude> buscar(String nomeUnidadeSaude) {
		TypedQuery<UnidadeDeSaude> query = manager.createQuery(
				"from unidade_de_saude where nomeUnidadeSaude like :nomeUnidadeSaude", UnidadeDeSaude.class);
		query.setParameter("nomeUnidadeSaude", nomeUnidadeSaude + "%");
		return query.getResultList();
	}

	public UnidadeDeSaude save(UnidadeDeSaude unidadeDeSaude) {
		return manager.merge(unidadeDeSaude);
	}

	public void remover(UnidadeDeSaude unidadeDeSaude) {
		unidadeDeSaude = getId(unidadeDeSaude.getId());
		manager.remove(unidadeDeSaude);
	}

}
