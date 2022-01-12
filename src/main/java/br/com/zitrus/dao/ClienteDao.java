package br.com.zitrus.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.zitrus.entity.Cliente;

public class ClienteDao {
	
	private EntityManager entityManager;
	
	private final String FIND_ALL = "Select c from Cliente c"; 
	private final String FIND_ALL_BY_NAME = "Select c from Cliente c where lower(c.nome) like lower(:nome)"; 

	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(cliente);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	public List<Cliente> buscarClientes(){
		return this.entityManager
				.createQuery(FIND_ALL)
				.getResultList();
	}
	
	public Cliente buscarClientePorId(Integer id) {
		return this.entityManager
				.find(Cliente.class, id);
				
	}

	public List<Cliente> buscarClientesPorParametro(String param) {		
		return this.entityManager
				.createQuery(FIND_ALL_BY_NAME)
				.setParameter("nome", param + "%")
				.getResultList();
	}
	
}
