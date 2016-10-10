package GTMUNScores.Controller;

import GTMUNScores.MainApp.Main;
import GTMUNScores.Model.Committee;
import GTMUNScores.Model.ScoringAlgorithm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import GTMUNScores.Controller.MainScreenController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * Created by David on 10/5/2016.
 */
public class ScoringController {

    /**stage view for upload file*/
    private Stage scoringStage;

    /**file to be saved*/
    private File scoresFile;

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView scoreList;

    private ScoringAlgorithm scoringAlgorithm;

    /** reference back to mainApplication if needed */
    private Main mainApplication;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }

    public ScoringAlgorithm getScoringAlgorithm() {
        return this.scoringAlgorithm;
    }

    public void setFile(File file) {
        this.scoresFile = file;
    }

    public void foo() {
        System.out.println("foo");
    }

    public void setScoringAlgorithm(ScoringAlgorithm scoringAlgorithm) {
        this.scoringAlgorithm = scoringAlgorithm;
    }

    public ArrayList<String> generateList() throws FileNotFoundException {
        scoringAlgorithm.score();
        ArrayList<Committee> committeeList = scoringAlgorithm.getAllCommittee();
        ArrayList<String> finalList = new ArrayList<>();
        for (Committee c : committeeList) {
            finalList.add(c.getTopToString());
        }
        return finalList;
    }

    public ObservableList<String> getObservableList(ArrayList list) throws FileNotFoundException{
        return FXCollections.observableArrayList(list);
    }

    @FXML
    public void populateListView(ObservableList<String> list) throws FileNotFoundException{
        listView.setItems(list);
    }

    @FXML
    public void initialize(File scores) throws FileNotFoundException {
        scoringAlgorithm = new ScoringAlgorithm(scores);
        populateListView(getObservableList(generateList()));
    }

}
