package br.com.zitrus.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.zitrus.entity.AutorizacaoProcedimento;

public class AutorizacaoDao {
	
	private EntityManager entityManager;
	
	private final String FIND_ALL = "Select a from AutorizacaoProcedimento a";

	public AutorizacaoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrarAutorizacaoProcedimento(AutorizacaoProcedimento autorizacaoProcedimento) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(autorizacaoProcedimento);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	public List<AutorizacaoProcedimento> listarAutorizacaoProcedimentos() {
		return this.entityManager
				.createQuery(FIND_ALL)
				.getResultList();
	}

}
