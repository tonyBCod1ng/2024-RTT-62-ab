package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {
    public List<Customer> findByCustomerName(String customerName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to run query
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.customerName = :customerName";
        try {
            TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
            query.setParameter("customerName", customerName);
            List<Customer> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    ;

    List<Customer> findByContactFirstName(String firstName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to run query
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.contactFirstname = :contactFirstName and c.salesRepEmployeeId IS NOT null";

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("contactFirstName", firstName);
        List<Customer> result = query.getResultList();
        session.close();
        return result;

    }
}
