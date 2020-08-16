package main.trial;

import java.util.HashMap;
import java.util.Map;

final class FinalClass {

    private final String name;
    private final HashMap<Integer, String> map;

    FinalClass(String name, HashMap<Integer, String> mp) {
        this.name = name;
        this.map = new HashMap<>();
        for(Map.Entry<Integer, String> entry: mp.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public String getName() {
        return this.name;
    }

    public HashMap<Integer, String> getMap() {
        return (HashMap<Integer, String>) map.clone();
    }
}

public class ImmutableClass {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Hi");
        map.put(2, "yo");
        String s1 = "Priya";
        FinalClass finalClass = new FinalClass(s1, map);

        System.out.println(finalClass.getName()==s1);
        System.out.println(finalClass.getMap()==map);
        HashMap<Integer,String> map1 = finalClass.getMap();
        map1.put(3, "no modify");
        System.out.println(map1.size() + " " + finalClass.getMap().size());
    }
}
