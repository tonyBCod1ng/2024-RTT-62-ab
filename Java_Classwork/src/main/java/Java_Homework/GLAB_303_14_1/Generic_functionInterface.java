package Java_Homework.GLAB_303_14_1;

@FunctionalInterface
public interface Generic_functionInterface<T> {
    T compare(T a, T b);
    // we can use as:
    // int compare(int a, int b)
    // String compare(String a, String b)
}
