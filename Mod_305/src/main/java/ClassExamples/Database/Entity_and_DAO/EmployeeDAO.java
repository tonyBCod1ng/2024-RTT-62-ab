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
    public List<Employee> findByFirstName(String firstName) throws SQLException {
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
    public List<Employee> findByLastName(String lastName) throws SQLException {
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
}
