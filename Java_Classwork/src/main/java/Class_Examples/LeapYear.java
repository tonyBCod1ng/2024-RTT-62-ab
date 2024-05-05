package Class_Examples;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        System.out.println("Enter a Year: ");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();


        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            input.close();
            System.out.println(year + " Is a Leap Year!");
        } else {
            input.close();
            System.out.println(year + " Is not a Leap Year!");
        }
    }
}
