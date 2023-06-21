package perspro.jpa.broker;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import perspro.model.Person;

public class PersonBroker extends BrokerBase<Person> {

	@Override
	public List<Person> getAll() {
		EntityManager em = getConnection();
		List<Person> persons = (List<Person>) em.createQuery("from Person").getResultList();
		em.close();
		return persons;
	}

	@Override
	public Person getById(int persNo) {
		EntityManager em = getConnection();
		Query query = em.createQuery("from Person where persNo=:persNo");
		query.setParameter("persNo", persNo);
		Person p = (Person)query.getSingleResult();
		em.close();
		return p;
	}
}
