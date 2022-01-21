package resources.controllers.dashboardTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import resources.database.DatabaseConnection;
import resources.database.table.EmployeeModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Manages employee list information
 * Add or remove employee
 * Rate and Write comments and suggestion
 */
public class ManageDatabase implements Initializable {
    /**
     * Table
     */
    @FXML
    private TableView<EmployeeModel> table;
    /**
     * ID, Name, Job Position, Min_Wage, Rating, Comment, Suggestion
     */
    @FXML
    private TableColumn<EmployeeModel, String> id, name, position, min_wage, rating, comment, suggestion;

    /**
     * observableList arraylist
     */
    private ObservableList<EmployeeModel> observableList = FXCollections.observableArrayList();

    /**
     * Init
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String sql_validate = "select * from employee";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_validate);
            while (resultSet.next()){
                EmployeeModel modelTable = new EmployeeModel(
                        (resultSet.getString("firstname") + " " + resultSet.getString("middleinitial") + " " + resultSet.getString("lastname")),
                        resultSet.getString("position"),
                        resultSet.getString("comment"),
                        resultSet.getString("suggestion"),
                        resultSet.getInt("id"),
                        resultSet.getInt("min_wage"),
                        resultSet.getInt("rating"));

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
        this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.position.setCellValueFactory(new PropertyValueFactory<>("position"));
        this.comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        this.suggestion.setCellValueFactory(new PropertyValueFactory<>("suggestion"));
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.min_wage.setCellValueFactory(new PropertyValueFactory<>("min_wage"));
        this.rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
    }
}



