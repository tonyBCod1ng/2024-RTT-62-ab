package ClassExamples.Database;

import ClassExamples.Database.dao.ProductDAO;
import ClassExamples.Database.entity.Product;

class JDMCDemo_ProdDAO {
    DAOHelper daoHelper = new DAOHelper();
    ProductDAO productDAO = new ProductDAO();
    public Product gracefulFindById() {
        Product foundProduct = null;
        while (foundProduct == null) {
            int productId = daoHelper.gatherProductIDFromUser();
            foundProduct = productDAO.findByID(productId);
            if (foundProduct == null) {
                System.out.println("No relevant product found");
            }
        }
        return foundProduct;
    }

}