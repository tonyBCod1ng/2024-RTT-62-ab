package Class_Examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ForEach {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Larry");
        names.add("Bob");
        names.add("Jack");
        names.add("Tom");
        names = names.stream().filter(name -> !name.startsWith("B")).collect(Collectors.toList());
        names.forEach(name -> System.out.println(name));
    }
}