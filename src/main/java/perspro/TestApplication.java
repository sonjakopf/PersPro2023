package perspro;

import perspro.facade.IDatabaseFacade;
import perspro.jpa.facade.JPADatabaseFacade;
import perspro.model.Person;

public class TestApplication {

	public static void main(String[] args) {

		IDatabaseFacade facade = new JPADatabaseFacade();

		// Laden von William Topman
		Person p1 = facade.getPersonByID(1);

		System.out.println(p1.getLname());

		// Umbenennen von William Topman in William Bottomman
		p1.setLname("Bottomman");

		facade.save(p1);

		p1 = facade.getPersonByID(1);

		System.out.println(p1.getLname());
	}
}
