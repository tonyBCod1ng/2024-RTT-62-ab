package ClassExamples.Database.Entity_and_DAO;

import java.util.List;

public class JDBCDemo_OrderDetailDAO {
    // 1) Load an order from the database by id
    // 2) Load a product from the database by id
    // 3) Create a new OrderDetail object and add the order and the prodict
    // 4) Save the OrderDetail object to the database
    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    void run(){
        Order order = orderDAO.gracefulFindById();
        //List<OrderDetail> orderDetails = order.getOrderDetails();
        //System.out.println(order);
        Product product = productDAO.gracefulFindById();
        Customer customer = order.getCustomer();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        orderDetail.setOrderLineNumber(3);
        orderDetail.setQuantityOrdered(500);
        orderDetail.setPriceEach(product.getMsrp());
        //orderDetailDAO.insert(orderDetail);
        OrderDetail orderDetail1 = orderDetailDAO.findByIdAndProductId(order.getId(), product.getId());
        if(orderDetail1 == null){
            orderDetail1 = new OrderDetail();
            orderDetail1.setOrder(order);
            orderDetail1.setProduct(product);
            orderDetail1.setOrderLineNumber(order.getOrderDetails().toArray().length + 1);
            orderDetail1.setQuantityOrdered(1);
            orderDetail1.setPriceEach(product.getMsrp());
            orderDetailDAO.insert(orderDetail1);
        } else {
            orderDetail1.setQuantityOrdered(orderDetail1.getQuantityOrdered() + 1);
            System.out.println(orderDetail1);
            orderDetailDAO.update(orderDetail1);
        }
        System.out.println("Done! Added " + orderDetail1 + " to the table.");
        System.out.println("________________________________________________________________________");
        System.out.println("|    Order Id    |    Product ID    |    Amt Ordered    |     Price     |");
        System.out.println("________________________________________________________________________");
        for (OrderDetail od : order.getOrderDetails()){
            System.out.println("|    " + od.getOrderID() + "       |       " + od.getProductID() + "          |       " + od.getQuantityOrdered() + "       |       " + od.getPriceEach());
        }
    }
    public static void main(String[] args) {
        JDBCDemo_OrderDetailDAO dao = new JDBCDemo_OrderDetailDAO();
        dao.run();
    }
}
