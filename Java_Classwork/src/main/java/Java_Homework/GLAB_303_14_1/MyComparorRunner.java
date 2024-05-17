package Java_Homework.GLAB_303_14_1;

public class MyComparorRunner {
    public static void main(String[] args) {
        MyComparingClass compareObj = new MyComparingClass();
        int resultInteger =  compareObj.compareTwoVar.compare(55,50);
        System.out.println(resultInteger);
        String resultString = compareObj.stCompare.compare("h", "H");
        System.out.println(resultString);
        Float result = compareObj.flCompare.compare(2.3f,4.6f);
        System.out.println(result);
    }
}
