package ClassExamples.Database.dao;

import ClassExamples.Database.entity.Customer;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class CustomerDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    void insert(Customer customer) {
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    void update(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(customer);

        session.getTransaction().commit();
        session.close();
    }

    void delete(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.delete(customer);

        session.getTransaction().commit();
        session.close();
    }

     public List<Customer> findByCustomerName(String customerName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        Session session = factory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.customerName = :customerName";
        try {
            TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
            query.setParameter("customerName", customerName);
            //code goes to RunOrderDao  and assign result to variable
            List<Customer> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    List<Customer> findByContactFirstName(String firstName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to RunOrderDao query
        Session session = factory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.contactFirstname = :contactFirstName";

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("contactFirstName", firstName);
        List<Customer> result = query.getResultList();
        session.close();
        return result;

    }

    Customer findCustomerById() {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to RunOrderDao query
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer ID: ");
        Integer customerId = scanner.nextInt();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.id = :id";

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("id", customerId);
        try {
            Customer result = query.getSingleResult();

            return result;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public Customer findCustomerById(Integer id) {
        System.out.println("-------- MySQL JDBC Connection Demo -------------");
        System.out.println("|  ID   |   Customer Name   |    Contact Name   |");
        System.out.println("-------------------------------------------------");
        //code goes to RunOrderDao query

        Session session = factory.openSession();
        String hql = "SELECT c FROM Customer c WHERE c.id = :id";

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("id", id);
        try {
            Customer result = query.getSingleResult();
            System.out.println("|  " + result.getId() + "  |   " + result.getCustomerName()  + "   |  "+ result.getContactLastname() + ", " + result.getContactFirstname() + " |");
            return result;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }


    void updateContact() {
        Customer customer = findCustomerById();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter New Contact's First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter New Contact's Last Name: ");
        String lastName = scanner.next();
        customer.setContactFirstname(firstName);
        customer.setContactLastname(lastName);
        update(customer);
        System.out.println("Done! Contact updated to: " + customer.getContactFirstname() + " " + customer.getContactLastname());

    }
}

