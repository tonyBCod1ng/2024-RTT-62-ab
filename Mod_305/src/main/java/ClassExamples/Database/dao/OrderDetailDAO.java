package ClassExamples.Database.dao;

import ClassExamples.Database.entity.Customer;
import ClassExamples.Database.entity.Order;
import ClassExamples.Database.entity.OrderDetail;
import ClassExamples.Database.entity.Product;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;


 public class OrderDetailDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Scanner scanner = new Scanner(System.in);
    private ProductDAO productDAO = new ProductDAO();
    private OrderDAO orderDAO = new OrderDAO();
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
     void insert(OrderDetail orderDetail, Order order) {
         // these 2 lines of code prepare the hibernate session for use
         Session session = factory.openSession();

         // begin the transaction
         session.getTransaction().begin();

         // insert the employee to the database
         session.save(orderDetail);

         /// commit our transaction
         session.getTransaction().commit();

         session.close();
         System.out.println("________________________________________________________________________");
         System.out.println("|    Order Id    |    Product ID    |    Amt Ordered    |     Price     |");
         System.out.println("________________________________________________________________________");
         List<OrderDetail> burnOrder = orderDetail.getOrder().getOrderDetails();
         orderDetail.setOrderID(orderDetail.getOrder().getId());
         orderDetail.setProductID(orderDetail.getProduct().getId());
         orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered());
         orderDetail.setPriceEach(orderDetail.getPriceEach());
         orderDetail.setProduct(orderDetail.getProduct());
         burnOrder.add(orderDetail);
         for (OrderDetail od : orderDetail.getOrder().getOrderDetails()){
             System.out.println("|    " + od.getOrderID() + "       |       " + od.getProductID() + "          |       " + od.getQuantityOrdered() + "       |       " + od.getPriceEach());
         }
         // cleanup the session
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
        Integer orderDetailId = getOrderIdFromUsr();
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
public void updateProductOrderDetail(Order order, Product product) {
    Customer customer = order.getCustomer();
    OrderDetail foundOrderDetail = findByIdAndProductId(order.getId(), product.getId());
    if(foundOrderDetail == null){
        foundOrderDetail = new OrderDetail();
        foundOrderDetail.setOrder(order);
        foundOrderDetail.setProduct(product);
        foundOrderDetail.setOrderLineNumber(order.getOrderDetails().toArray().length + 1);
        foundOrderDetail.setQuantityOrdered(1);
        foundOrderDetail.setPriceEach(product.getMsrp());
        insert(foundOrderDetail, order);
    } else {
        foundOrderDetail.setQuantityOrdered(foundOrderDetail.getQuantityOrdered() + 1);
        System.out.println(foundOrderDetail);
        update(foundOrderDetail, order);
        System.out.println("Done!");

    }

}
    Integer getOrderIdFromUsr() {
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
     void update(OrderDetail orderDetail, Order order) {
         Session session = factory.openSession();
         session.getTransaction().begin();

         // this is the only line that changed
         session.merge(orderDetail);
         session.getTransaction().commit();
         System.out.println("________________________________________________________________________");
         System.out.println("|    Order Id    |    Product ID    |    Amt Ordered    |     Price     |");
         System.out.println("________________________________________________________________________");
         for (OrderDetail od : order.getOrderDetails()){
             System.out.println("|    " + od.getOrderID() + "       |       " + od.getProductID() + "          |       " + od.getQuantityOrdered() + "       |       " + od.getPriceEach());
         }
         session.close();

     }

}
