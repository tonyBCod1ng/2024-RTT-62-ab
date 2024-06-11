package ClassExamples.Database.dao;

import java.util.List;

import ClassExamples.Database.entity.Employee;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void delete(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }
     public void insert(Employee employee) {
        // these 2 lines of code prepare the hibernate session for use
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

    public List<Employee> findByFirstName(String firstName) {
        System.out.println("_____________________________________________________________");
        System.out.println("|    Employee Id    |    Office Id    |    Employee Name    |");
        System.out.println("_____________________________________________________________");
        //code goes to RunOrderDao query
        Session session = factory.openSession();
        String hql = "SELECT e FROM Employee e WHERE e.firstname = :firstName";
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("firstName", firstName);
        List<Employee> result = query.getResultList();
        for (Employee e : result){
            System.out.println("|    " + e.getId() + "       |       " + e.getOfficeId() + "          |       " + e.getLastname() + ", " +e.getFirstname() + "       |" );
        }
        session.close();
        return result;
    }

     public List<Employee> findByLastName(String lastName) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        //code goes to RunOrderDao query
        Session session = factory.openSession();
        String hql = "SELECT e FROM Employee e WHERE e.lastname = :lastName";
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("lastName", lastName);
        List<Employee> result = query.getResultList();
        session.close();
        return result;
    }

     public Employee findById(Integer id) {
         System.out.println("_____________________________________________________________");
         System.out.println("|    Employee Id    |    Office Id    |    Employee Name    |");
         System.out.println("_____________________________________________________________");        //code goes to RunOrderDao query
        Session session = factory.openSession();
        String hql = "SELECT e FROM Employee e WHERE e.id = :id";
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("id", id);
        try {
            Employee result = query.getSingleResult() == null ? new Employee() : query.getSingleResult();
            System.out.println("|    " + result.getId() + "       |       " + result.getOfficeId() + "          |       " + result.getLastname() + ", " + result.getFirstname() + "       |" );

            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
}
