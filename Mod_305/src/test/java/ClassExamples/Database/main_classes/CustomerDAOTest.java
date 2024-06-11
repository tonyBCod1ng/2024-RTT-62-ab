package ClassExamples.Database.main_classes;

import ClassExamples.Database.dao.CustomerDAO;
import ClassExamples.Database.entity.Customer;
import org.junit.jupiter.api.*;

class CustomerDAOTest {
     CustomerDAO customerDAO = new CustomerDAO();


    @Test
    @DisplayName("Finds correct customer base on corresponding id number")
     void findByIdTest(){
        Integer userID = 103;

        Customer customer = customerDAO.findCustomerById(userID);
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(userID, customer.getId());
        Assertions.assertEquals("Atelier graphique", customer.getCustomerName());
        Assertions.assertEquals("Schmitt", customer.getContactLastname());
    }
}
