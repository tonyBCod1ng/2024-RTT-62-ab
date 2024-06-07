package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class OrderDetailDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Scanner scanner = new Scanner(System.in);

    void insert(OrderDetail orderDetail) {
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(orderDetail);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    OrderDetail gracefulFindById() {
        OrderDetail foundOrder = null;
        while (foundOrder == null) {
            foundOrder = findByID();
            if (foundOrder == null) {
                System.out.println("No relevant order found");
            }
        }
        return foundOrder;
    }

    Integer getCustId() {
        while (true) {
            try {
                System.out.println("Enter Customer ID: ");
                Integer input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid Order ID (should be a string).");
                scanner.nextLine();
            }
        }
    }

    OrderDetail findByIdAndProductId(Integer orderId, Integer productId) {

        Session session = factory.openSession();
        String hql = "select od from OrderDetail od where od.product.id = :productId and od.order.id = :orderId";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);
        try {
            // getSingleResult will throw an exception if no records are found
            OrderDetail orderDetail = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return orderDetail;
        } catch (NoResultException e) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }


    }

    OrderDetail findByID() {

        Session session = factory.openSession();
        Integer orderDetailId = getOrderId();
        String hql = "select od from OrderDetail od where od.id = :orderDetailId";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("orderDetailId", orderDetailId);

        try {
            // getSingleResult will throw an exception if no records are found
            OrderDetail orderDetail = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return orderDetail;
        } catch (NoResultException e) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }


    }

    Integer getOrderId() {
        while (true) {
            try {
                System.out.println("Enter Order ID: ");
                Integer input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid Order ID (should be a number).");
                scanner.nextLine();
            }
        }
    }
    void update(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(orderDetail);

        session.getTransaction().commit();
        session.close();
    }

}
