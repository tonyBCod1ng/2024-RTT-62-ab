package ClassExamples.Database;

import ClassExamples.Database.dao.OrderDAO;
import ClassExamples.Database.dao.OrderDetailDAO;
import ClassExamples.Database.dao.ProductDAO;
import ClassExamples.Database.entity.Order;
import ClassExamples.Database.entity.Product;

class Run {
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    OrderDAO orderDAO = new OrderDAO();
    ProductDAO productDAO = new ProductDAO();
    void start(){
        Order order = orderDAO.gracefulFindById();
        Product product = productDAO.gracefulFindById();
        orderDetailDAO.updateProductOrderDetail(order, product);
    }
}

  class JDBCDemo_OrderDetailDAO {
    // 1) Load an order from the database by id
    // 2) Load a product from the database by id
    // 3) Create a new OrderDetail object and add the order and the product
    // 4) Save the OrderDetail object to the database


    public static void main(String[] args) {
        Run run = new Run();
        run.start();
    }
}
