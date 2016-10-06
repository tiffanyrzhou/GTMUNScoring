package GTMUNScores;

import GTMUNScores.MainApp.Main;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainScreenController {

    /**stage view for upload file*/
    private Stage uploadFileStage;

    /**file to be saved*/
    private File scoresFile;

    /** reference back to mainApplication if needed */
    private Main mainApplication;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
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
        scoresFile = fileChooser.showOpenDialog(uploadFileStage);
    }

    public File getScoresFile() {
        return scoresFile;
    }

    @FXML
    private void handleScoreFile() {
        
    }
}
