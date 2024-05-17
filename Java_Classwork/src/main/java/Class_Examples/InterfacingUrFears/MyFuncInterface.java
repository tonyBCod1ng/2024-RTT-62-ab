package Class_Examples.InterfacingUrFears;

@FunctionalInterface
public interface MyFuncInterface {
    public double sqr (double a);

    default int sqr(int a, int b) {
        return a + b;
    }
}
