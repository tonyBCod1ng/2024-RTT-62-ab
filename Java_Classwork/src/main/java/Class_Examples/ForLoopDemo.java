package Class_Examples;

import java.util.ArrayList;
import java.util.List;

 class ForLoopDemo {
    public static void main(String[] args) {
        forWhtItsWrth();
        listaLaVista();
        System.out.println("");
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
        list = list.reversed();
        //old style of loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        ;
        //new way to loop
        for (String s : list) {
            if (s == "A") {
                continue;//does not print "A"
            }
            System.out.println(s);
        }
    }
}
