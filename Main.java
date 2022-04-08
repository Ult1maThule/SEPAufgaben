import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSV-Datei auslesen");

        Label label = new Label("CSV-Inhalt");
        label.setFont(new Font("Arial", 15));
        Button button = new Button("CSV-Datei laden!");

        button.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Datei einlesen!");
                        fileChooser.getExtensionFilters().add(
                                new FileChooser.ExtensionFilter("CSV files", "*.csv")
                        );

                        File file = fileChooser.showOpenDialog(primaryStage);

                        if (file != null) {
                            try {
                                GetTableView.createTableView();
                                GetTableView.fillTableView(file);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, GetTableView.tableView, button);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
