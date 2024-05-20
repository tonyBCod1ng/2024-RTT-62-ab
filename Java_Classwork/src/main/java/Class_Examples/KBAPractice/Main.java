package Class_Examples.KBAPractice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayToList arrayToList = new ArrayToList();
       String[] arrayStuff = {"A", "B", "C", "D", "E", "F", "G", "H"};
       arrayToList.convert(arrayStuff);
       arrayToList.replaceWith(1);
       arrayToList.replaceWith(3);
       System.out.println(arrayToList.compact());

    }
}
