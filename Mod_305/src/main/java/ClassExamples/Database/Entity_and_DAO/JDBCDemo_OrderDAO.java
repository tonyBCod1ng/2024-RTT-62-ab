package ClassExamples.Database.Entity_and_DAO;

import java.util.List;

public class JDBCDemo_OrderDAO {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
      /* Order pulledOrder = orderDAO.findOrderById();
       System.out.println(pulledOrder);*/
       /* List<Order> pulledOrderList = orderDAO.findByCustID();
        System.out.println(" __________________________________________________");
        System.out.println("|Customer ID | Order Date | Order Status | Comment |");
        System.out.println("|__________________________________________________|");
        for (Order order : pulledOrderList) {
            System.out.println("| " + order.getCustomerId() + "        | " + order.getOrderDate() + " | " + order.getStatus() + "      |" + order.getComment() + "     |");
            //System.out.println("|                           |");
        }
        System.out.println("___________________________________________________");*/

        orderDAO.commentOrder();

    }
}
