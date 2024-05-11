package Class_Examples.InterfaceTinkerage;
@FunctionalInterface
 interface FunctionalInterfaceDemo {
    void say();//Single abstract method

    default void sleep(){
        System.out.println("I'm sleeping *default");
    }
    static void sayHello(){
        System.out.println("Hello. *static");
    }
}
