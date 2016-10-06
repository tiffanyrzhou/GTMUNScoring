package GTMUNScores.Controller;

import GTMUNScores.MainApp.Main;
import GTMUNScores.Model.Committee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import GTMUNScores.Model.ScoringAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainScreenController {

    /**stage view for upload file*/
    private Stage uploadFileStage;

    /**file to be saved*/
    private File scoresFile;

    /** reference back to mainApplication if needed */
    private Main mainApplication;

    private ScoringController scoringController;

    private boolean fileUploaded = false;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }


    public File getScoresFile() {
        return scoresFile;
    }

    /**
     *
     * @param dialogStage
     */
    public void setUploadFileStage(Stage dialogStage) {
        uploadFileStage = dialogStage;
    }

    @FXML
    private void handleUploadFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        this.scoresFile = fileChooser.showOpenDialog(uploadFileStage);
        fileUploaded = true;
        mainApplication.setScoresFile(scoresFile);
    }

    public boolean isFileUploaded() {
        return fileUploaded;
    }

    @FXML
    private void handleScoreFile() {
        mainApplication.showScoreScreen();
    }

}
