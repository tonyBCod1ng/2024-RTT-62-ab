package Java_Homework.PA_303_5_1;

public class LoopHW {
    public static void main(String[] args) {
        timeTable();
        daGreatest();
    }

    public static void timeTable() {
        int leftSide = 0;
        for (int j = 1; j <= 13; j++) {
            for (int i = 0; i <= 12; i++) {
                System.out.println(leftSide + "X" + i + " = " + leftSide * i);
            }
            leftSide++;
        }
    }
    public static void daGreatest() {
        int a = 2;
        int b = 4;
        
    }
}
