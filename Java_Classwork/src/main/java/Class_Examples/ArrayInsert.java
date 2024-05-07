package Class_Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayInsert {
    static Scanner scanner = new Scanner(System.in);
    public static int[] insert(int[] source, int insertPos, int valueToInsert){
        int[] result = new int[source.length + 1];

        // 2) copy the first part of the array (before position 2) from the old to the new
        for (int pos = 0; pos < insertPos; pos++) {
            result[pos] = source[pos];
        }

        // 3) actually insert the value we want in position 2
        result[insertPos] = valueToInsert;

        // 4) copy over the rest of the array
        for (int pos = insertPos; pos < source.length; pos++) {
            result[pos + 1] = source[pos];
        }


        for (int value : result) {
            System.out.println(value);
        }


        System.out.println("Old Array: " + Arrays.toString(source));
        System.out.println("New Array: " + Arrays.toString(result));
        return result;

    }


        public static void main(String[] args) {

        System.out.println("Enter the position you want to insert in to:");
        int insertPos = scanner.nextInt();
        System.out.println("Enter the value you want to insert:");
        int valueToInsert = scanner.nextInt();

            // original array
            // pos   01234
            // value 12345

            int[] array = {1, 2, 3, 4, 5};
            insert(array,insertPos,valueToInsert);

            // array after inserting
            // pos   012345
            // value 129345

            // lets write some code to insert a 9 into the array at position 2
            // 1) create a new array of size + 1
        }
    }

