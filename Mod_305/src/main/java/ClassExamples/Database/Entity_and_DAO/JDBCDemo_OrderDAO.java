package ClassExamples.Database.Entity_and_DAO;

import java.util.List;
import java.util.Scanner;

class run {
    OrderDAO orderDAO = new OrderDAO();
    private Scanner scanner = new Scanner(System.in);

    void startMenu() {
        System.out.println("Welcome to the Order Database");
        System.out.println("What would you like to do?");
        System.out.println("1 - Find Order By Id");
        System.out.println("2 - Find Order By Customer Id");
        System.out.println("3 - Update comment on Order");
        System.out.println("4 - Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Order pulledOrder = orderDAO.gracefulFindById();
                System.out.println(pulledOrder);
                break;
            case 2:
                List<Order> pulledOrderList = orderDAO.findByCustID();
                System.out.println(" _____________________________________________________________");
                System.out.println("|Customer ID | Order ID | Order Date | Order Status | Comment |");
                System.out.println("|_____________________________________________________________|");
                if (pulledOrderList.isEmpty()) {
                    System.out.println("                 No orders found");
                } else {
                    for (Order order : pulledOrderList) {
                        System.out.println("| " + order.getCustomerId() + "        | " + order.getId() + "    | " + order.getOrderDate() + " | " + order.getStatus() + "      | " + order.getComment() + "    |");
                        //System.out.println("|                           |");
                    }
                }
                System.out.println("___________________________________________________");
                break;
            case 3:
                orderDAO.commentOrder();
                break;
                case 4:
                    System.out.println("Thank you for using the Order Database!");
                    System.exit(0);
                break;
            default:
                startMenu();
        }
    }


    //orderDAO.commentOrder();
}

public class JDBCDemo_OrderDAO {
    public static void main(String[] args) {

        run run = new run();
        while (true) {
            run.startMenu();
        }


    }
}
