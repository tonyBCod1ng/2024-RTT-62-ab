package ClassExamples.Database;

import ClassExamples.Database.dao.OrderDAO;
import ClassExamples.Database.dao.ProductDAO;
import ClassExamples.Database.entity.Order;
import ClassExamples.Database.entity.Product;

import java.util.Scanner;

public class DAOHelper {
    private Scanner scanner = new Scanner(System.in);
   public Integer gatherProductIDFromUser(){
        while (true) {
            try {
                System.out.println("Enter product ID: ");
                Integer input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid ID.");
                scanner.nextLine();
            }
        }
    }
    public Integer gatherOrderIDFromUser(){
        while (true) {
            try {
                System.out.println("Enter order ID: ");
                Integer input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid ID.");
                scanner.nextLine();
            }
        }
    }
   public Integer gatherIntegerFromUser(){
        while (true) {
            try {
                System.out.println("Enter amount: ");
                Integer input = scanner.nextInt();
                scanner.close();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    /*public Product gracefulFindProductById(){
        Product foundProduct = null;
        while (foundProduct == null) {
            int productId = gatherProductIDFromUser();
            foundProduct = productDAO.findByID(productId);
            if (foundProduct == null) { System.out.println("No relevant product found");}
        }
        return foundProduct;
    }*/
    /*public Order gracefulFindOrderById(){
        Order foundOrder = null;
        while (foundOrder == null) {
            int orderId = gracefulGetOrderId();
            foundOrder = orderDAO.findOrderByID(orderId);
            if (foundOrder == null) { System.out.println("No relevant product found");}
        }
        return foundOrder;
    }*/
    Integer gracefulGetOrderId() {
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
   public Integer getCustId() {
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
    public String getComment() {
        System.out.println("Enter Order Comment: ");
        String comment = scanner.nextLine();
        return comment;
    }
}
