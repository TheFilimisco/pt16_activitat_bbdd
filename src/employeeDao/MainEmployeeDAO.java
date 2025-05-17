package employeeDao;

import sqlInjection.Connexio;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainEmployeeDAO {

    public void menu(){
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els Employees\n"
                + "2) Selecciona un sol Employee\n"
                + "3) Introdueix un Employee\n"
                + "4) Modifica un Employee\n"
                + "5) Elimina un Employee\n"
                + "0) Sortir\n"
        );
    }
    public static void main(String[] args) throws SQLException {
        Connection con = Connexio.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAOImplementacio();
        MainEmployeeDAO main = new MainEmployeeDAO();

        main.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt(); sc.nextLine();
        while(opcio != 0){
            switch(opcio){
                case 1:{
                    employeeDAO.getEmployees().forEach(System.out::println);
                    break;
                }
                case 2:{
                    System.out.println("Introdueix quin Employee vols veure");
                    int idEmployee = sc.nextInt();sc.nextLine();
                    System.out.println(employeeDAO.read(idEmployee));
                    break;
                }
                case 3: {
                    System.out.println("Introdueix el LastName nou");
                    String lastName = sc.nextLine();
                    System.out.println("Introdueix el FirstName nou");
                    String firstName = sc.nextLine();
                    System.out.println("Introdueix el Title nou");
                    String title = sc.nextLine();
                    System.out.println("Introdueix el ReportsTo nou (0: Whether doesn't have )");
                    int reportsTo = sc.nextInt();sc.nextLine();
                    System.out.println("Introdueix el Birthday nou (yyyy-MM-dd HH:mm)");
                    LocalDateTime birthDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    System.out.println("Introdueix el HireDate nou (yyyy-MM-dd HH:mm)");
                    LocalDateTime hireDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
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

                    System.out.println("Create new Employee: " + employeeDAO.create(new Employee(0, lastName,
                            firstName,title,reportsTo,birthDate,hireDate,address,city,state,country,postalCode,phone,fax,email)));
                    break;
                }
                case 4: {
                    System.out.println("Introdueix quin Employee vols modificar");
                    int idEmployee = sc.nextInt();sc.nextLine();
                    System.out.println("Introdueix el LastName nou");
                    String lastName = sc.nextLine();
                    System.out.println("Introdueix el FirstName nou");
                    String firstName = sc.nextLine();
                    System.out.println("Introdueix el Title nou");
                    String title = sc.nextLine();
                    System.out.println("Introdueix el ReportsTo nou (0: Whether doesn't have)");
                    int reportsTo = sc.nextInt();sc.nextLine();
                    System.out.println("Introdueix el Birthday nou (yyyy-MM-dd HH:mm)");
                    LocalDateTime birthDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    System.out.println("Introdueix el HireDate nou (yyyy-MM-dd HH:mm)");
                    LocalDateTime hireDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
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
                    employeeDAO.update(new Employee(idEmployee,lastName,firstName,title,reportsTo,
                            birthDate,hireDate,address,city,state,country,postalCode,phone,fax,email));
                    break;
                }
                case 5: {
                    System.out.println("Introdueix quin Employee vols eliminar");
                    int idEmployee = sc.nextInt();sc.nextLine();
                    employeeDAO.delete(idEmployee);
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
