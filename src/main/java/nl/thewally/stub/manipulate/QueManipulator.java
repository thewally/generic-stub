package nl.thewally.stub.manipulate;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arjen on 16-1-17.
 */
@Component
public class QueManipulator {
    private Map<String, List<String>> map = new HashMap<>();

    public void set(String target, String xml) {
        List<String> list = map.get(target);
        if (list == null)
        {
            list = new ArrayList<String>();
            map.put(target, list);
        }
        list.add(xml);
        System.out.printf("Set for target %s value: %n %s %n", target, xml);
        printCollection();
    }

    public String get(String target) {
        List<String> list = map.get(target);
        String xml = list.get(0);
        list.remove(0);
        System.out.printf("Returned and removed for target %s value: %n %s. %n", target, xml);
        printCollection();
        return xml;
    }

    public int getSize() {
        int size = 0;
        for (String target : map.keySet()) {
            size = size + getSizeByTarget(target);
        }
        return size;
    }

    private int getSizeByTarget(String target) {
        List<String> list = map.get(target);
        return list.size();
    }

    public void clearAll() {
        map.clear();
        System.out.println("Removed all items from que!");
    }

    public void clearAllByTarget(String target) {
        if(map.containsKey(target)) {
            System.out.printf("Remove %s with value %s.%n", target, map.get(target));
            map.remove(target);
            System.out.println("Done!");
        } else {
            System.out.println("Target "+target+" is not available.");
        }
        printCollection();
    }

    public Boolean isEmpty() {
        return map.isEmpty();
    }

    public Boolean isEmptyByTarget(String target) {
        Boolean result = false;
        List<String> list = map.get(target);
        if(list==null) {
            result = true;
        }
        return result;
    }

    private void printCollection(){
        System.out.println("============\nCOLLECTION\n============");
        for (String x : map.keySet()) {
            System.out.println(x + " : " + getSizeByTarget(x));
        }
        System.out.println("============");
    }
}
