import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class GetPieChart {
    public static PieChart createPieChart() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("A", 25),
                        new PieChart.Data("B" , 30),
                        new PieChart.Data("C", 5),
                        new PieChart.Data("D", 15),
                        new PieChart.Data("E", 25));
        final PieChart pieChart = new PieChart(pieChartData);

        return pieChart;
    }
}
