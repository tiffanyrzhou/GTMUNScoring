/**
 * Created by Tiffany on 10/3/16.
 */
import  java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
public class Committee {
    ArrayList<Sessions>  all;
    String name;
    HashMap<String,Integer> topCommittee = new HashMap<>();
    Map<String,Integer> sorted = new HashMap<>();

    public Committee(ArrayList<Sessions> all) {
        this.all = all;
        name = all.get(0).toString();
        populateMap(all);
        this.sorted = sortMap();
    }

    public String getName(){
        return name;
    }

    public void populateMap(ArrayList<Sessions> all) {
        for (Sessions s: all) {
            Map<String, Integer> top = s.getTop();
            for (Map.Entry<String, Integer> entry: top.entrySet()) {
                if (topCommittee.containsKey(entry.getKey())){
                    topCommittee.put(entry.getKey(),topCommittee.get(entry.getKey())+entry.getValue());
                } else {
                    topCommittee.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private Map<String,Integer> sortMap () {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(topCommittee.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    public String getTopToString(){
        String toString = "Committe " + this.name + "\n";
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            toString = toString +("Key: " + entry.getKey() + ". Value: " + entry.getValue() + "\n");
        }
        return toString;
    }

}
