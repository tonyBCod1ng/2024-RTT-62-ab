package ClassExamples.Database;

import ClassExamples.Database.dao.OrderDAO;
import ClassExamples.Database.dao.OrderDetailDAO;
import ClassExamples.Database.dao.ProductDAO;
import ClassExamples.Database.entity.Order;

import java.util.List;
import java.util.Scanner;

 class RunOrderDao {
    OrderDAO orderDAO = new OrderDAO();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    ProductDAO productDAO = new ProductDAO();
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
                Order pulledOrder = orderDAO.gracefulFindById();
                System.out.println(" _____________________________________________________________");
                System.out.println("|Customer ID | Order ID | Order Date | Order Status | Comment |");
                System.out.println("|_____________________________________________________________|");
                System.out.println("|   " + pulledOrder.getCustomerId() + "      | " + pulledOrder.getId() + "    | " + pulledOrder.getOrderDate() + " | " + pulledOrder.getStatus() + "      | " + pulledOrder.getComment() + " |");
                break;
            case 2:
                List<Order> pulledOrderList = orderDAO.findByCustID();
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
                orderDetailDAO.updateProductOrderDetail(orderDAO.gracefulFindById(), productDAO.gracefulFindById());
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

 class JDBCDemo_OrderDAO {
    public static void main(String[] args) {

        RunOrderDao run = new RunOrderDao();
        while (true) {
            run.startMenu();
        }


    }
}
