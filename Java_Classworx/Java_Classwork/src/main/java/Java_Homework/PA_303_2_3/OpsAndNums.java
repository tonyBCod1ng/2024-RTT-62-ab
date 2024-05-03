package Java_Homework.PA_303_2_3;

public class OpsAndNums {
    public static void main(String[] args) {
       // lefty();
        //righty();
       // yesAnd();
        //incrementos();
        //allOfTheIncre();
        fixItInPost();
    }

    //region -Write a program that declares an integer a variable x,
    // assigns the value 2 to it, and prints out the binary string version of the number
    // ( Integer.toBinaryString(x) ). Now, use the left shift operator (<<) to shift by 1
    // and assign the result to x. Before printing the results,
    // write a comment with the predicted decimal value and binary string.
    // Now, print out x in decimal form and in binary notation.
    //Perform the preceding exercise with the following values:
    //9
    //17
    //88
    public static void lefty() {
        int x = 2;
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; //100
        System.out.println(Integer.toBinaryString(x));
        x = 9;
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; //10010
        System.out.println(Integer.toBinaryString(x));
        x = 17;
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; //100010
        System.out.println(Integer.toBinaryString(x));
        x = 88;
        System.out.println(Integer.toBinaryString(x));
        x <<= 1;//10110000
        System.out.println(Integer.toBinaryString(x));
    }
    //endregion

    //region -Write a program that declares a variable x, and assigns 150 to it, and prints out the binary string
    // version of the number. Now use the right shift operator (>>) to shift by 2 and assign the result to x.
    // Write a comment indicating what you anticipate the decimal and binary values to be.
    // Now print the value of x and the binary string.
    //Perform the preceding exercise with the following values:
    //225
    //1555
    //32456

    public static void righty() {
        int x = 150;
        System.out.println(Integer.toBinaryString(x));
        x >>= 2; //100101
        System.out.println(Integer.toBinaryString(x));
        x = 225;
        System.out.println(Integer.toBinaryString(x));
        x >>= 2;//111000
        System.out.println(Integer.toBinaryString(x));
        x = 1555;
        System.out.println(Integer.toBinaryString(x));
        x >>= 2;//110000100
        System.out.println(Integer.toBinaryString(x));
        x = 32456;
        System.out.println(Integer.toBinaryString(x));
        x >>= 2;//1111110110010
        System.out.println(Integer.toBinaryString(x));
    }
    //endregion

    //region -Write a program that declares three int variables: x, y, and z. Assign 7 to x and 17 to y.
    // Write a comment that indicates what you predict will be the result of the bitwise and operation on x and y.
    // Now use the bitwise AND (&) operator to derive the decimal and binary values, and assign the result to z.
    public static void yesAnd() {
        int x = 7;
        int y = 17;
        int z = x & y;//1
        System.out.println(z);

        /*Now, with the preceding values, use the bitwise and operator to calculate the “or” value between x and y.
        As before, write a comment that indicates what you predict the values to be before printing them out.
         */
        z = x | y;//23
        System.out.println(z);
    }
    //endregion

    //region -Write a program that declares an integer variable, assigns a number,
    // and uses a postfix increment operator to increase the value.
    // Print the value before and after the increment operator.

    public static void incrementos() {
        int x = 1;
        System.out.println(x);
        x++;
        System.out.println(x);
    }
//endregion

    //region -Write a program that demonstrates at least three ways to increment a variable by 1 and
    // does this multiple times. Assign a value to an integer variable, print it, increment by 1, print it again,
    // increment by 1, and then print it again.
    public static void allOfTheIncre() {
        int x = 1;
        System.out.println(x);
        x++;
        System.out.println(x);
        x += 1;
        System.out.println(x);
        x = x + 1;
        System.out.println(x);
        ++x;
    }

    //endregion

    //region -Write a program that declares two integer variables: x, and y, and then assigns 5 to x and 8 to y.
    // Create another variable sum and assign the value of ++x added to y, and print the result.
    // Notice the value of the sum (should be 14). Now change the increment operator to postfix (x++) and re-run the program.
    // Notice what the value of the sum is. The first configuration incremented x, and then calculated the sum,
    // while the second configuration calculated the sum, and then incremented x.

    public static void fixItInPost(){
        int x = 5;
        int y = 8;
        int sum = (x++) + y;
        System.out.println(sum);

    }


    //endregion
}
