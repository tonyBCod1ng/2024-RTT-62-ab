package ClassExamples.Database.Entity_and_DAO;

import java.util.ArrayList;
import java.util.List;

class JDBCDemo_CustDAO {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
//         List<Customer> customerByName = customerDAO.findByCustomerName("Herkku Gifts") == null ? new ArrayList<>(0) : customerDAO.findByCustomerName("Herkku Gifts");
//         List<Customer> contact = customerDAO.findByContactFirstName("Roland");
//         for (Customer customer : contact) {
//             System.out.println(customer.getCustomerName());
        Customer customer = new Customer();
        customer.setId(8888);
        customer.setCustomerName("John Doe Industries");
        customer.setContactFirstname("John");
        customer.setContactLastname("Doe");
        customer.setPhone("123-456-7890");
        customer.setCreditLimit(5555.00f);
        customer.setAddressLine1("123 Side Ave.");
        customer.setCity("Krapopolis");
        customer.setState("Realanoy");
        customer.setCountry("Brunited States");
        customer.setPostalCode("12345");
        customer.setSalesRepEmployeeId(1088);
       // customerDAO.insert(customer);
        customerDAO.findCustomerById();

    }
    // System.out.println(customerByName.isEmpty() ? "No records" : customerByName.getFirst().getCustomerName());

}

