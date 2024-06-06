package ClassExamples.Database.Entity_and_DAO;


import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

class OrderDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Scanner scanner = new Scanner(System.in);
    void update(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(order);

        session.getTransaction().commit();
        session.close();
    }

    Order findOrderById(){
        Order foundOrder = null;
        while (foundOrder == null) {
            foundOrder = findByID();
            if (foundOrder == null) { System.out.println("No relevant order found");}
        }
        return foundOrder;
    }
    Order findByID() {

        Session session = factory.openSession();
        Integer orderId = getId();
        String hql = "select o from Order o where o.id = :orderId";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Order> query = session.createQuery(hql,Order.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("orderId", orderId);

        try {
            // getSingleResult will throw an exception if no records are found
            Order order = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return order;
        } catch( NoResultException e ) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }


    }

     Integer getId() {
        while (true) {
            try {
                System.out.println("Enter Order ID: ");
                Integer input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid Order ID (should be a string).");
                scanner.nextLine();
            }
        }
    }
}

