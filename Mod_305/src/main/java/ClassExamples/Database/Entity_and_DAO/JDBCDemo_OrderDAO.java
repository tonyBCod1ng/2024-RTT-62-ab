package ClassExamples.Database.Entity_and_DAO;

import java.util.List;

public class JDBCDemo_OrderDAO {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
      /* Order pulledOrder = orderDAO.findOrderById();
       System.out.println(pulledOrder);*/
        List<Order> pulledOrderList = orderDAO.findByCustID();
        System.out.println(" _____________________________________________________________");
        System.out.println("|Customer ID | Order ID | Order Date | Order Status | Comment |");
        System.out.println("|_____________________________________________________________|");
        if (pulledOrderList.isEmpty()) {
            System.out.println("                 No orders found");
        } else {
            for (Order order : pulledOrderList) {
                System.out.println("| " + order.getCustomerId() + "        | "+ order.getId() +"    | " + order.getOrderDate() + " | " + order.getStatus() + "      |" + order.getComment() + "     |");
                //System.out.println("|                           |");
            }
        }
        System.out.println("___________________________________________________");

        //orderDAO.commentOrder();

    }
}
