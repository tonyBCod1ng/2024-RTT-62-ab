package Class_Examples.CoffeeShoppe;

import java.util.ArrayList;
import java.util.List;

import static Class_Examples.CoffeeShoppe.CoffeeShoppe.sc;

public class OpenShoppe {
    public static List<Product> products = new ArrayList<>();
    public static void openShoppe() {
        System.out.println("Welcome to Coffee Shoppe Inventory!");
        System.out.println("What do you want to do?");
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Edit product");
        System.out.println("4. List products");
        System.out.println("5. Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                CoffeeShoppe.addItem();
                break;
            case 2:
                System.out.println("Removed Item");
                break;
            case 3:
                System.out.println("Edited Item");
                break;
            case 4:
                CoffeeShoppe.printMenu(products);
                break;
            case 5:
                System.exit(0);
        }
    }
}
