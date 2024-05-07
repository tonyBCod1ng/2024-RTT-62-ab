package Class_Examples.CoffeeShoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShopKeeper {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>(0);

    public void addItem() {

        System.out.println("Welcome to Coffee Inventory System!");
        System.out.println("What product do you want to add?");
        String addedProduct = scanner.next();
        System.out.println("What is the price of this item?");
        double itemPrice = scanner.nextDouble();
        System.out.println("Is this a beverage item? 1 = yes, 2 = no");
        boolean itemBeverage = scanner.nextInt() == 1;

        Product newItem = new Product(addedProduct, itemPrice, itemBeverage);
        products.add(newItem);
        System.out.println("Added product " + addedProduct + " with price " + String.format("$%.2f", newItem.getPrice()));
    }

    public void printMenu() {
        System.out.println("..........Menu..........");
        for (Product product : products) {

            System.out.println(product.getName() + "            $" + String.format("%.2f", product.getPrice()));

        }
        System.out.println("........................");
    }
}
