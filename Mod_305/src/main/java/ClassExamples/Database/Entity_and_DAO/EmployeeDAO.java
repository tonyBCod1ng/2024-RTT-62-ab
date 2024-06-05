package ClassExamples.Database.Entity_and_DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ClassExamples.Database.Entity_and_DAO.Employee;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class EmployeeDAO {
    public void insert(Employee employee) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(employee);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    List<Employee> findByFirstName(String firstName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to run query
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT e FROM Employee e WHERE e.firstname = :firstName";
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("firstName", firstName);
        List<Employee> result = query.getResultList();
        session.close();
        return result;
    }

     List<Employee> findByLastName(String lastName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to run query
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT e FROM Employee e WHERE e.lastname = :lastName";
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("lastName", lastName);
        List<Employee> result = query.getResultList();
        session.close();
        return result;
    }

     Employee findById(Integer id) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to run query
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT e FROM Employee e WHERE e.id = :id";
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("id", id);
        try {
            Employee result = query.getSingleResult() == null ? new Employee() : query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
}
