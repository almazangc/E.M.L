package controllers;

import fxml.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
                Main.stage.setX(event.getScreenX() - xOffset);
                Main.stage.setY(event.getScreenY() - yOffset);
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
            LoginMessageLabel.setText("Password Validation, Login Successful");
            ValidateLogin();
        } else if (UsernameTextField.getLength() == 0 && PasswordTextField.getLength() > 0)
            LoginMessageLabel.setText("Enter Username");
        else if (UsernameTextField.getLength() > 0 && PasswordTextField.getLength() == 0)
            LoginMessageLabel.setText("Enter password");
        else
            LoginMessageLabel.setText("U tried to magik???");
    }

    /**
     * User password and username input validation
     */
    public void ValidateLogin(){
        System.out.println("Username: " + UsernameTextField.getText() + ", Password: " + PasswordTextField.getText());
        try {
            if(true)
                createDashboard();
            else
                System.out.println("Account not found, password invalid");
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Loads DashboardForm
     */
    public void createDashboard(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/Dashboard.fxml"));
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.initStyle(StageStyle.UNDECORATED);
            Main.stage = dashboardStage;
            dashboardStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}