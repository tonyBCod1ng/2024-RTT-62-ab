package Class_Examples.KBAPractice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayToList arrayToList = new ArrayToList();
        arrayToList.arrayList.add("1");
        arrayToList.arrayList.add("2");
        arrayToList.arrayList.add("3");
        arrayToList.arrayList.add("4");
        arrayToList.arrayList.add("5");
        arrayToList.replaceWith(1);
        arrayToList.replaceWith(3);
        System.out.println(arrayToList.compact());
    }
}
