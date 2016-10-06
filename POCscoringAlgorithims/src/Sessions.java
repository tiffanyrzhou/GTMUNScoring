/**
 * Created by Tiffany on 10/2/16.
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;

/**
 * Created by Tiffany on 8/30/16.
 */
public class Sessions {
    String name;
    String[] bestSpeeches = new String[10];
    String[] bestWriting = new String[10];
    String[] bestComposure = new String[10];
    String[] bestInvolvement = new String[10];
    String[] topImpressions = new String[3];
    HashMap<String, Integer> top = new HashMap<>();

    public Sessions (String bestInput) {
        String[] input = bestInput.split(",");
        this.name = input[3];
        int counter = 0;
        for (int i = 4; i <= 13; i ++) {
            bestInvolvement[counter] = input[i];
            counter++;
//            System.out.println(input[i]);
        }
        counter = 0;
        for (int i = 14; i <= 23; i ++) {
            bestWriting[counter] = input[i];
            counter++;
//            System.out.println(input[i]);

        }
        counter = 0;
        for (int i = 24; i <= 33; i ++) {
            bestSpeeches[counter] = input[i];
            counter++;
//            System.out.println(input[i]);
        }
        counter = 0;
        for (int i = 34; i <= 43; i ++) {
            bestComposure[counter] = input[i];
            counter++;
//            System.out.println(input[i]);
        }
        counter = 0;
        for (int i = 44; i <= 46; i ++) {
            topImpressions[counter] = input[i];
            counter++;
//            System.out.println(input[i]);
        }
        populateMap(bestComposure);
        populateMap(bestSpeeches);
        populateMap(bestWriting);
        populateMap(bestInvolvement);
        populateMap2(topImpressions);
    }

    public String getName(){
        return name;
    }
   // @Override
//    public boolean equals(Object o) {
//        if (o instanceof Sessions) {
//            return this.name.equals(((Sessions) o).name);
//        }
//        return false;
//    }
    @Override
    public String toString() {
        return this.name;
    }
    public String[] getBestSpeeches(){
        return bestSpeeches;
    }

    public String[] getBestComposure(){
        return bestComposure;
    }

    public String[] getBestWriting(){
        return bestWriting;
    }
    public Map<String, Integer> getTop(){
        return top;
    }

    public String getTopToString(){
        String toString = "";
        for (Map.Entry<String, Integer> entry : top.entrySet()) {
           toString = toString +("Key: " + entry.getKey() + ". Value: " + entry.getValue() + "\n");
        }
        return toString;
    }
    public void populateMap(String[] input) {
        int counter = 10;
        for (String s: input) {
            //System.out.print(s);
            if (top.containsKey(s)) {
                top.put(s, top.get(s) + counter);
            } else {
                top.put(s, counter);
            }
            counter--;

        }
    }

    public void populateMap2(String[] input) {
        int counter = 10;
        for (String s: input) {
            //System.out.print(s);
            if (top.containsKey(s)) {
                top.put(s, top.get(s) + counter);
            } else {
                top.put(s, counter);
            }
            counter = counter/5;

        }
    }
}