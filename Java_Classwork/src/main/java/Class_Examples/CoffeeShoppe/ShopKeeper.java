package Class_Examples.CoffeeShoppe;

import java.util.List;
import java.util.Scanner;



 public class ShopKeeper {
    public static Scanner sc = new Scanner(System.in);
    static OpenShoppe openShoppe = new OpenShoppe();

    public static void addItem() {
        System.out.println("Welcome to Coffee Inventory System!");
        System.out.println("What product do you want to add?");
        String addedProduct = sc.next();
        System.out.println("What is the price of this item?");
        double itemPrice = sc.nextDouble();
        System.out.println("Is this a beverage item? 1 = yes, 2 = no");
        boolean itemBeverage = sc.nextInt() == 1;

        Product newItem = new Product(addedProduct, itemPrice, itemBeverage);
        openShoppe.products.add(newItem);
        System.out.println("Added product " + addedProduct + " with price " + String.format("%.2f", newItem.getPrice()));
    }

    public static void printMenu(List<Product> menu) {
        for (Product product : menu) {
            System.out.println("..........Menu..........");
            System.out.println(product.getName() + "            $" + String.format("%.2f", product.getPrice()));
            System.out.println("........................");
        }
    }
}
