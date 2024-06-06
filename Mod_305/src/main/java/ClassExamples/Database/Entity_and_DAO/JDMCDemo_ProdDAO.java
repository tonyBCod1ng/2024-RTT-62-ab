package ClassExamples.Database.Entity_and_DAO;

import java.util.Scanner;

class JDMCDemo_ProdDAO {
   private static ProductDAO productDAO = new ProductDAO();
    public static void main(String[] args) {
        /*Product product = new Product();
        product.setId(150);
        product.setProductName("JDMC Demo");
        product.setProductDescription("JDMC Demo Description");
        product.setProductCode("haallllaa");
        product.setProductlineId(1);
        product.setMsrp(2.454747748f);
        product.setProductVendor("whodatnation");
        product.setProductScale("1:4");
        product.setBuyPrice(500.00000000f);
        product.setQuantityInStock(500);
        productDAO.insert(product);*/
        //productDAO.findByName();
        productDAO.findByNameLikeness();
        //productDAO.updateStock();
        //productDAO.findProductById();
    }
}
