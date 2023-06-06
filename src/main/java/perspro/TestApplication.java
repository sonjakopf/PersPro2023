package perspro;

import java.util.List;

import perspro.facade.IDatabaseFacade;
import perspro.facade.JDBCDatabaseFacade;
import perspro.model.Person;

public class TestApplication {
	
	public static void main(String[] args) {
		
		IDatabaseFacade facade = new JDBCDatabaseFacade();
		List<Person> personList = facade.getAllPersons();
		
		for (Person p : personList) {
			System.out.println(p.getLname());
		}
	}
}
