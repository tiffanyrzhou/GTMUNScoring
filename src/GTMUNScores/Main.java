package GTMUNScores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Main extends Application {
    File scoresFile;
    ArrayList<Session> all;
    private Session s;

    public void parseSessions(File scoreFile) throws FileNotFoundException {
        if (scoresFile == null) {
            throw new FileNotFoundException("File not uploaded");
        }
        Scanner in = new Scanner(scoresFile);
        in.nextLine();
        while (in.hasNextLine()) {
            s = new Session(in.nextLine());
            all.add(s);
            System.out.println(in.nextLine());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Label status = new Label("Welcome to GTMUN Scoring Application");
        status.setFont(new Font(20));
        Button buttonLoad = new Button("Upload File");
        buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                fileChooser.getExtensionFilters().add(extFilter);
                scoresFile = fileChooser.showOpenDialog(primaryStage);
                try {
                parseSessions(scoresFile);
                }catch (FileNotFoundException e) {
                    System.out.print("File not Found");
                }
            }
        });
        Button score = new Button("Score");
        score.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent arg0) {;
            }
        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(status, buttonLoad);
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();

    }
    public static void main(String[] args) {

        launch(args);
    }
}
