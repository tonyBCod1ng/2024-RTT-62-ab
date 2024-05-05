package Java_Homework.PA_303_5_1;

import java.util.Scanner;

public class LoopHW {

    public static void main(String[] args) {
        timeTable();
        daGreatest();
        //twoTimer(); commented out to prevent threading conflict if enabled, comment out the "daGreatest" func
    }

    //region -Write a program that uses nested for loops to print a multiplication table.
    public static void timeTable() {
        int leftSide = 0;
        for (int j = 1; j <= 13; j++) {
            for (int count = 0; count <= 12; count++) {
                System.out.println(leftSide + "X" + count + " = " + leftSide * count);
            }
            leftSide++;
        }
    }
    //endregion

    //region -Write a program that prompts the user to enter two positive integers,
    // and find their greatest common divisor (GCD).
    //Examples:
    //Enter 2 and 4. The gcd is 2.
    //Enter 16 and 24.  The gcd is 8.
    //How do you find the gcd?
    //Name the two input integers n1 and n2.
    //You know number 1 is a common divisor, but it may not be the gcd.
    //Check whether k (for k = 2, 3, 4, and so on) is a common divisor for n1 and n2, until k is greater than n1 or n2.
    public static void daGreatest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1st number:");
        int n1 = scanner.nextInt();
        System.out.println("Enter 2nd number:");
        int n2 = scanner.nextInt();
        scanner.close();
        int smll = Math.min(n1, n2);
        int lrg = Math.max(n1, n2);
        if (lrg % smll == 0) {
            System.out.println("GCD is " + smll);
            return;
        }

        while (lrg % smll != 0) {
            int remainder = lrg % smll;
            lrg = smll;
            smll = remainder;
        }
        System.out.println("GCD is " + smll);
    }
    //endregion

    //region -Suppose the tuition for a university is $10,000 for the current year and increases by 7 percent
// every year. In how many years will the tuition be doubled?

    public static void twoTimer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter tuition:");
        double staringAmt = scanner.nextDouble();
        System.out.println("Enter percentage as a whole number:");
        double rate = scanner.nextInt();
        scanner.close();
        double goalAmt = staringAmt + staringAmt;
        int yearsNeeded = 0;

        while (staringAmt <= goalAmt) {
            yearsNeeded++;
            staringAmt += staringAmt * rate / 100;


        }

        System.out.println("Increasing at a rate of " + rate + "% per year, It will be " + yearsNeeded + " years before tuition doubles.");
    }

    //endregion
}
