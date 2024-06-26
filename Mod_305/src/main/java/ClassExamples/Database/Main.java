package ClassExamples.Database;

import ClassExamples.Database.entity.Product;
import ClassExamples.Database.service.DAOHelper;
import ClassExamples.Database.dao.OrderDAO;
import ClassExamples.Database.dao.OrderDetailDAO;
import ClassExamples.Database.dao.ProductDAO;
import ClassExamples.Database.entity.Order;

import java.util.List;
import java.util.Scanner;

 class Run {
    private OrderDAO orderDAO = new OrderDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
   private ProductDAO productDAO = new ProductDAO();
    private DAOHelper daoHelper = new DAOHelper();
    private Scanner scanner = new Scanner(System.in);

    void startMenu() {
        System.out.println("Welcome to the Order Database");
        System.out.println("What would you like to do?");
        System.out.println("1 - Find Order By Id");
        System.out.println("2 - Find Order By Customer Id");
        System.out.println("3 - Insert a Product into an Order");
        System.out.println("4 - Update comment on Order");
        System.out.println("5 - Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                int orderId = daoHelper.gracefulGetOrderId();
                Order pulledOrder = orderDAO.findOrderByID(orderId);
                System.out.println(" _____________________________________________________________");
                System.out.println("|Customer ID | Order ID | Order Date | Order Status | Comment |");
                System.out.println("|_____________________________________________________________|");
                System.out.println("|   " + pulledOrder.getCustomerId() + "      | " + pulledOrder.getId() + "    | " + pulledOrder.getOrderDate() + " | " + pulledOrder.getStatus() + "      | " + pulledOrder.getComment() + " |");
                break;
            case 2:
                List<Order> pulledOrderList = orderDAO.findOrderByCustID(daoHelper.getCustId());
                System.out.println(" _____________________________________________________________");
                System.out.println("|Customer ID | Order ID | Order Date | Order Status | Comment |");
                System.out.println("|_____________________________________________________________|");
                if (pulledOrderList.isEmpty()) {
                    System.out.println("                       No orders found");
                } else {
                    for (Order order : pulledOrderList) {
                        System.out.println("| " + order.getCustomerId() + "        | " + order.getId() + "    | " + order.getOrderDate() + " | " + order.getStatus() + "      | " + order.getComment() + "    |");
                        //System.out.println("|                           |");
                    }
                }
                System.out.println("|_____________________________________________________________|");
                break;
            case 3:
                Order order = orderDAO.findOrderByID(daoHelper.gracefulGetOrderId());
                Product product = productDAO.findByID(daoHelper.gatherProductIDFromUser());
                orderDetailDAO.updateProductOrderDetail(order, product);
                daoHelper.printOrderDetails(order);
                break;
            case 4:
                orderDAO.commentOrder();
                break;
            case 5:
                System.out.println("Thank you for using the Order Database!");
                System.exit(0);
                break;
            default:
                startMenu();
        }
    }


    //orderDAO.commentOrder();
}

 class Main {
    public static void main(String[] args) {

        Run run = new Run();
        while (true) {
            run.startMenu();
        }


    }
}
