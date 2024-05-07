package Java_Homework.PA_303_2_1;

public class VariableHW {
   final static double SALES_TAX = 0.07;
    public static void main(String[] args) {
        summer();
        doubleSum();
        intNDubleSum();
        divider();
        xyDivider();
        constantine();
        cafeShoppe();
    }
    // I treated each task as a method within the public class and created a region for each one below

    //region -Write a program that declares two integer variables, assigns an integer to each, and adds them together. Assign the sum to a variable. Print out the result.
    public static void summer() {
        int a = 10;
        int b = 23;
        System.out.println(a + b);
    }
    //endregion

    //region - Write a program that declares two double variables, assigns a number to each, and adds them together. Assign the sum to a variable. Print out the result.
    public static void doubleSum() {
        double dub = 2.1;
        double ski = 2.3;
        double sum = dub + ski;
        System.out.println(sum);
    }
    //endregion

    //region -Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds them together. Assign the sum to a variable. Print out the result. What variable type must the sum be?
    public static void intNDubleSum() {
        int a = 1;
        double b = 1.1;
        double c = a + b;
        System.out.println(c);
    }
    //endregion

    //region -Write a program that declares two integer variables, assigns an integer to each, and divides the larger number by the smaller number. Assign the result to a variable. Print out the result. Now change the larger number to a decimal. What happens? What corrections are needed?
    public static void divider() {
        int first = 10;
        int second = 21;
        double sum = (double) first / (double) second;
        System.out.println("the result is: " + sum);
        //print sum cast as an Integer
        System.out.println((int) sum);
    }

    //endregion

    //region -Write a program that declares two integer variables, x and y, and assigns the number 5 to x and the number 6 to y. Declare a variable q and assign y/x to it and print q. Now, cast y to a double and assign it to q. Print q again.
    public static void xyDivider() {
        int x = 5;
        int y = 6;
        int q = y / x;
        System.out.println(q);
     /* To successfully print out q without errors after casting y as a double you can manually cast the results of y/x like below:
        int q = (int) (y/x);
        System.out.println(q);
      */
    }
    //endregion

    //region -Write a program that declares a named constant and uses it in a calculation. Print the result.
    public static void constantine() {
        int FIVE = 5;
        int result = FIVE * 10;
        System.out.println(result);
    }
    //endregion

    //region - Write a program where you create three variables that represent products at a cafe. The products could be beverages like coffee, cappuccino, espresso, green tea, etc. Assign prices to each product. Create two more variables called subtotal and totalSale and complete an “order” for three items of the first product, four items of the second product, and two items of the third product. Add them all together to calculate the subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount. Be sure to format the results to two decimal places.

    //First create a class called "Item"

    public static void cafeShoppe() {
        double subTotal;
        double totalSale;

        class Item {
            String name;
            double price;

            public Item(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }
        //Next Create Items

        Item cappuccino = new Item("Cappuccino", 5);
        Item coffee = new Item("Coffee", 3);
        Item chaiLatte = new Item("Chai Latte", 2);

        // lastly process order calculate subtotal and sales tax to calculate total sale

        subTotal = (cappuccino.price * 3) + (coffee.price * 4) + (chaiLatte.price * 2);
        totalSale = (subTotal * SALES_TAX) + subTotal;
        System.out.println("Total amount due: $" + Math.round(totalSale * 100.0) / 100.0);
    }
    //endregion
}


