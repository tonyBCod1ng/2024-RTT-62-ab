package Class_Examples.InterfacingUrFears;

public class KBAWork {
    public static void main(String[] args) {
       MyFuncInterface myFuncInterface = (a) -> Math.sqrt(a);
       System.out.println(myFuncInterface.sqr(100));
    }
}
