package resources.controllers;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.Main;
import resources.database.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Handles Login actions and events
 */
public class Login implements Initializable {

    /**
     * Use to get and set mouse location on screen for draggin application
     */
    private double xOffset,yOffset = 0;

    /**
     * Message Label for validate login credentials
     */
    @FXML
    private Label LoginMessageLabel;

    /**
     * Application Title Bar
     */
    @FXML
    private HBox TitleBar;

    /**
     * Password Field
     */
    @FXML
    private PasswordField PasswordTextField;

    /**
     * Username Field
     */
    @FXML
    private TextField UsernameTextField;

    /**
     * Close the program on mouseClickEvent
     * @param event close button click
     */
    @FXML
    void Close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Maximize the program on mouseClickEvent
     * @param event maximize button click
     */
    @FXML
    void Maximize(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setFullScreen(true);
    }

    /**
     * Minimize the program on mouseClickEvent
     * @param event minimize button click
     */
    @FXML
    void Minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    /**
     * Responsible for Draggable Title Bar with mouse event
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TitleBar.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        TitleBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Main.MainStage.setX(event.getScreenX() - xOffset);
                Main.MainStage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    /**
     * Clear username and password field inputs
     * @param event cancel button click
     */
    @FXML
    void Cancel(MouseEvent event) {
        UsernameTextField.clear();
        PasswordTextField.clear();
    }

    /**
     * Validate logIn credentials in database
     * @param event login button click
     */
    @FXML
    void LoginRequest(MouseEvent event) throws SQLException, IOException {
        if (UsernameTextField.getLength() > 0 && PasswordTextField.getLength() > 0)
            ValidateLogin(event);
        else if (UsernameTextField.getLength() == 0 && PasswordTextField.getLength() > 0)
            LoginMessageLabel.setText("Please enter Username");
        else if (UsernameTextField.getLength() > 0 && PasswordTextField.getLength() == 0)
            LoginMessageLabel.setText("Please enter passcode");
        else
            LoginMessageLabel.setText("Please enter username and passcode");
    }

    /**
     * Calls login button on click when pressed enter
     * @param event
     */
    @FXML
    void PasswordTextField_KeyPressed(KeyEvent event) {
//        LoginRequest(MouseEvent event);
    }

    /**
     * Login credential validation method
     * @param event login on mouse click
     */
    private void ValidateLogin(MouseEvent event) throws SQLException, IOException {
        String username, password;
        username = UsernameTextField.getText();
        password = PasswordTextField.getText();
        System.out.println("Username: " + username + ", Password: " + password);

        Connection connection = DatabaseConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee where username = '" + username + "' and passcode = '" + password + "'");

        if (resultSet.next()){

            Main.loadDashboard(event, "user");
        } else {
            LoginMessageLabel.setText("Login failed!");
        }
    }



}