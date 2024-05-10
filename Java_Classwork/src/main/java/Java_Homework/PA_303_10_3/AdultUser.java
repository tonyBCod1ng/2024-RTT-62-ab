package Java_Homework.PA_303_10_3;

 class AdultUser implements LibraryUser {
    int age;
    String bookType;


    public void registerAccount() {
        if (age >= 12) {
            System.out.println("You have successfully registered under an Adult Account.");
        } else {
            System.out.println("Sorry, age must be greater than 12 to register as an adult.");
        }
    }


    public void requestBook() {
        if (bookType == "Fiction") {
            System.out.println("successfully, please return the book within 7 days.");
        } else {
            System.out.println("Oops, you are allowed to take only adult Fiction books. May I suggest 1984? Muahahahahaha!");
        }
    }
}
