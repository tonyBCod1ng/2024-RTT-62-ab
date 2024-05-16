package Class_Examples.CoffeeShoppe;

public class Product {

    private String name;
    private double price;
    private boolean isBeverage;
    private int quantityAvailable;

    public Product() {

    }

    public Product(String name, double price, boolean isBeverage, int quantityAvailable) {
        this.name = name;
        this.price = price;
        this.isBeverage = isBeverage;
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBeverage() {
        return isBeverage;
    }

    public void setBeverage(boolean beverage) {
        isBeverage = beverage;
    }


}


