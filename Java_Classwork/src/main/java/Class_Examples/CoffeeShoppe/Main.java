package Class_Examples.CoffeeShoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> products = new ArrayList<>();
    static CoffeeShoppe coffeeShoppe = new CoffeeShoppe();

    public static void main(String[] args) {
coffeeShoppe.addItem();
        coffeeShoppe.printMenu(products);


    }
}
