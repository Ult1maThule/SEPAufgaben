import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class GetTableView {
    static TableView tableView = new TableView();
    static ObservableList<Student> studentData = FXCollections.observableArrayList();

    public static void createTableView() {
        TableColumn<Student, String> columnOne = new TableColumn<>("Student");
        columnOne.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        TableColumn<Student, String> columnTwo = new TableColumn<>("Status");
        columnTwo.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        tableView.setItems(studentData);
        tableView.getColumns().addAll(columnOne, columnTwo);
    }

    public static void fillTableView(File file) throws IOException {
        studentData.clear();

        BufferedReader br;
        String delimiter= ",";

        try {
            br = new BufferedReader(new FileReader(file));

            String line;

            while((line = br.readLine()) != null) {
                try {
                    String[] fields = line.split(delimiter, -1);

                    Student record = new Student(fields[0], fields[1]);
                    studentData.add(record);
                } catch (IndexOutOfBoundsException e) {
                    Alert popUp = new Alert(Alert.AlertType.ERROR);
                    popUp.setTitle("Dateifehler!");
                    popUp.setHeaderText("CSV-Datei ist falsch formatiert.");
                    popUp.setContentText("Formatierung - name, status - überprüfen.");
                    popUp.showAndWait();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
