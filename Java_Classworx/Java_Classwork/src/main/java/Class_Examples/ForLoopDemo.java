package Class_Examples;

import java.util.ArrayList;
import java.util.List;

public class ForLoopDemo {
    public static void main(String[] args) {
        forWhtItsWrth();
        listaLaVista();
    }

    public static void forWhtItsWrth() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("Count is: " + i + "." + j);
            }
        }
    }
    public static void listaLaVista() {
        List<String> list = new ArrayList<>();
        list.add("A");// pos 0
        list.add("B");
        list.add("C");

        //old style of loop
        for(int i = 0; i < list.size(); i--) {
            System.out.println(list.get(i));
        };
        //new way to loop
        for(String s : list) {
            System.out.println(s);
        }
    }
}
