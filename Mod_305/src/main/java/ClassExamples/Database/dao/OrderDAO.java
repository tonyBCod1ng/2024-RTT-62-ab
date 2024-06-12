package ClassExamples.Database.dao;


import ClassExamples.Database.DAOHelper;
import ClassExamples.Database.entity.Order;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;


public class OrderDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Scanner scanner = new Scanner(System.in);
    private Session session = factory.openSession();
    private DAOHelper daoHelper = new DAOHelper();
    void update(Order order) {

        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(order);

        session.getTransaction().commit();
        session.close();
    }





    public Order findOrderByID(int orderId) {

        String hql = "select o from Order o where o.id = :orderId";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("orderId", orderId);

        try {
            // getSingleResult will throw an exception if no records are found
            Order order = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return order;
        } catch (NoResultException e) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }


    }

    public List<Order> findOrderByCustID(int customerId) {

        String hql = "select o from Order o where o.customerId = :customerId";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("customerId", customerId);

        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }



    public void commentOrder() {
        Order order = null;
        while (order == null) {
           session = factory.openSession();
            order = findOrderByID(daoHelper.gatherOrderIDFromUser());
            if (order == null) {
                System.out.println("Order not found");
            }
        }
        String comment = daoHelper.getComment();
        order.setComment(comment);
        update(order);
    System.out.println("Comment updated!");
    }
}

