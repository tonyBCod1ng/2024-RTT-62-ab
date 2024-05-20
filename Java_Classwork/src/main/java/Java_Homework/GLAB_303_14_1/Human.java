package Java_Homework.GLAB_303_14_1;
@FunctionalInterface
 interface Human {
    void say(boolean status);//Single abstract method

    default void sleep(){
        System.out.println("I'm sleeping *default method*");
    }
    static void sayHello(){
        System.out.println("Hello. *static method*");
    }

    ;
}
