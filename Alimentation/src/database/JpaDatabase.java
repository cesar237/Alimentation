package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaDatabase {
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;
	
	
	public JpaDatabase(String project) {
		System.out.println("Chargement de la base de données...");
		
		emf = Persistence.createEntityManagerFactory(project);
		em = emf.createEntityManager();
		transaction = em.getTransaction();
		
	}
	
	
	public EntityManager getEm() {
		return em;
	}

	
	public EntityTransaction getTransaction() {
		return transaction;
	}

	public void add(Object o) {
		transaction.begin();
		em.persist(o);
		transaction.commit();
	}
	
	public void remove(Object o) {
		transaction.begin();
		em.remove(o);
		transaction.commit();
	}
	
	public void close() {
		em.close();
		emf.close();
	}

}
