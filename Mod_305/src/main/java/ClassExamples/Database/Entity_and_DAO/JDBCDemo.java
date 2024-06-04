package ClassExamples.Database.Entity_and_DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class JDBCDemo {
    public static void main(String[] args)  {
      EmployeeDAO  employeeDAO = new EmployeeDAO();
      CustomerDAO customerDAO = new CustomerDAO();
       Scanner scanner = new Scanner(System.in);
        System.out.println("Type the first name of the employee:");
        String input = scanner.nextLine();
        System.out.println("Type the last name of the employee:");
        String inputLastName = scanner.nextLine() ;
        System.out.println("Type the id number of the employee:");
        Integer id = scanner.nextInt();
//        List<Employee> employeesByFirst = employeeDAO.findByFirstName(input);
//        List<Employee> employeesByLast = employeeDAO.findByLastName(inputLastName);
//        Employee employeesById = employeeDAO.findById(id);
       // List<Customer> customerByName = customerDAO.findByCustomerName("Herkku Gifts") == null ? new ArrayList<>(0) : customerDAO.findByCustomerName("Herkku Gifts");
        Customer contact = customerDAO.findByContactFirstName("Mike");
       // System.out.println( employeesById.getLastname() + ", " + employeesById.getFirstname() + " | " + employeesById.getId());
        //System.out.println(customerByName.isEmpty() ? "No records" : customerByName.getFirst().getCustomerName());
        System.out.println(contact);
    }
}

