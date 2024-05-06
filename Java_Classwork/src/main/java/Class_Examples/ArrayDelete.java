package Class_Examples;

public class ArrayDelete {
    public static void main(String[] args) {
        deleteFunc(1);
    }

    public static void deleteFunc(int atPos) {
        String[] ogArray = {"A", "B", "C", "D", "E", "F"};
        String[] newArray = new String[ogArray.length - 1];

        for (int i = 0; i < newArray.length; i++) {
            if (i < atPos) {
            newArray[i] = ogArray[i];
            } else {
                newArray[i] = ogArray[i + 1];
            }
        }
        System.out.println(newArray[atPos]);
    }
}
