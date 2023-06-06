package perspro.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


	public void delete(Object value) {
		// TODO Auto-generated method stub
		
	}


	public Person getPersonByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Project getProjectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
