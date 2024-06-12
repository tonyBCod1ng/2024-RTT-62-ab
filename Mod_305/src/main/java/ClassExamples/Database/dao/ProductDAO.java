package ClassExamples.Database.dao;

import ClassExamples.Database.DAOHelper;
import ClassExamples.Database.entity.Product;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class ProductDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private String hql = "";
    private Scanner scanner = new Scanner(System.in);
    private Session session = factory.openSession();
    private DAOHelper daoHelper = new DAOHelper();
    void update(Product product) {
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(product);

        session.getTransaction().commit();
        session.close();
    }
    void insert(Product product) {

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(product);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }


    public Product findByID(int productId) {

        String hql = "select p from Product p where p.id = :productId";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Product> query = session.createQuery(hql,Product.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("productId", productId);

        try {
            // getSingleResult will throw an exception if no records are found
            Product product = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return product;
        } catch( NoResultException e ) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }


    }


    String getString() {
        while (true) {
            try {
                System.out.println("Enter name: ");
                String input = scanner.nextLine();
                scanner.close();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a string.");
                scanner.nextLine();
            }
        }
    }


    List<Product> findByName() {
        String selectedProductName = getString();
        String hql = "SELECT p FROM Product p WHERE p.productName =:productName";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", selectedProductName);
        List<Product> products = query.getResultList();
        session.close();
        System.out.println("Specified name list: " + products);
        return products;

    }

    void listAll() {
        String hql = "SELECT p FROM Product p";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.getResultList();
        session.close();

    }

    public List<Product> findByNameLikeness(String selectedProductName) {
        String hql = "SELECT p FROM Product p WHERE lower(p.productName) LIKE lower(CONCAT('%',:productName,'%'))";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", selectedProductName);
        List<Product> products = query.getResultList();
        session.close();
        System.out.println("Likeness name list: ");
        if (products.size() > 0) {
            for (Product product : products) {
                System.out.println(product.getId() + ".) " + product.getProductName() + " | Amt in stock: " + product.getQuantityInStock());
            }
        } else {
            System.out.println("No relevant product found");
        }
        return products;
    }

    void updateStock() {
        listAll();
        int id = daoHelper.gatherProductIDFromUser();
        Product selectedProduct = findByID(id);
        int amount = daoHelper.gatherIntegerFromUser();
        selectedProduct.setQuantityInStock(amount);
        update(selectedProduct);
        System.out.println("Done! Quantity updated to: " + selectedProduct.getQuantityInStock());
    }
}

