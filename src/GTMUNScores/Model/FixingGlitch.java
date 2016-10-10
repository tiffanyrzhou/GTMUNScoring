package GTMUNScores.Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
/**
 * Created by Tiffany on 10/5/16.
 */
public class FixingGlitch {
    ArrayList<Session> sessions = new ArrayList<>();
    HashMap<String,ArrayList<Session>> Committee = new HashMap<>();
    ArrayList<GTMUNScores.Model.Committee> cCompiled = new ArrayList<>();
    File scores;

    public FixingGlitch(File scores){
        this.scores = scores;
    }

    public void setScores(File file) {
        this.scores = file;
    }

    public void score() throws FileNotFoundException{
        if (scores == null){
            System.out.print("null");
        }
        Scanner fileReader = new Scanner(scores);
        fileReader.nextLine();
        while (fileReader.hasNextLine()) {
            String sessionInfo = fileReader.nextLine();
            //parsing each line from the csv file
            // creating the different sessions by each line
            //System.out.println(sessionInfo);
            Session s = new Session(sessionInfo);
            sessions.add(s);
        }
        for (Session s: sessions) {
            //System.out.println(s.getName());
            if (Committee.containsKey(s.getName())){
                Committee.get(s.getName()).add(s);
            } else {
                ArrayList<Session> firstSession = new ArrayList<>();
                firstSession.add(s);
                Committee.put(s.getName(),firstSession);
            }
        }
        for (ArrayList<Session> s: Committee.values()) {
            Committee c = new Committee(s);
            cCompiled.add(c);

        }
//        for(Committee c : cCompiled){
//            System.out.print(c.getTopToString());
//        }
    }

    public ArrayList<Committee> getAllCommittee(){
        return cCompiled;
    }
}
