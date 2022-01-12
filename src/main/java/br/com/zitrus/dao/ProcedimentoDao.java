package br.com.zitrus.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.zitrus.entity.Procedimento;

public class ProcedimentoDao {

	private EntityManager entityManager;
	private final String FIND_ALL = "Select p from Procedimento p";
	private final String FIND_ALL_BY_ID = "Select p from Procedimento p where p.id = :id";
	
	public ProcedimentoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Procedimento> buscarProcedimentos() {		
		return this.entityManager.createQuery(FIND_ALL).getResultList();
	}

	public void cadastrarProcedimento(Procedimento procedimento) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(procedimento);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	public List<Procedimento> buscarProcedimentosPorParametro(Integer id) {
		return this.entityManager
				.createQuery(FIND_ALL_BY_ID)
				.setParameter("id", id)
				.getResultList();
	}

	public Procedimento buscarProcedimentosPorId(Integer id) {
		return this.entityManager.find(Procedimento.class, id);
	}
	
	
	
	
	
}
