package BinaryConversionMech;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.String.valueOf;

class BinaryToInt {
    void convertToDecimal(String binary) {
        String holder = String.valueOf(binary);
        int result = Integer.parseInt(holder, 2);
        System.out.println("The decimal is " + result);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BinaryToInt binaryToInt = new BinaryToInt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the binary sequence: ");
        binaryToInt.convertToDecimal(scanner.nextLine());
    }
}