package Class_Examples;

import java.util.Scanner;

public class ScannerClasswrk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a number: ");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("The numbers you typed were: " + number);
    }

}
