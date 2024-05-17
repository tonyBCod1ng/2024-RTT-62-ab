package Java_Homework.GLAB_303_14_1;


@FunctionalInterface
public interface FuncInterfaceExample {
    int sum(int a, int b);//abstract method (can only be one)

    default int multiply(int a, int b) {
        return a * b;
    }
}
