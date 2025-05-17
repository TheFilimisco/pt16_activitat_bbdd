package employeeDao;

import artistDao.Artist;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    public int create(Employee employee) throws SQLException;
    public Employee read(int idEmployee) throws SQLException;
    public void update(Employee employee) throws SQLException;
    public void delete(int idEmployee) throws SQLException;
    public List<Employee> getEmployees() throws SQLException;
}
