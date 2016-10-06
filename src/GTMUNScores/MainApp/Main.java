package GTMUNScores.MainApp;

import GTMUNScores.Controller.MainScreenController;
import GTMUNScores.Controller.ScoringController;
import GTMUNScores.Model.ScoringAlgorithm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {

    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("Main");

    /** file to be score*/
    private File scoresFile;

    /** the main container for the application window */
    private Stage mainScreen;

    /** the main layout for the main window */
    private AnchorPane rootLayout;

    private AnchorPane layout;

    private ScoringAlgorithm scoringAlgorithm;

    private MainScreenController mainScreenController;

    private ScoringController scoringController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    public void setScoresFile(File file) {
        this.scoresFile = file;
    }



    private void initRootLayout(Stage mainScreen) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/GTMUNScores.fxml"));
            rootLayout = loader.load();

            // Give the controller access to the main app.
            MainScreenController controller = loader.getController();
            controller.setMainApp(this);

            // Set the Main App title
            mainScreen.setTitle("GTMUN Scoring");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for MainScreen!!");
            e.printStackTrace();
        }
    }

    /**
     * shows main screen
     */
    public void showScoreScreen() {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ScoreView.fxml"));
            //loader.setLocation(Main.class.getResource("../view/ScoreView.fxml"));
            ScoringController controller = new ScoringController();
            loader.setController(controller);
            layout = null;
            try {
                layout = loader.load();
            }catch(IOException e){
                }
            //ScoringController controller = loader.getController();
            controller.setMainApp(this);
            controller.initialize(scoresFile);
            // Set the cleanWaterApp App title
            mainScreen.setTitle("Scores");

            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for WelcomeScreen!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
