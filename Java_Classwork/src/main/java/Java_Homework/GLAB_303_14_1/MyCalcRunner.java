package Java_Homework.GLAB_303_14_1;

class MyCalcRunner {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultAbstract = calculator.funcInterfaceExample.sum(5, 5);
        System.out.println("Result using abstract method: " + resultAbstract);

        int result_defaultMethod = calculator.funcInterfaceExample.multiply(5, 5);
        System.out.println("Result using default method: " + result_defaultMethod);
    }
}


