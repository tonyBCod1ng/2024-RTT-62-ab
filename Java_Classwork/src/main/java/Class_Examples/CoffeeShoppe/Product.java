package Class_Examples.CoffeeShoppe;

public class Product {

    private String name;
    private double price;
    private boolean isBeverage;
    public Product(String name, double price, boolean isBeverage) {
        this.name = name;
        this.price = price;
        this.isBeverage = isBeverage;
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


