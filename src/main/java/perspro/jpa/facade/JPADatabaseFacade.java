package perspro.jpa.facade;

import java.util.List;

import perspro.facade.IDatabaseFacade;
import perspro.jpa.broker.PersonBroker;
import perspro.model.Department;
import perspro.model.Person;
import perspro.model.Project;

public class JPADatabaseFacade implements IDatabaseFacade{

	public void save(Object value) {
		if (value instanceof Person) {
			new PersonBroker().insert((Person)value);
		}
		// andere insert-Statements analog dazu
	}

	public void delete(Object value) {
		// analog zu save
		
	}

	public List<Person> getAllPersons() {
		PersonBroker pb = new PersonBroker();
		return pb.getAll();
	}

	public Person getPersonByID(int id) {
		PersonBroker pb = new PersonBroker();
		return pb.getById(id);
	}

	public List<Department> getAllDepartments() {
		// delegieren an DepartmentBroker, analog zu PersonBroker
		return null;
	}

	public Department getDepartmentByID(int id) {
		// delegieren an DepartmentBroker, analog zu PersonBroker
		return null;
	}

	public List<Project> getAllProjects() {
		// delegieren an ProjectBroker, analog zu PersonBroker
		return null;
	}

	public Project getProjectByID(int id) {
		// delegieren an ProjectBroker, analog zu PersonBroker
		return null;
	}

}
