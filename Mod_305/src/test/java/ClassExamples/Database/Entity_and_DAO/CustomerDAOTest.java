package ClassExamples.Database.Entity_and_DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

class CustomerDAOTest {
    static CustomerDAO customerDAO = new CustomerDAO();


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
