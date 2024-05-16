package Class_Examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try{
            File output = new File("output.txt");
            FileWriter fileWriter = new FileWriter(output, false);
            for(int counter = 0; counter <= 15; counter++){
                fileWriter.write("Line" + "(" + counter + ")" + " This is a sentance, cool right? \n");
            }
            fileWriter.flush(); //writes what is currently in the buffer to file
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
