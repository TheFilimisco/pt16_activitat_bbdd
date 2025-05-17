package customerDAO;

import sqlInjection.Connexio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainCustomerDAO {

    public void menu(){
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els Customers\n"
                + "2) Selecciona un sol Customer\n"
                + "3) Introdueix un Customer\n"
                + "4) Modifica un Customer\n"
                + "5) Elimina un Customer\n"
                + "0) Sortir\n"
        );
    }
    public static void main(String[] args) throws SQLException {
        Connection con = Connexio.getConnection();
        CustomerDAO customerDAO = new CustomerDAOImplementacio();
        MainCustomerDAO main = new MainCustomerDAO();

        main.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt(); sc.nextLine();
        while(opcio != 0){
            switch(opcio){
                case 1:{
                    customerDAO.getCustomers().forEach(System.out::println);
                    break;
                }
                case 2:{
                    System.out.println("Introdueix quin Customer vols veure");
                    int idCustomer = sc.nextInt();sc.nextLine();
                    System.out.println(customerDAO.read(idCustomer));
                    break;
                }
                case 3: {
                    System.out.println("Introdueix el LastName nou");
                    String lastName = sc.nextLine();
                    System.out.println("Introdueix el FirstName nou");
                    String firstName = sc.nextLine();
                    System.out.println("Introdueix el Company nou");
                    String company = sc.nextLine();
                    System.out.println("Introdueix el Address nou");
                    String address = sc.nextLine();
                    System.out.println("Introdueix el City nou");
                    String city = sc.nextLine();
                    System.out.println("Introdueix el State nou");
                    String state = sc.nextLine();
                    System.out.println("Introdueix el Country nou");
                    String country = sc.nextLine();
                    System.out.println("Introdueix el PostalCode nou");
                    String postalCode = sc.nextLine();
                    System.out.println("Introdueix el Phone nou");
                    String phone = sc.nextLine();
                    System.out.println("Introdueix el Fax nou");
                    String fax = sc.nextLine();
                    System.out.println("Introdueix el Email nou");
                    String email = sc.nextLine();
                    System.out.println("Introdueix el SupportRepId nou");
                    int supportRepId = sc.nextInt();
                    System.out.println("Customer created: " + customerDAO.create(new Customer(0,lastName,
                            firstName,company,address,city,state,country,postalCode,phone,fax,email,supportRepId)));
                    break;
                }
                case 4: {
                    System.out.println("Introdueix quin Customer vols modificar");
                    int idCustomer = sc.nextInt();sc.nextLine();
                    System.out.println("Introdueix el LastName nou");
                    String lastName = sc.nextLine();
                    System.out.println("Introdueix el FirstName nou");
                    String firstName = sc.nextLine();
                    System.out.println("Introdueix el Company nou");
                    String company = sc.nextLine();
                    System.out.println("Introdueix el Address nou");
                    String address = sc.nextLine();
                    System.out.println("Introdueix el City nou");
                    String city = sc.nextLine();
                    System.out.println("Introdueix el State nou");
                    String state = sc.nextLine();
                    System.out.println("Introdueix el Country nou");
                    String country = sc.nextLine();
                    System.out.println("Introdueix el PostalCode nou");
                    String postalCode = sc.nextLine();
                    System.out.println("Introdueix el Phone nou");
                    String phone = sc.nextLine();
                    System.out.println("Introdueix el Fax nou");
                    String fax = sc.nextLine();
                    System.out.println("Introdueix el Email nou");
                    String email = sc.nextLine();
                    System.out.println("Introdueix el SupportRepId nou");
                    int supportRepId = sc.nextInt();
                    customerDAO.update(new Customer(idCustomer,lastName,firstName,company,address,
                            city,state,country,postalCode,phone,fax,email,supportRepId));
                    break;
                }
                case 5: {
                    System.out.println("Introdueix quin Customer vols eliminar");
                    int idCustomer = sc.nextInt();sc.nextLine();
                    customerDAO.delete(idCustomer);
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Introdueix un nombre vàlid del 0 al 6");
                    break;
            }
            main.menu();
            opcio = sc.nextInt(); sc.nextLine();
        }
        con.close();
    }
}
