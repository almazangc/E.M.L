package resources.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controls and Manage Login Scene
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
    void LoginRequest(MouseEvent event){
        if (UsernameTextField.getLength() > 0 && PasswordTextField.getLength() > 0) {
            ValidateLogin(event);
        } else if (UsernameTextField.getLength() == 0 && PasswordTextField.getLength() > 0)
            LoginMessageLabel.setText("Please enter Username");
        else if (UsernameTextField.getLength() > 0 && PasswordTextField.getLength() == 0)
            LoginMessageLabel.setText("Please enter passcode");
        else
            LoginMessageLabel.setText("Please enter username and passcode");
    }

    /**
     * Account Validation
     */
    public void ValidateLogin(MouseEvent event) {
        System.out.println("Username: " + UsernameTextField.getText() + ", Password: " + PasswordTextField.getText());
        String username = UsernameTextField.getText();
        String password = PasswordTextField.getText();
        try {
            if(username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
                LoginMessageLabel.setText("Admin Login Successful");
                Main.loadDashboard(event, "admin");
            } else if (username.toLowerCase().equals("user") && password.toLowerCase().equals("user")) {
                LoginMessageLabel.setText("User Login Successful");
                Main.loadDashboard(event, "user");
            } else
                LoginMessageLabel.setText("Account not found, password invalid");
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}