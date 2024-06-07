package ClassExamples.Database.Entity_and_DAO;

public class JDBCDemo_OrderDetailDAO {
    // 1) Load an order from the database by id
    // 2) Load a product from the database by id
    // 3) Create a new OrderDetail object and add the order and the prodict
    // 4) Save the OrderDetail object to the database
    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    void run(){
        Order order = orderDAO.findOrderById();
        System.out.println(order);
        Product product = productDAO.findProductById();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        orderDetail.setOrderLineNumber(3);
        orderDetail.setQuantityOrdered(500);
        orderDetail.setPriceEach(product.getMsrp());
        orderDetailDAO.insert(orderDetail);
        System.out.println("Done! Added " + orderDetail + " to the table.");
    }
    public static void main(String[] args) {
        JDBCDemo_OrderDetailDAO dao = new JDBCDemo_OrderDetailDAO();
        dao.run();
    }
}
