package perspro.jdbc.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import perspro.facade.IDatabaseFacade;
import perspro.jdbc.broker.PersonBroker;
import perspro.model.Department;
import perspro.model.Person;
import perspro.model.Project;

public class JDBCDatabaseFacade implements IDatabaseFacade {
	
	public void save(Object value) {
		
		if (value instanceof Person) {
			PersonBroker pb  = new PersonBroker();
			try {
				pb.insert((Person) value);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		if (value instanceof Department) {
			// delegieren an DepartmentBroker analog zum PersonBroker
		}
		
		if (value instanceof Project) {
			// delegieren an DepartmentBroker analog zum PersonBroker 
		}
	}
	
	public void delete(Object value) {
		// analog zu save(Object value) an den jeweils zuständigen Broker delegieren
		
	}
	
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();
		PersonBroker pb = new PersonBroker();
		
		try {	
			persons = pb.getAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return persons;
		
	}
	
	public List<Department> getAllDepartments() {
		// delegieren an DepartmentBroker, analog zum PersonBroker
		return null;
		
	}
	
	public List<Project> getAllProjects() {
		// delegieren an ProjectBroker, analog zum PersonBroker
		return null;
		
	}

	public Person getPersonByID(int id) {
		PersonBroker pb = new PersonBroker();
		
		Person p = null;
		try {
			p = pb.getById(String.valueOf(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
		
	}


	public Department getDepartmentByID(int id) {
		// delegieren an DepartmentBroker, analog zum PersonBroker
		return null;
	}


	public Project getProjectByID(int id) {
		// delegieren an ProjectBroker, analog zum PersonBroker
		return null;
	}
}
