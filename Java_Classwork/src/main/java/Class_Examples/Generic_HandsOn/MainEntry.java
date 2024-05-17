package Class_Examples.Generic_HandsOn;

public class MainEntry {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Calc add = argsSum -> {
            int sum = 0;
            for (int num : argsSum) {
                sum += num;
            }
            System.out.println(sum);
        };
        add.compute(nums);
        Calc subtract = argsDiff -> {
            int difference = 0;
            for (int num : argsDiff) {
                difference -= num;
            }
            System.out.println(difference);
        };
        subtract.compute(nums);
        Calc multiply = argsProd -> {
            int product = argsProd[0];
            for (int num : argsProd) {
                product *= num;
            }
            System.out.println(product);
        };
        multiply.compute(nums);
        Calc divide = argsQuot -> {
            int quotient = 0;
            if (argsQuot.length > 2) {
                System.out.println("Can't do that...");

            } else {
                quotient = argsQuot[0] / argsQuot[1];
            }

        };
        divide.compute(nums);
    }
}
