package customerDAO;

import employeeDao.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    public int create(Customer customer) throws SQLException;
    public Customer read(int idCustomer) throws SQLException;
    public void update(Customer customer) throws SQLException;
    public void delete(int idCustomer) throws SQLException;
    public List<Customer> getCustomers() throws SQLException;
}
