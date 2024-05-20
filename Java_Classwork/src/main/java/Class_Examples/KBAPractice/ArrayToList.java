package Class_Examples.KBAPractice;

import java.util.ArrayList;

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
    public void replaceWith(int idx) {
        System.out.println("I have replaced the string: " + arrayList.get(idx) + " with a null string");
        arrayList.set(idx, "");


    }

    @Override
    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();

        for (String item : arrayList) {
            if (item.isEmpty()) {
                continue;
            };
            result.add(item);
        }

        return result;
    };
}
