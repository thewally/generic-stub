package nl.thewally.stub.manipulate;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by arjen on 16-1-17.
 */
@Component
public class QueManipulator {
    private Map<String, String> map = new HashMap<>();

    public void set(String target, String xml) {
        map.put(target, xml);
        System.out.printf("Set for target %s value: %n %s %n", target, xml);
    }

    public String get(String target) {
        String xml = map.get(target);
        map.remove(target);
        System.out.printf("Returned and removed for target %s value: %n %s. %n", target, map.get(target));
        return xml;
    }

    public int getSize() {
        System.out.printf("Que contains %s items. %n", map.size());
        return map.size();
    }

    private int getSizeByTarget(String target) {
        Map<String, String> mapByTarget = map.entrySet().stream().filter(p -> p.getKey().equals(target)).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        return mapByTarget.size();
    }

    public void clearAll() {
        map.clear();
        System.out.println("Removed all items from que!");
    }

    public void clearAllByTarget(String target) {
        int size = getSizeByTarget(target);
        for(int i=0;i>size;i++) {
            System.out.printf("Remove %s with value %s.%n", target, map.get(target));
            map.remove(target);
            System.out.println("Done!");
        }
    }

    public Boolean isEmpty() {
        return map.isEmpty();
    }

    public Boolean isEmptyByTarget(String target) {
        Boolean result = false;
        if(getSizeByTarget(target)==0) {
            result = true;
        }
        return result;
    }
}
