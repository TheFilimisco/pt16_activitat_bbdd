package employeeDao;

import sqlInjection.Connexio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImplementacio implements EmployeeDAO {

    static Connection con = Connexio.getConnection();

    @Override
    public int create(Employee employee) throws SQLException {
        String query = "INSERT INTO employee(LastName,FirstName,Title,ReportsTo,BirthDate,HireDate,Address,City,State,Country,PostalCode,Phone,Fax,Email)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, employee.getLastName());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getTitle());
        ps.setInt(4, employee.getReportsTo().getIdEmployee());
        ps.setTimestamp(5, Timestamp.valueOf(employee.getBirthDate()));
        ps.setTimestamp(6, Timestamp.valueOf(employee.getHireDate()));
        ps.setString(7, employee.getAddress());
        ps.setString(8, employee.getCity());
        ps.setString(9, employee.getState());
        ps.setString(10, employee.getCountry());
        ps.setString(11, employee.getPostalCode());
        ps.setString(12, employee.getPhone());
        ps.setString(13, employee.getFax());
        ps.setString(14, employee.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    @Override
    public Employee read(int idEmployee) throws SQLException {
        String query = "SELECT * FROM employee WHERE EmployeeId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idEmployee);
        Employee employee = new Employee();
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        while(rs.next()) {
            found = true;
            employee.setIdEmployee(rs.getInt("EmployeeId"));
            employee.setLastName(rs.getString("LastName"));
            employee.setFirstName(rs.getString("FirstName"));
            employee.setTitle(rs.getString("Title"));
            int reportsToId = rs.getInt("ReportsTo");
            // Verify if the value is different 0
            if (reportsToId != 0) {
                // Verify if a employee report himself for avoid loop
                if (reportsToId != idEmployee) {
                    employee.setReportsTo(read(reportsToId));
                }
            }
            employee.setBirthDate(rs.getTimestamp("BirthDate").toLocalDateTime());
            employee.setHireDate(rs.getTimestamp("HireDate").toLocalDateTime());
            employee.setAddress(rs.getString("Address"));
            employee.setCity(rs.getString("City"));
            employee.setState(rs.getString("State"));
            employee.setCountry(rs.getString("Country"));
            employee.setPostalCode(rs.getString("PostalCode"));
            employee.setPhone(rs.getString("Phone"));
            employee.setFax(rs.getString("Fax"));
            employee.setEmail(rs.getString("Email"));
        }
        if (found) {
            return employee;
        }else {
            return null;
        }
    }

    @Override
    public void update(Employee employee) throws SQLException {
        String query = "UPDATE Employee SET LastName=?, FirstName=?, Title=?, ReportsTo=?, BirthDate=?, HireDate=?, Address=?, City=?, State=?, Country=?, PostalCode=?, Phone=?, Fax=?, Email=? " +
                "WHERE EmployeeId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, employee.getLastName());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getTitle());
        ps.setInt(4, employee.getReportsTo().getIdEmployee());
        ps.setTimestamp(5, Timestamp.valueOf(employee.getBirthDate()));
        ps.setTimestamp(6, Timestamp.valueOf(employee.getHireDate()));
        ps.setString(7, employee.getAddress());
        ps.setString(8, employee.getCity());
        ps.setString(9, employee.getState());
        ps.setString(10, employee.getCountry());
        ps.setString(11, employee.getPostalCode());
        ps.setString(12, employee.getPhone());
        ps.setString(13, employee.getFax());
        ps.setString(14, employee.getEmail());
        ps.setInt(15, employee.getIdEmployee());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idEmployee) throws SQLException {
        String query = "DELETE FROM employee WHERE EmployeeId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idEmployee);
        ps.executeUpdate();
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        String query = "SELECT * FROM employee";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee();
            employee.setIdEmployee(rs.getInt("EmployeeId"));
            employee.setLastName(rs.getString("LastName"));
            employee.setFirstName(rs.getString("FirstName"));
            employee.setTitle(rs.getString("Title"));
            employee.setReportsTo(read(rs.getInt("ReportsTo")));
            employee.setBirthDate(rs.getTimestamp("BirthDate").toLocalDateTime());
            employee.setHireDate(rs.getTimestamp("HireDate").toLocalDateTime());
            employee.setAddress(rs.getString("Address"));
            employee.setCity(rs.getString("City"));
            employee.setState(rs.getString("State"));
            employee.setCountry(rs.getString("Country"));
            employee.setPostalCode(rs.getString("PostalCode"));
            employee.setPhone(rs.getString("Phone"));
            employee.setFax(rs.getString("Fax"));
            employee.setEmail(rs.getString("Email"));
            employees.add(employee);
        }

        return employees;
    }
}
