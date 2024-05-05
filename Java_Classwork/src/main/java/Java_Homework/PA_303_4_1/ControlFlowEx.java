package Java_Homework.PA_303_4_1;

import java.util.Scanner;

public class ControlFlowEx {

    public static void main(String[] args) {

        lessThanTen();
        masOMeno();
        greaterThnEqlTo();
        chzGrader();
        rangerDave();
        //commented out due to threading conflict
        //dazeOfTheWeek();

    }

    //region - Write a program that declares 1 integer variable x, and then assigns 7 to it.
    // Write an if statement to print out “Less than 10” if x is less than 10.
    // Change x to equal 15, and notice the result (console should not display anything).
    public static void lessThanTen() {
        int x = 7;
        x = 15; //causes condition below to become read false
        if (x < 10) {
            System.out.println("Less than 10");
        }
    }
    //endregion

    //region -Write a program that declares 1 integer variable x, and then assigns 7 to it.
    // Write an if-else statement that prints out “Less than 10” if x is less than 10, and “Greater than 10”
    // if x is greater than 10. Change x to 15 and notice the result.
    public static void masOMeno() {
        int x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if (x > 10) {
            System.out.println("Greater than 10");
        }
    }

    //endregion

    //region - Write a program that declares 1 integer variable x, and then assigns 15 to it.
    // Write an if-else-if statement that prints out “Less than 10” if x is less than 10;
    // “Between 10 and 20” if x is greater than 10 but less than 20,
    // and “Greater than or equal to 20” if x is greater than or equal to 20.
    // Change x to 50 and notice the result.
    public static void greaterThnEqlTo() {
        int x = 50;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if (x > 10 && x < 20) {
            System.out.println("Greater than or equal to 20");
        }
    }
    //endregion

    //region -Write a program that declares 1 integer variable x, and then assigns 15 to it.
    // Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20
    // and prints “In range” if the number is between 10 and 20 (including equal to 10 or 20).
    // Change x to 5 and notice the result.
    public static void rangerDave() {
        int x = 5;
        if (x < 10 || x > 20) {
            System.out.println("Out of Range");
        } else if (x >= 10 && x <= 20) {
            System.out.println("In range");
        }
    }
    //endregion

    //region -Write a program that uses if-else-if statements to print out grades A, B, C, D, F,
    // according to the following criteria:
    //A: 90-100
    //B: 80-89
    //C: 70-79
    //D: 60-69
    //F: <60
    //Use the Scanner class to accept a number score from the user to determine the letter grade.
    // Print out “Score out of range” if the score is less than 0 or greater than 100.
    public static void chzGrader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Score: ");
        int score = scanner.nextInt();
        scanner.close();
        if (score > 90 && score <= 100) {
            System.out.println("Grade: A");
        } else if (score < 90 && score >= 80) {
            System.out.println("Grade: B");
        } else if (score < 80 && score >= 70) {
            System.out.println("Grade: C");
        } else if (score < 70 && score >= 60) {
            System.out.println("Grade: D");
        } else if (score < 60 && score >= 0) {
            System.out.println("Grade: F");
        } else {
            System.out.println("Score is out of range");
        }
    }
    //endregion

    //region -Write a program that accepts an integer between 1 and 7 from the user.
    // Use a switch statement to print out the corresponding weekday.
    // Print “Out of range” if the number is less than 1 or greater than 7.
    // Do not forget to include “break” statements in each of your cases.
    public static void dazeOfTheWeek() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number between 1 and 7: ");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Monday");
                scanner.close();
                break;
            case 2:
                System.out.println("Tuesday");
                scanner.close();
                break;
            case 3:
                System.out.println("Wednesday");
                scanner.close();
                break;
            case 4:
                System.out.println("Thursday");
                scanner.close();
                break;
            case 5:
                System.out.println("Friday");
                scanner.close();
                break;
            case 6:
                System.out.println("Saturday");
                scanner.close();
                break;
            case 7:
                System.out.println("Sunday");
                scanner.close();
                break;
            default:
                System.out.println("Out of range");
                scanner.close();
        }
    }
    //endregion
}
