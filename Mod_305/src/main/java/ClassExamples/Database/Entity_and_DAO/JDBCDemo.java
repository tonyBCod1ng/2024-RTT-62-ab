package ClassExamples.Database.Entity_and_DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class JDBCDemo {
    public static void main(String[] args)  {
       ClassExamples.Database.Entity_and_DAO.EmployeeDAO employeeDAO = new ClassExamples.Database.Entity_and_DAO.EmployeeDAO();
       Scanner scanner = new Scanner(System.in);
        System.out.println("Type the first name of the employee:");
        String input = scanner.nextLine();
        System.out.println("Type the last name of the employee:");
        String inputLastName = scanner.nextLine() ;
        System.out.println("Type the id number of the employee:");
        Integer id = scanner.nextInt();
        List<Employee> employeesByFirst = employeeDAO.findByFirstName(input);
        List<Employee> employeesByLast = employeeDAO.findByLastName(inputLastName);
        Employee employeesById = employeeDAO.findById(id);
        System.out.println( employeesById.getLastname() + ", " + employeesById.getFirstname() + " | " + employeesById.getId());
    }
}

