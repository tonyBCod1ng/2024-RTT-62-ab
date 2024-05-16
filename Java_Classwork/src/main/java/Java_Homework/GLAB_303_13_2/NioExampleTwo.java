package Java_Homework.GLAB_303_13_2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //Input files
        String[] inputFiles = {"/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/file1.txt",
                "/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/file2.txt"};

        //Files contents will be written in these files
        String outputFile = "/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/nioOutput2.txt";
        //Get channel for output file

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fileOutputStream.getChannel();
        for (int i = 0; i < inputFiles.length; i++) {
            //Get channel for input files
            FileInputStream fileInputStream = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fileInputStream.getChannel();

            //Transfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close the input channel
            inputChannel.close();
            fileInputStream.close();
        }

        //finally close the target channel
        targetChannel.close();
        fileOutputStream.close();
    }
}

