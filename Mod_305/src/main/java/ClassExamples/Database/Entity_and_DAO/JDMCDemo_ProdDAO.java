package ClassExamples.Database.Entity_and_DAO;

 class JDMCDemo_ProdDAO {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        productDAO.findByName("1969 Harley Davidson Ultimate Chopper");
        productDAO.findByNameLikeness("1969 Harley Davidson");
    }
}
