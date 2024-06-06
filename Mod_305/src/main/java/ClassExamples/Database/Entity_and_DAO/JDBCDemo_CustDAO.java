package ClassExamples.Database.Entity_and_DAO;

import java.util.ArrayList;
import java.util.List;

class JDBCDemo_CustDAO {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
//         List<Customer> customerByName = customerDAO.findByCustomerName("Herkku Gifts") == null ? new ArrayList<>(0) : customerDAO.findByCustomerName("Herkku Gifts");
//         List<Customer> contact = customerDAO.findByContactFirstName("Roland");
//         System.out.println(contact);
//         for (Customer customer : contact) {
//             System.out.println(customer.getCustomerName());
//        Customer customer = new Customer();
//        customer.setId(888);
//        customer.setCustomerName("Dark Industries");
//        customer.setContactFirstname("Tony");
//        customer.setContactLastname("Dark");
//        customer.setPhone("213-416-7890");
//        customer.setCreditLimit(55550.00f);
//        customer.setAddressLine1("1273 Dolby Ave.");
//        customer.setCity("Racx");
//        customer.setState("Wynoming");
//        customer.setCountry("Brunited States");
//        customer.setPostalCode("12315");
//        customer.setSalesRepEmployeeId(1088);
//        customerDAO.insert(customer);
        customerDAO.findCustomerById();

    }
    // System.out.println(customerByName.isEmpty() ? "No records" : customerByName.getFirst().getCustomerName());

}

