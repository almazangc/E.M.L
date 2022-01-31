package resources.controllers.dashboardTab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resources.Main;
import resources.controllers.ConsoleLog;
import resources.database.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Displays Information about all employee of the restaurant
 */
public class EmployeeList implements Initializable {
    /**
     * Barangay
     */
    @FXML
    private Label barangay;
    /**
     * Birthdate
     */
    @FXML
    private Label birthdate;
    /**
     * Comment
     */
    @FXML
    private Label comment;
    /**
     * Modify the contents
     */
    @FXML
    private Button edit;
    /**
     * Firstname
     */
    @FXML
    private Label firstname;
    /**
     * ID
     */
    @FXML
    private TextField id;
    /**
     * Lastname
     */
    @FXML
    private Label lastname;
    /**
     * Middle Initial
     */
    @FXML
    private Label middleInitial;
    /**
     * Municipality
     */
    @FXML
    private Label municipality;
    /**
     * Job Position
     */
    @FXML
    private Label position;
    /**
     * Province
     */
    @FXML
    private Label province;
    /**
     * Rating
     */
    @FXML
    private Label rating;
    /**
     * Save Current Edit
     */
    @FXML
    private Label sex;
    /**
     * Suggestion
     */
    @FXML
    private Label suggestion;

    /**
     * Setter for values as initialization
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ConsoleLog.setConsoleLog("\nEmployeeModel ProfileList: Initialize Method");

        updateList();

        ConsoleLog.setConsoleLog("\nEmployeeModel ProfileList: Initialized Complete");
    }

    /**
     * Traverse back by -1 Current ID and display the account details
     */
    @FXML
    void backOnClick() {
        if (Integer.parseInt(id.getText()) > 1) {
            id.setText(Integer.toString(Integer.parseInt(id.getText()) - 1));
            updateList();
        }
    }


    /**
     * Traverse forward by +1 Current ID and display the account details
     */
    @FXML
    void nextOnClick() {
        if (Integer.parseInt(id.getText()) < Main.AccountInfo.getIdCount()) {
            id.setText(Integer.toString(Integer.parseInt(id.getText()) + 1));
            updateList();
        }
    }

    /**
     * Handles Display and populating Database
     */
    private void updateList(){
        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement;
        ResultSet resultSet;
        String sql_validate = "select * from employee where id = '" + id.getText() + "'";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_validate);
            while (resultSet.next()){
                this.firstname.setText(resultSet.getString("firstName"));
                this.middleInitial.setText(resultSet.getString("middleInitial"));
                this.lastname.setText(resultSet.getString("lastName"));

                this.birthdate.setText(resultSet.getString("birthdate"));
                this.sex.setText(resultSet.getString("sex"));

                this.rating.setText(resultSet.getString("rating"));
                this.comment.setText(resultSet.getString("comment"));
                this.suggestion.setText(resultSet.getString("suggestion"));

                this.position.setText(resultSet.getString("position"));

                this.barangay.setText(resultSet.getString("addr_brgy"));
                this.municipality.setText(resultSet.getString("addr_municipality"));
                this.province.setText(resultSet.getString("addr_province"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }

    public static Stage newStage;

    /**
     * Load Edit FXML and initialize contents
     */
    @FXML
    void editOnClick() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/dashboardTab/dialogBox/employeeList/Evaluate.fxml")));
        Scene scene = new Scene(root, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        newStage = stage;
        stage.show();
    }
}
