package Class_Examples;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDelete {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the position of the item to delete: ");
        int position = scanner.nextInt();
        miteDeleteLater(position);
        scanner.close();
    }

    public static void miteDeleteLater(int atPos) {
        String[] ogArray = {"A", "B", "C", "D", "E", "F"};
        String[] newArray = new String[ogArray.length - 1];
        if (atPos > ogArray.length - 1 || atPos < 0) {
            System.out.println("Position is out of bounds");
            return;
        }
        System.out.println("Ok, we are deleting, " + ogArray[atPos] + "!");
        for (int i = 0; i < newArray.length; i++) {
            if (i < atPos) {
                newArray[i] = ogArray[i];
            } else {
                newArray[i] = ogArray[i + 1];
            }
        }
        System.out.println("The new array is: " + Arrays.stream(newArray).toList());
    }
}
