package Class_Examples;

import java.io.File;

public class FileExample {
   static final String PATH_NAME = "/Users/tonybcod1ng/Desktop/2024-RTT-62-ab/Java_Classwork/src/main/java/Class_Examples";
    public static void main(String[] args) throws Exception {
        File file = new File(PATH_NAME);
        File[] files = file.listFiles();
        for (File foundFile : files) {
            System.out.print(foundFile.getName());
            if (foundFile.isFile()) {
                System.out.println(" is a file");
            } else {
                System.out.println(" is a Directory");
            }
        }
        File newFile = new File("./newFile.java");
        newFile.createNewFile();
    }
}
