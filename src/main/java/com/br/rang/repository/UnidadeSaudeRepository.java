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

	public UnidadeDeSaude save(UnidadeDeSaude unidadeDeSaude) {

		UnidadeDeSaude object = manager.merge(unidadeDeSaude);

		if (object != null) {
			return unidadeDeSaude;
		} else {
			return null;
		}
	}

	public void remover(UnidadeDeSaude unidadeDeSaude) {
		unidadeDeSaude = getId(unidadeDeSaude.getId());
		manager.remove(unidadeDeSaude);
	}

	public UnidadeDeSaude buscarUnidadeSaudePorCEP(String cep) {
		int cepInt = Integer.parseInt(cep);

		TypedQuery<UnidadeDeSaude> query = manager.createQuery(
				"SELECT u FROM UnidadeDeSaude u WHERE u.cepInicial <= :cep AND u.cepFim >= :cep", UnidadeDeSaude.class);
		query.setParameter("cep", cepInt);

		List<UnidadeDeSaude> resultados = query.getResultList();

		if (!resultados.isEmpty()) {
			for (UnidadeDeSaude unidade : resultados) {
				if (cepInt >= Integer.parseInt(unidade.getCepInicial())
						&& cepInt <= Integer.parseInt(unidade.getCepFim())) {
					return unidade;
				}
			}
		}

		return null;
	}

	public UnidadeDeSaude buscarUnidadeSaudePorCNES(String cnes) {
		TypedQuery<UnidadeDeSaude> query = manager.createQuery("SELECT u FROM UnidadeDeSaude u WHERE u.cnes = :cnes",
				UnidadeDeSaude.class);
		query.setParameter("cnes", cnes);

		List<UnidadeDeSaude> resultados = query.getResultList();

		if (!resultados.isEmpty()) {
			return resultados.get(0);
		}

		return null;
	}

	public boolean verificaFaixaCep(int cepInicial, int cepFim) {
		TypedQuery<Long> query = manager.createQuery(
				"SELECT COUNT(u) FROM UnidadeDeSaude u WHERE (u.cepInicial <= :cepFim AND u.cepFim >= :cepInicial)",
				Long.class);
		query.setParameter("cepInicial", cepInicial);
		query.setParameter("cepFim", cepFim);

		return query.getSingleResult() > 0;
	}

}
