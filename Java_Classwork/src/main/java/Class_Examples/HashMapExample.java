package Class_Examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HashMapExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("key1", "value1");
        stringMap.put("key2", "value2");
        String value = stringMap.get("key1");
        stringMap.put(null, "value3");
        stringMap.put("key3", "value4");//overrides last line
        stringMap.put("null value", null);
        System.out.println(value);


        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }
}
