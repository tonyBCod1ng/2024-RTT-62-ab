package Class_Examples;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        letsSortThisOut();
        }
        public static void letsSortThisOut() {
            int[] array = {6, 0, 3, 5};

            for(int pos = 0; pos < array.length - 1; pos++) {
                if(array[pos] <= 0 ) {
                    array[pos] = array[0];
                }
                if(array[pos] > array[pos+1]) {
                    int temp = array[pos];
                    array[pos] = array[pos+1];
                    array[pos+1] = temp;
                }
                System.out.println(Arrays.toString(array));
        }
          System.out.println(Arrays.toString(array));
    }
}
