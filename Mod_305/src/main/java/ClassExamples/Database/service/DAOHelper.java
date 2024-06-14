package ClassExamples.Database.service;

import ClassExamples.Database.dao.ProductDAO;
import ClassExamples.Database.entity.Order;
import ClassExamples.Database.entity.OrderDetail;

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
   public Integer gracefulGetOrderId() {
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
    public void printOrderDetails(Order order) {
        System.out.println("________________________________________________________________________");
        System.out.println("|    Order Id    |    Product ID    |    Amt Ordered    |     Price     |");
        System.out.println("________________________________________________________________________");
        for (OrderDetail od : order.getOrderDetails()){
            System.out.println("|    " + od.getOrderID() + "       |       " + od.getProductID() + "          |       " + od.getQuantityOrdered() + "       |       " + od.getPriceEach() +"      |");
        }
    }
    public String getComment() {
       scanner.nextLine();
        System.out.println("Enter Order Comment: ");
        String comment = scanner.nextLine();
        return comment;
    }
    public String getProductNameString() {
        while (true) {
            try {
                System.out.println("Enter name of product: ");
                String input = scanner.nextLine();
                scanner.close();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a string.");
                scanner.nextLine();
            }
        }
    }
}
