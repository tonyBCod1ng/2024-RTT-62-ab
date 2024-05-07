package Class_Examples.CoffeeShoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShopKeeper {
    Scanner scanner = new Scanner(System.in);
    List<Product> productList = new ArrayList<>(0);

    public void addItem() {

        System.out.println("Welcome to Coffee Inventory System!");
        System.out.println("What product do you want to add?");
        String addedProduct = scanner.next();
        System.out.println("What is the price of this item?");
        double itemPrice = scanner.nextDouble();
        System.out.println("Is this a beverage item? 1 = yes, 2 = no");
        boolean itemBeverage = scanner.nextInt() == 1;

        Product newItem = new Product(addedProduct, itemPrice, itemBeverage);
        productList.add(newItem);
        System.out.println("Added product " + addedProduct + " with price " + String.format("$%.2f", newItem.getPrice()));
    }
public void editProduct() {
        if (productList.isEmpty()) {
            System.out.println("Nothing to edit");
            return;
        }
        System.out.println("What product do you want to edit?");
        printMenu();
        Product selectedItem = (Product) productList.toArray()[scanner.nextInt() -1];
        System.out.println("What is the new price of this item?");
        selectedItem.setPrice(scanner.nextDouble());
        System.out.println("The new price of " + selectedItem.getName() + " item is " + String.format("$%.2f", selectedItem.getPrice()));
}
public void removeItem() {
        if (productList.isEmpty()) {
            System.out.println("Nothing to remove");
            return;
        }
        System.out.println("What product do you want to remove?");
        printMenu();
        Product selectedItem = (Product) productList.toArray()[scanner.nextInt() -1];
        productList.remove(selectedItem);
        System.out.println(selectedItem.getName() + " removed from the inventory!");
        printMenu();
}
    public void printMenu() {
        int index = 0;
        System.out.println("..........Menu..........");
        for (Product product : productList) {

            System.out.println((index + 1) + ".) " + product.getName() + "            $" + String.format("%.2f", product.getPrice()));
        index++;
        }
        System.out.println("........................");
    }
}
