package Java_Homework.PA_303_5_1;

import java.util.Scanner;

public class LoopHW {
    public static void main(String[] args) {
        timeTable();
        daGreatest();
        twoTimer();
    }

    public static void timeTable() {
        int leftSide = 0;
        for (int j = 1; j <= 13; j++) {
            for (int i = 0; i <= 12; i++) {
                System.out.println(leftSide + "X" + i + " = " + leftSide * i);
            }
            leftSide++;
        }
    }

    public static void daGreatest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1st number:");
        int n1 = scanner.nextInt();
        System.out.println("Enter 2nd number:");
        int n2 = scanner.nextInt();
        scanner.close();
        int smll = Math.min(n1, n2);
        int lrg = Math.max(n1, n2);
        if(lrg % smll == 0) {
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
    public static void twoTimer() {
        int staringAmt = 10000;
        int goalAmt = staringAmt * 2;
        int yearsNeeded = 0;

        while (staringAmt <= goalAmt) {
            //takes last amount and add it to seven percent of itself
            staringAmt += staringAmt * 0.07;
            yearsNeeded++;
        }

        System.out.println("It will be " + yearsNeeded + " years before tuition doubles to " + staringAmt);
    }
}
