package ClassExamples.Database.Entity_and_DAO;

public class JDBCDemo_OrderDAO {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
       Order pulledOrder = orderDAO.findOrderById();
       System.out.println(pulledOrder);
    }
}
