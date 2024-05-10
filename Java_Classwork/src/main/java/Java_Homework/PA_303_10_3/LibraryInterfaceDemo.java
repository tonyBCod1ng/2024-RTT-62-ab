package Java_Homework.PA_303_10_3;

 class LibraryInterfaceDemo {
    public static void main(String[] args) {
        KidUser kiddo = new KidUser();
        AdultUser grownUp = new AdultUser();
        kiddo.age = 10;
        kiddo.registerAccount();
        kiddo.age = 23;
        kiddo.registerAccount();
        kiddo.bookType = "Kids";
        kiddo.requestBook();
        kiddo.bookType = "Fiction";
        kiddo.requestBook();
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
