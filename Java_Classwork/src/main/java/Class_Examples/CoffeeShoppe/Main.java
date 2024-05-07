package Class_Examples.CoffeeShoppe;

import java.util.List;
import java.util.Scanner;

class Main {
    private Scanner scanner = new Scanner(System.in);
    private ShopKeeper shopKeeper = new ShopKeeper();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {

        while (true) {
            System.out.println("Welcome to Coffee Shoppe Inventory!");
            System.out.println("What do you want to do?");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Edit product");
            System.out.println("4. List products");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    shopKeeper.addItem();
                    break;
                case 2:
                    shopKeeper.removeItem();
                    break;
                case 3:
                    shopKeeper.editProduct();
                    break;
                case 4:
                    shopKeeper.printMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }
    }

}
