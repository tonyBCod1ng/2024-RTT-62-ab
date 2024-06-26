package ClassExamples.Database.dao;

import ClassExamples.Database.entity.Customer;
import ClassExamples.Database.entity.Order;
import ClassExamples.Database.entity.OrderDetail;
import ClassExamples.Database.entity.Product;
import ClassExamples.Database.service.DAOHelper;
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
    private DAOHelper daoHelper = new DAOHelper();
    private Session session = factory.openSession();
     void insert(OrderDetail orderDetail) {
        // these 2 lines of code prepare the hibernate session for use

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
        session = factory.openSession();
         // begin the transaction
         session.getTransaction().begin();

         // insert the employee to the database
         session.save(orderDetail);

         /// commit our transaction
         session.getTransaction().commit();

         session.close();

         // cleanup the session
     }





    OrderDetail findByIdAndProductId(Integer orderId, Integer productId) {
        session = factory.openSession();
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


public void updateProductOrderDetail(Order order, Product product) {
        session = factory.openSession();
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
        update(foundOrderDetail);
        System.out.println("Done!");

    }

}

    void update(OrderDetail orderDetail) {
        session = factory.openSession();
         session.getTransaction().begin();

        // this is the only line that changed
        session.merge(orderDetail);

        session.getTransaction().commit();
        session.close();

    }


}
