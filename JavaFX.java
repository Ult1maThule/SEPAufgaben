import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JavaFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aufgabe 4.1");

        VBox grid = new VBox();
        TextField textField = new TextField("Text eingeben!");
        Button button = new Button("Text loeschen!");

        grid.getChildren().addAll(textField, button);

        button.setOnAction( (event) -> textField.clear());
        //button.setOnAction( (event) -> Platform.exit());

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
