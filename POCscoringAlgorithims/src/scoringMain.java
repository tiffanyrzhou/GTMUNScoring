/**
 * Created by Tiffany on 10/2/16.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;

public class scoringMain {
    public static void main(String[] args) {
         ArrayList<Sessions> sessions = new ArrayList<>();
         HashMap<String,ArrayList<Sessions>> Committee = new HashMap<>();
        ArrayList<Committee> cCompiled = new ArrayList<>();

        // Pass in Voter Data
        File scores = new File("resources/scores.csv");
        // reading in the CSV file
        try {
            Scanner fileReader = new Scanner(scores);
            fileReader.nextLine();
            while (fileReader.hasNextLine()) {
                String sessionInfo = fileReader.nextLine();
                //parsing each line from the csv file
                // creating the different sessions by each line
                //System.out.println(sessionInfo);
                Sessions s = new Sessions(sessionInfo);
                System.out.println(s.getName());
                sessions.add(s);
                //System.out.print(s.getTopToString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Sessions s: sessions) {
            //System.out.println(s.getName());
            if (Committee.containsKey(s.getName())){
                Committee.get(s.getName()).add(s);
            } else {
                ArrayList<Sessions> firstSession = new ArrayList<>();
                firstSession.add(s);
                Committee.put(s.getName(),firstSession);
            }
        }
        for (ArrayList<Sessions> s: Committee.values()) {
            Committee c = new Committee(s);
            cCompiled.add(c);

        }
        for(Committee c : cCompiled){
            System.out.print(c.getTopToString());
        }

    }

}
