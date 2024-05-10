package Java_Homework.PA_303_10_3;

public class Demo {
    public static void main(String[] args) {
        AdultUser grownUp = new AdultUser();
        grownUp.age = 5;
        grownUp.registerAccount();
        grownUp.age = 23;
        grownUp.registerAccount();
        grownUp.bookType = "Kids";
        grownUp.requestBook();
        grownUp.bookType = "Fiction";
        grownUp.requestBook();
    }
}
