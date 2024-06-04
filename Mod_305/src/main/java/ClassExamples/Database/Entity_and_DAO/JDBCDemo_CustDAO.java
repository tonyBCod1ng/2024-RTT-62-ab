package ClassExamples.Database.Entity_and_DAO;

import java.util.ArrayList;
import java.util.List;
class JDBCDemo_CustDAO {
     public static void main(String[] args) {
         CustomerDAO customerDAO = new CustomerDAO();
         List<Customer> customerByName = customerDAO.findByCustomerName("Herkku Gifts") == null ? new ArrayList<>(0) : customerDAO.findByCustomerName("Herkku Gifts");
         List<Customer> contact = customerDAO.findByContactFirstName("Roland");
         for (Customer customer : contact) {
             System.out.println(customer.getCustomerName());
         }
        // System.out.println(customerByName.isEmpty() ? "No records" : customerByName.getFirst().getCustomerName());

     }
}
