package ClassExamples.Database.Entity_and_DAO;

import java.util.List;
import java.util.Scanner;

class JDBCDemo_EmpDAO {
    public static void main(String[] args)  {
      EmployeeDAO  employeeDAO = new EmployeeDAO();
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
        System.out.println(employeesById == null ? "No Records" : employeesById.getLastname() + ", " + employeesById.getFirstname() + " | " + employeesById.getId());

    }
}

