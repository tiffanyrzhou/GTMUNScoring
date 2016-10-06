package GTMUNScores.MainApp;

import GTMUNScores.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {

    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("Main");

    /** file to be score*/
    File scoresFile;

    /** the main container for the application window */
    private Stage mainScreen;

    /** the main layout for the main window */
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
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



    public static void main(String[] args) {
        launch(args);
    }
}
