package perspro.jpa.broker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class BrokerBase<T> {
	
	public EntityManager getConnection(){
		EntityManagerFactory fact = Persistence.createEntityManagerFactory("PersProj");
		EntityManager entityManager = fact.createEntityManager();
		return entityManager;
	}
	
	
	public abstract List<T> getAll();
	public abstract T getById(int id);
	
	public void insert(T value) {
		EntityManager e = getConnection();
		EntityTransaction tx = e.getTransaction();
		tx.begin();
		e.merge(value); // merge macht update oder insert (je nachdem, ob dieser Eintrag in der DB bereits existiert)
		tx.commit();
	};

	
	public void delete(T value) {
		EntityManager e = getConnection();
		EntityTransaction tx = e.getTransaction();
		tx.begin();
		e.remove(value);
		tx.commit();
	}
	
}
