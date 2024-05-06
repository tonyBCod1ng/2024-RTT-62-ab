package Class_Examples;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        letsSortThisOut();
        }
        public static void letsSortThisOut() {
            int[] array = {6, 0,-1, 3, 5};

            for(int outer = 0; outer < array.length; outer++) {
            boolean swapped = false;
                for(int pos = 0; pos < array.length - 1; pos++) {
                
                    if(array[pos] > array[pos+1]) {
                        swapped = true;
                        int temp = array[pos];
                        array[pos] = array[pos+1];
                        array[pos+1] = temp;
                    }
                    System.out.println(Arrays.toString(array));
                    if(swapped){
                        break;
                    }
                }
            }
          System.out.println(Arrays.toString(array));
    }
}
