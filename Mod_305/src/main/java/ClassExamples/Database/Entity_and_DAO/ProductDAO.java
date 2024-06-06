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
    private Scanner scanner = new Scanner(System.in);

    void update(Product product) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(product);

        session.getTransaction().commit();
        session.close();
    }
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

void findProductById(){
    Product foundProduct = null;
    while (foundProduct == null) {
        foundProduct = findByID();
        if (foundProduct == null) { System.out.println("No relevant product found");}
    }
}
    Product findByID() {

        Session session = factory.openSession();
        Integer id = gatherIDFromUser();
        String hql = "select p from Product p where p.id = :id";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Product> query = session.createQuery(hql,Product.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("id", id);

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

    String gatherStringFromUser(){
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
    Integer gatherIntegerFromUser(){
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter amount: ");
                Integer input = scanner.nextInt();
                scanner.close();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    Integer gatherIDFromUser(){
        while (true) {
            try {
                System.out.println("Enter ID: ");
                Integer input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid ID.");
                scanner.nextLine();
            }
        }
    }
    List<Product> findByName() {
        Session session = factory.openSession();
        String selectedProductName = gatherStringFromUser();
        String hql = "SELECT p FROM Product p WHERE p.productName =:productName";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", selectedProductName);
        List<Product> products = query.getResultList();
        session.close();
        System.out.println("Specified name list: " + products);
        return products;

    }

    void listAll() {
        Session session = factory.openSession();
        String hql = "SELECT p FROM Product p";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.getResultList();
        session.close();
        for (Product product : products) {
            System.out.println(product.getId() + " .) " + product.getProductName() + "Amt in stock:" + product.getQuantityInStock());
        }
    }

    List<Product> findByNameLikeness() {
        Session session = factory.openSession();
        String selectedProductName = gatherStringFromUser();
        String hql = "SELECT p FROM Product p WHERE lower(p.productName) LIKE lower(CONCAT('%',:productName,'%'))";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", selectedProductName);
        List<Product> products = query.getResultList();
        session.close();
        System.out.println("Likeness name list: " + products);
        return products;

    }

    void updateStock() {
        listAll();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();
        Product selectedProduct = findByID();
        int amount = gatherIntegerFromUser();
        selectedProduct.setQuantityInStock(amount);
        update(selectedProduct);
        System.out.println("Done! Quantity updated to: " + selectedProduct.getQuantityInStock());
    }
}

