package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

class ProductDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private String hql = "";

     void insert(Product product) {
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(product);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }


    Product findByID(Integer id) {
        Session session = factory.openSession();
        String hql = "SELECT p FROM Product p WHERE id = :id";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("id", id);
        try {
            Product product = query.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }

    }

    List<Product> findByName() {
        Session session = factory.openSession();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        String hql = "SELECT p FROM Product p WHERE p.productName =:productName";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", productName);
        List<Product> products = query.getResultList();
        session.close();
        System.out.println("Specified name list: " + products);
        return products;

    }

    List<Product> findByNameLikeness() {
        Session session = factory.openSession();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        String hql = "SELECT p FROM Product p WHERE lower(p.productName) LIKE lower(CONCAT('%',:productName,'%'))";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", productName);
        List<Product> products = query.getResultList();
        session.close();
        System.out.println("Likeness name list: " + products);
        return products;

    }

}
