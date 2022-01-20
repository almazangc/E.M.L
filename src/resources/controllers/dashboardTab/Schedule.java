package resources.controllers.dashboardTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import resources.database.DatabaseConnection;
import resources.database.table.ScheduleModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Manages and Modify weekly schedule of employee
 */
public class Schedule implements Initializable {

    @FXML
    private TableView<ScheduleModel> table;
    @FXML
    private TableColumn<ScheduleModel, String> time;
    @FXML
    private TableColumn<ScheduleModel, String> mon;
    @FXML
    private TableColumn<ScheduleModel, String> tue;
    @FXML
    private TableColumn<ScheduleModel, String> wed;
    @FXML
    private TableColumn<ScheduleModel, String> thu;
    @FXML
    private TableColumn<ScheduleModel, String> fri;

    @FXML
    private TableColumn<ScheduleModel, String> sat;

    @FXML
    private TableColumn<ScheduleModel, String> sun;

    private ObservableList<ScheduleModel> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String sql_validate = "select * from schedule;";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_validate);
            while (resultSet.next()){
                ScheduleModel modelTable = new ScheduleModel(
                        resultSet.getString("time"),
                        resultSet.getString("mon"),
                        resultSet.getString("tue"),
                        resultSet.getString("wed"),
                        resultSet.getString("thu"),
                        resultSet.getString("fri"),
                        resultSet.getString("sat"),
                        resultSet.getString("sun")
                );
                this.observableList.add(modelTable);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                System.out.println(e);
            }
        }

        setCellValue();
        this.table.setItems(observableList);
    }

    private void setCellValue() {
        this.time.setCellValueFactory(new PropertyValueFactory<>("TIME"));
        this.mon.setCellValueFactory(new PropertyValueFactory<>("MON"));
        this.tue.setCellValueFactory(new PropertyValueFactory<>("TUE"));
        this.wed.setCellValueFactory(new PropertyValueFactory<>("WED"));
        this.thu.setCellValueFactory(new PropertyValueFactory<>("THU"));
        this.fri.setCellValueFactory(new PropertyValueFactory<>("FRI"));
        this.sat.setCellValueFactory(new PropertyValueFactory<>("SAT"));
        this.sun.setCellValueFactory(new PropertyValueFactory<>("SUN"));
    }
}
