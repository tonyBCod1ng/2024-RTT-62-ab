import java.util.Scanner;

public class ScannerClasswrk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a number: ");
        int number = scanner.nextInt();

        System.out.println(number);
    }

}
