package Class_Examples.CoffeeShoppe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoffeeShoppe {
  static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       coffeeShoppe();
    }
    public static void coffeeShoppe() {
        System.out.println("Welcome to Coffee Shopping System!");
        System.out.println("What product do you want to add?");
        String addedProduct = sc.nextLine();
        System.out.println("What is the price of this item?");
        double itemPrice = sc.nextDouble();
        System.out.println("Is this a beverage item? 1 = yes, 2 = no");
        boolean itemBeverage = sc.nextInt() == 1;
        sc.close();
        List<Product> products = new ArrayList<>();
        Product newItem = new Product(addedProduct, itemPrice, itemBeverage);

        products.add(newItem);
        for (Product product : products) {
            System.out.println(product.getName() + "....$" + String.format("%.2f", product.getPrice()));
        }
    }
}
