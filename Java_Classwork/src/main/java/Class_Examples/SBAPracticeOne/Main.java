package Class_Examples.SBAPracticeOne;

import java.util.ArrayList;

//Created interface
interface MyList {
    void convert(String[] a);

    void replace(int index);

    ArrayList<String> compact();
}

class Main {
    public static void main(String[] args) throws InvalidStringException {
        ArrayToList arrayToList = new ArrayToList();
        String[] arrayStuff = {"A", "B", "C", "D", "E", "F", "G", "H"};
        arrayToList.convert(arrayStuff);
        arrayToList.replace(1);
        arrayToList.replace(3);
        System.out.println(arrayToList.compact());

    }
}

//Created ArrayToList class and implemented methods from Interface
class ArrayToList implements MyList {
    ArrayList<String> arrayList;

    public ArrayToList() {
        arrayList = new ArrayList<>();
    }

    @Override
    public void convert(String[] a) {
        for (int pos = 0; pos < a.length; pos++) {
            arrayList.add(a[pos]);
            System.out.println("I have added the string: " + a[pos] + " at the index: " + pos);
        }
    }

    @Override
    public void replace(int idx) {
        System.out.println("I have replaced the string: " + arrayList.get(idx) + " with a null string");
        arrayList.set(idx, "");


    }

    @Override
    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();

        for (String item : arrayList) {
            if (item.isEmpty()) {
                continue;
            }
            ;
            result.add(item);
        }

        return result;
    }

    ;
}


// - Created custom exception
class InvalidStringException extends Exception {
    InvalidStringException(String message) {
        super(message);
    }
}