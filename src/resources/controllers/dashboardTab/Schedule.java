package resources.controllers.dashboardTab;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resources.Main;
import resources.database.DatabaseConnection;
import resources.database.table.ScheduleModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Manages and Modify weekly schedule of employee
 */
public class Schedule implements Initializable {
    /**
     * Table
     */
    @FXML
    private TableView<ScheduleModel> table;
    /**
     * Time
     */
    @FXML
    private TableColumn<ScheduleModel, String> time;
    /**
     * Days of the week
     */
    @FXML
    private TableColumn<ScheduleModel, String> mon, tue, wed, thu, fri, sat, sun;

    @FXML
    private JFXButton editSchedule;

    @FXML
    private JFXButton newSchedule;
    /**
     * objList
     */
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

    /**
     * Set cell factory values
     */
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

    public static Stage newStage;

    @FXML
    void editSchedule() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/dashboardTab/dialogBox/schedule/Edit.fxml")));
        Scene scene = new Scene(root, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        newStage = stage;
        stage.show();
    }

    @FXML
    void newSchedule() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/dashboardTab/dialogBox/schedule/New.fxml")));
        Scene scene = new Scene(root, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        newStage = stage;
        stage.show();
    }

}
