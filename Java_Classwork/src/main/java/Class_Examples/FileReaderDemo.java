package Class_Examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(fileReader);
        File input = new File("output.txt");
        FileReader fileReader = new FileReader(input);

        Scanner scanner = new Scanner(fileReader);
        String line = scanner.nextLine();
        while (scanner.hasNextLine()) {
            System.out.println(line);
            line = scanner.nextLine();
        }
    }
}
