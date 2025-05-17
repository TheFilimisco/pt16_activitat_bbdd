package customerDAO;

import employeeDao.EmployeeDAO;
import employeeDao.EmployeeDAOImplementacio;
import sqlInjection.Connexio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplementacio implements CustomerDAO {

    static Connection con = Connexio.getConnection();
    EmployeeDAO employeeDAO = new EmployeeDAOImplementacio();

    @Override
    public int create(Customer customer) throws SQLException {
        String query = "INSERT INTO Customer" +
                "(FirstName,LastName,Company,Address,City,State,Country,PostalCode,Phone,Fax,Email,SupportRepId)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getCompany());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getCity());
        ps.setString(6, customer.getState());
        ps.setString(7, customer.getCountry());
        ps.setString(8, customer.getPostalCode());
        ps.setString(9, customer.getPhone());
        ps.setString(10, customer.getFax());
        ps.setString(11, customer.getEmail());
        ps.setInt(12, customer.getSupportRepId().getIdEmployee());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    @Override
    public Customer read(int idCustomer) throws SQLException {
        String query = "SELECT * FROM Customer WHERE CustomerId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idCustomer);

        Customer customer = new Customer();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            customer.setIdCustomer(rs.getInt("CustomerId"));
            customer.setFirstName(rs.getString("FirstName"));
            customer.setLastName(rs.getString("LastName"));
            customer.setCompany(rs.getString("Company"));
            customer.setAddress(rs.getString("Address"));
            customer.setCity(rs.getString("City"));
            customer.setState(rs.getString("State"));
            customer.setCountry(rs.getString("Country"));
            customer.setPostalCode(rs.getString("PostalCode"));
            customer.setPhone(rs.getString("Phone"));
            customer.setFax(rs.getString("Fax"));
            customer.setEmail(rs.getString("Email"));
            customer.setSupportRepId(employeeDAO.read(rs.getInt("SupportRepId")));

        }
        if (check) {
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public void update(Customer customer) throws SQLException {
        String query = "UPDATE Customer SET FirstName=?, LastName=?, Company=?, Address=?, City=?, State=?, Country=?, PostalCode=?, Phone=?, Fax=?, Email=?, SupportRepId=? " +
                "WHERE CustomerId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getCompany());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getCity());
        ps.setString(6, customer.getState());
        ps.setString(7, customer.getCountry());
        ps.setString(8, customer.getPostalCode());
        ps.setString(9, customer.getPhone());
        ps.setString(10, customer.getFax());
        ps.setString(11, customer.getEmail());
        ps.setInt(12, customer.getSupportRepId().getIdEmployee());
        ps.setInt(13, customer.getIdCustomer());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idCustomer) throws SQLException {
        String query = "DELETE FROM Customer WHERE CustomerId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idCustomer);
        ps.executeUpdate();
    }

    @Override
    public List<Customer> getCustomers() throws SQLException {
        String query = "select * from customer";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Customer> customers = new ArrayList<>();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setIdCustomer(rs.getInt("CustomerId"));
            customer.setFirstName(rs.getString("FirstName"));
            customer.setLastName(rs.getString("LastName"));
            customer.setCompany(rs.getString("Company"));
            customer.setAddress(rs.getString("Address"));
            customer.setCity(rs.getString("City"));
            customer.setState(rs.getString("State"));
            customer.setCountry(rs.getString("Country"));
            customer.setPostalCode(rs.getString("PostalCode"));
            customer.setPhone(rs.getString("Phone"));
            customer.setFax(rs.getString("Fax"));
            customer.setEmail(rs.getString("Email"));
            customer.setSupportRepId(employeeDAO.read(rs.getInt("SupportRepId")));
            customers.add(customer);
        }
        return customers;
    }
}
