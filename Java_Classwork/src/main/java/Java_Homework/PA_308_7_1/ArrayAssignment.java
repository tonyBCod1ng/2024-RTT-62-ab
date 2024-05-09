package Java_Homework.PA_308_7_1;

import java.util.Arrays;
import java.util.Scanner;

class ArrayAssignment {


    public static void main(String[] args) {
        Run run = new Run();
        run.arrayOfHope();
        run.arraysToTheFinish();
        run.arrayOfColor();
        run.arrayLength();
        run.arrayLoop();
        run.arrayMultLoop();
        run.skipMalcolm();
        run.stringArray();
        run.orderArray();
        run.multiArray();
        run.whatDoYouLike();
        run.avgArray();
    }


}

class Run {
    Scanner scanner = new Scanner(System.in);
    //region - arrayOfHope(): Write a program that creates an array of integers with a length of 3.
    // Assign the values 1, 2, and 3 to the indexes. Print out each array element.
    void arrayOfHope() {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for (int item : arr) {
            System.out.println(item);
        }
    }
    //endregion

    //region -arraysToTheFinish(): Write a program that returns the middle element in an array.
    // Give the following values to the integer array: {13, 5, 7, 68, 2}
    // and produce the following output: 7
    void arraysToTheFinish() {
        int[] arr = {13, 5, 7, 68, 2};

        System.out.println(arr[2]);
    }
    //endregion

    //region -arrayOfColor(): Write a program that creates an array of String type and
    // initializes it with the strings “red,” “green,” “blue,” and “yellow.”
    // Print out the array length. Make a copy using the clone( ) method.
    // Use the Arrays.toString( ) method on the new array to verify that the original array
    // was copied.
    void arrayOfColor() {
        String[] arr = {"red", "green", "blue", "yellow"};
        System.out.println(arr.length);
        String[] clonedArr = arr.clone();
        System.out.println(Arrays.toString(clonedArr));
    }
    //endregion

    //region - arrayLength(): Write a program that creates an integer array with 5 elements (i.e., numbers).
    // The numbers can be any integers.
    // Print out the value at the first index and the last index using length - 1 as the index.
    // Now try printing the value at index = length (e.g., myArray[myArray.length] ).
    // Notice the type of exception which is produced.
    // Now try to assign a value to the array index 5.
    // You should get the same type of exception.
    void arrayLength() {
        int[] arr = new int[5];
        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);

        //arr[5] = 6;//out of bounds
    }
    //endregion

    //region - arrayLoop(): Write a program where you create an integer array with a length of 5.
    // Loop through the array and assign the value of the loop control variable (e.g., i)
    // to the corresponding index in the array.
    void arrayLoop() {
        int[] arr = new int[5];
        for (int count = 0; count < arr.length; count++) {
            arr[count] = count;
        }
        System.out.println(Arrays.toString(arr));
    }
    //endregion

    //region -arrayMultLoop(): Write a program where you create an integer array of 5 numbers.
    // Loop through the array and assign the value of the loop control variable
    // multiplied by 2 to the corresponding index in the array.
    void arrayMultLoop() {
        int[] arr = new int[5];
        for (int count = 0; count < arr.length; count++) {
            arr[count] = count * 2;
        }
        System.out.println(Arrays.toString(arr));
    }
    //endregion

    //region -skipMalcolm(): Write a program where you create an array of 5 elements.
    // Loop through the array and print the value of each element, except for the middle (index 2) element.
    void skipMalcolm() {
        int[] arr = {1, 2, 3, 4, 5};

        for (int count = 0; count < arr.length; count++) {
            if (count == 2) {
                continue;
            }
            System.out.println(arr[count]);
        }
    }
    //endregion

    //region - stringArray(): Write a program that creates a String array of 5 elements
    // and swaps the first element with the middle element without creating a new array.
    void stringArray() {
        String[] arr = {"red", "green", "blue", "yellow"};
        String temp;
        temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;
        System.out.println(Arrays.toString(arr));
    }
    //endregion

    //region -orderArray(): Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}.
    // Print the array in ascending order, and print the smallest and the largest element of the array.
    // The output will look like the following:
    //Array in ascending order: 0, 1, 2, 4, 9, 13
    //The smallest number is 0
    //The biggest number is 13
    void orderArray() {
        int[] arr = {4, 2, 9, 13, 1, 0};
        Arrays.sort(arr);
        System.out.println("Ordered array is:" + Arrays.toString(arr));
        System.out.println("Smallest number is: " + arr[0]);
        System.out.println("Largest number is: " + arr[arr.length - 1]);
    }
    //endregion

    //region -multiArray(): Create an array that includes an integer, 3 strings, and 1 double. Print the array.
    void multiArray() {
        Object[] arr = {1, "green", "blue", "yellow", 2.2};
        System.out.println(Arrays.toString(arr));
    }
    //endregion

    //region -whatDoYouLike(): Write some Java code that asks the user how many favorite things they have.
    // Based on their answer, you should create a String array of the correct size.
    // Then ask the user to enter the things and store them in the array you created.
    // Finally, print out the contents of the array.
    void whatDoYouLike() {
        System.out.println("How many things do you like to do?");
        int numOfThings = scanner.nextInt();
        String[] arr = new String[numOfThings];
        scanner.nextLine();
        if (numOfThings == 0) {
            System.out.println("Oh...I hope you find something soon...yikes.");
            return;
        }
        for (int i = 0; i < numOfThings; i++) {
            System.out.println("What is something you like to do?");
            String item = scanner.next();
            arr[i] = item;
        }
        System.out.println("Here is a list of what you like to do: " + Arrays.toString(arr));
    }
    //endregion

    //region - Create an array of int and determine the average
    void avgArray() {
        int[] arr = {10, 23, 31, 4, 95};
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        System.out.println("The average is " + sum / arr.length);
    }
    //endregion

}