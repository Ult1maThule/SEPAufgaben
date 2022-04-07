import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.chart.AreaChart;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aufgabe 4.1");

        VBox grid = new VBox();
        TextField textField = new TextField("Titel eingeben!");
        Button button = new Button("Programm beenden!");

        PieChart pieChart = GetPieChart.createPieChart();

        AreaChart areaChart = GetAreaChart.createAreaChart();

        grid.getChildren().addAll(textField, button, pieChart, areaChart);

        button.setOnAction( (event) -> Platform.exit());

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
