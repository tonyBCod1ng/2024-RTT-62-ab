package Java_Homework.GLAB_303_13_2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {
    public static void main(String[] args) throws IOException {
        // initializing two files in Array;
        String[] inputFiles = {"/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/file1.txt",
                "/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/file2.txt"};

        // Specify out file with path location
//Files contents will be written in these files
        String outputFile = "/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/nioOutput.txt";

        // Get Channel for destination or outputFile
        FileOutputStream fileOutputStreams = new FileOutputStream(outputFile);
        FileChannel targetChannel = fileOutputStreams.getChannel();

        for (int i = 0; i < inputFiles.length; i++) {
            // Get channel for inputFiles
            FileInputStream fileInputStream = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fileInputStream.getChannel();
            long size = inputChannel.size();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) size);
            System.out.print((char) byteBuffer.get());
            while (inputChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    //  System.out.print((char) buf.get());
                    targetChannel.write(byteBuffer);
                }
            }
            //fileInputStream.close();
        }
    }
}

