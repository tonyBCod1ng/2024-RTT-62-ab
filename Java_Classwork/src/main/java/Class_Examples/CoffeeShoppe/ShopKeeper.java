package Class_Examples.CoffeeShoppe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShopKeeper {
    Scanner scanner = new Scanner(System.in);
    List<Product> productList = new ArrayList<>(0);
    File inventoryFile = new File("/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/products.csv");
    public void getProductList() throws IOException {
       try{
           List<Product> prodList = new ArrayList<>();

           FileReader inventoryFileReader = new FileReader(inventoryFile);
           BufferedReader bufferedReader= new BufferedReader(inventoryFileReader);
           String line = bufferedReader.readLine();
            line = bufferedReader.readLine();

           while (line != null) {
               Product p = parseProduct(line);
               productList.add(p);

               line = bufferedReader.readLine();

           }


       } catch (IOException e){
           e.printStackTrace();
        }
    }
    public void addItem() throws IOException {
        FileWriter fileWriter = new FileWriter(inventoryFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println("Welcome to Coffee Inventory System!");
        System.out.println("What product do you want to add?");
        String addedProduct = scanner.next();
        System.out.println("What is the price of this item?");
        double itemPrice = scanner.nextDouble();
        System.out.println("Is this a beverage item? 1 = yes, 2 = no");
        boolean itemBeverage = scanner.nextInt() == 1;
        System.out.println("Item ready to add! How many are we adding?");
        int quantity = scanner.nextInt();
        Product newItem = new Product(addedProduct, itemPrice, itemBeverage, quantity);
        bufferedWriter.write(newItem.getName() + "," + newItem.getPrice() + "," + newItem.getQuantityAvailable() + "," + newItem.isBeverage());
        bufferedWriter.newLine();
        bufferedWriter.close();
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

            System.out.println((index + 1) + ".) " + product.getName() + "            $" + String.format("%.2f", product.getPrice() +  product.getQuantityAvailable()) + " Amt: " + product.getQuantityAvailable());
        index++;
        }
        System.out.println("........................");
    }
    private Product parseProduct(String line) {
        //     0     , 1  , 2, 3
        // Chai Latte,2.99,10,true
        Product result = new Product();

        String[] column = line.split(",");
        result.setName(column[0]);

        double price = Double.parseDouble(column[1]);
        result.setPrice(price);

        int quantity = Integer.parseInt(column[2]);
        result.setQuantityAvailable(quantity);

        boolean beverage = Boolean.parseBoolean(column[3]);
        result.setBeverage(beverage);

        return result;
    }


}
