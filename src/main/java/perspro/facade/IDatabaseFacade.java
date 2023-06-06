package perspro.facade;

import java.util.List;

import perspro.model.Department;
import perspro.model.Person;
import perspro.model.Project;

public interface IDatabaseFacade {
	
	// INSERT + UPDATE
	public void save(Object value);
	
	// DELETE
	public void delete(Object value);
	
	// READ
	public List<Person> getAllPersons();
	public Person getPersonByID(int id);
	
	public List<Department> getAllDepartments();
	public Department getDepartmentByID(int id);
	
	public List<Project> getAllProjects();
	public Project getProjectByID(int id);
}
