package GTMUNScores;

/**
 * Created by Tiffany on 9/21/16.
 */
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
public class Session {
    String name;
    String[] bestSpeeches = new String[10];
    String[] bestWriting = new String[10];
    String[] bestComposure = new String[10];;
    String[] bestInvolvement = new String[10];
    TreeMap<String, Integer> top = new TreeMap<>();


    public Session (String bestInput) {
        String[] input = bestInput.split(",");
        name = input[0];
        int counter = 0;
        for (int i = 3; i <= 12; i ++) {
            bestInvolvement[counter] = input[i];
        }
        counter = 0;
        for (int i = 13; i <= 22; i ++) {
            bestWriting[counter] = input[i];
        }
        counter = 0;
        for (int i = 23; i <= 32; i ++) {
            bestSpeeches[counter] = input[i];
        }
        counter = 0;
        for (int i = 33; i <= 42; i ++) {
            bestComposure[counter] = input[i];
        }
        populateMap(bestComposure);
        populateMap(bestSpeeches);
        populateMap(bestWriting);
        populateMap(bestInvolvement);
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Session) {
            return this.name.equals(((Session) o).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

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
    public void populateMap(String[] input) {
        int counter = 10;
        for (int i = 0; i < input.length; i++) {
            if (top.containsKey(input[i])) {
                top.put(input[i], top.get(input[i]) + counter);
            } else {
                top.put(input[i], counter);
            }
            counter--;
        }
    }
}
