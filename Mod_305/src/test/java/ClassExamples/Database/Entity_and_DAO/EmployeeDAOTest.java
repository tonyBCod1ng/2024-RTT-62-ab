package ClassExamples.Database.Entity_and_DAO;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


public class EmployeeDAOTest {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    @BeforeAll
    static void setUp() {
        employeeDAO = new EmployeeDAO();
        List<Employee> needToDelete = employeeDAO.findByFirstName("Tester");
        if (needToDelete.size() > 0) {
            for (Employee employee : needToDelete) {
                employeeDAO.delete(employee);
            }
        }

    }

    @AfterAll
    static void tearDown() {
        List<Employee> needToDelete = employeeDAO.findByFirstName("Tester");
        if (needToDelete.size() > 0) {
            for (Employee employee : needToDelete) {
                employeeDAO.delete(employee);
            }
        }

    }

    @Test
    @DisplayName("Returns correct employee based on corresponding ID number")
    void findEmpByIDTest() {
        Employee givenEmployee = employeeDAO.findById(35);
        Assertions.assertEquals(35, givenEmployee.getId());
        Assertions.assertEquals("mil", givenEmployee.getFirstname());
        Assertions.assertEquals("fik", givenEmployee.getLastname());
    }

    @Test
    @DisplayName("Returns a null value when no records are found")
    void findEmpByIDNullTest() {
        Employee givenEmployee = employeeDAO.findById(1);
        Assertions.assertNull(givenEmployee);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Leslie",
                    "Tom",
                    "Harry",
                    "mil"
            }
    )
    @DisplayName("Correctly Finds Employee by First name and returns all results")
    void findEmpByNameTest(String input) {
        List<Employee> givenEmployeeFirstName = employeeDAO.findByFirstName(input);
        if (givenEmployeeFirstName.size() > 0) {
            for (Employee employee : givenEmployeeFirstName) {
                Assertions.assertEquals(input, employee.getFirstname());
            }
        }
    }

    @Test
    @DisplayName("Returns an empty list when there are no matches")
    void findEmpByNameEmptyTest() {
        List<Employee> givenEmployeeFirstName = employeeDAO.findByFirstName("Timbaland");
        Assertions.assertEquals(0, givenEmployeeFirstName.size());
    }

    @Test
    @DisplayName("Successfully create and insert new employee into database")
    void insertEmpTest() {
        Employee givenEmployee = new Employee();
        givenEmployee.setFirstname("Tester");
        givenEmployee.setLastname("Lane");
        givenEmployee.setEmail("lana.lane@gmail.com");
        givenEmployee.setExtension("x4320");
        givenEmployee.setOfficeId(3);
        givenEmployee.setReportsTo(1088);
        givenEmployee.setJobTitle("Software Engineer");
        employeeDAO.insert(givenEmployee);
    }
}


