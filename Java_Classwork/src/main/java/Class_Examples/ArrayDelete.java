package Class_Examples;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDelete {
    public static Scanner scanner = new Scanner(System.in);
    static String[] arr = {"A", "B", "C", "D", "E", "F"};
    public static void main(String[] args) {
       System.out.println("Enter the position of the item to delete: ");
        int position = scanner.nextInt();
        miteDeleteLater(arr,3);
    }

    public static void miteDeleteLater(String[] source, int atPos) {
        String[] ogArray = source;
        String[] newArray = new String[ogArray.length - 1];
        if (atPos > ogArray.length - 1 || atPos < 0) {
            System.out.println("Position is out of bounds");
            return;
        }
        System.out.println("Ok, we are deleting, " + ogArray[atPos] + "!");
        for (int count = 0; count < newArray.length; count++) {
            if (count < atPos) {
                newArray[count] = ogArray[count];
            } else {
                newArray[count] = ogArray[count + 1];
            }
        }
        System.out.println("Changing Array from: " + Arrays.toString(ogArray));
        System.out.println("To: " + Arrays.toString(newArray));
    }
}
