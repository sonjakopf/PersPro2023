package perspro.jdbc.broker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import perspro.model.Department;
import perspro.model.Person;

public class PersonBroker extends BrokerBase<Person> {
	
	public List<Person> getAll() throws SQLException{
		
		List<Person> persons = new ArrayList<Person>();
		Connection c = getConnection();
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person");
			
			while (rs.next()) {
				Person p = new Person();
				
				p.setPersNo(rs.getInt("persno"));
				p.setFname(rs.getString("fname"));
				p.setLname(rs.getString("lname"));
				p.setfDate(rs.getDate("fdate").toLocalDate());
				if (rs.getDate("ldate") != null) {
					p.setlDate(rs.getDate("ldate").toLocalDate());
				}			
				Department dept = new Department();
				dept.setDeptNo(rs.getInt("department"));
				p.setDepartment(dept);
				// ... und so weiter
				
				persons.add(p);
			}
			
			return persons;
			
		} catch (SQLException e) {
			throw(e);
		} finally {
			c.close();
		}
	}

	@Override
	public Person getById(String persNo) throws SQLException {
		Connection c = getConnection();
		try {
			PreparedStatement stmt = c.prepareStatement("select * from person where persno = ?");
			stmt.setString(1, persNo);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Person p = new Person();
				
				p.setPersNo(rs.getInt("persno"));
				p.setFname(rs.getString("fname"));
				p.setLname(rs.getString("lname"));
				p.setfDate(rs.getDate("fdate").toLocalDate());
				if (rs.getDate("ldate") != null) {
					p.setlDate(rs.getDate("ldate").toLocalDate());
				}			
				Department dept = new Department();
				dept.setDeptNo(rs.getInt("department"));
				p.setDepartment(dept);
				// ... und so weiter
				
				return p;
			}
						
		} catch (SQLException e) {
			throw(e);
		} finally {
			c.close();
		}
		return null;
	}
	
	public void insert(Person value) throws SQLException {
		Connection c = getConnection();
		
		try {
			PreparedStatement statement = c.prepareStatement("insert into person (persno, fname, lname, department, salary, fdate, ldate, gender) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, value.getPersNo());
			statement.setString(2, value.getFname());
			statement.setString(3, value.getLname());
			statement.setObject(4, (value.getDepartment() != null ? value.getDepartment().getDeptNo() : null), Types.INTEGER);
			statement.setBigDecimal(5, value.getSalary());
			statement.setObject(6, value.getfDate() != null ? Date.valueOf(value.getfDate()) : null, Types.DATE);
			statement.setObject(7, value.getlDate() != null ? Date.valueOf(value.getlDate()) : null, Types.DATE);
			statement.setString(8, String.valueOf(value.getGender()));
			
			statement.toString();
			statement.execute();
		} catch (SQLException e) {
			throw(e);
		} finally {
			c.close();
		}		
	}
	
}
