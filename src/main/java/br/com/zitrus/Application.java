package br.com.zitrus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.zitrus.entity.Cliente;

public class Application {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("felipe");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("zitrus");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
}
