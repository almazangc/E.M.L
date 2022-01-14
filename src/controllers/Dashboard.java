package controllers;

import fxml.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    private double xOffset,yOffset = 0;

    @FXML
    private BorderPane borderPane;

    /**
     * Application Title Bar
     */
    @FXML
    private HBox TitleBar;

    /**
     * Fullscreen Button
     */
    @FXML
    private Button MinMaxButton;

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
        if (stage.isFullScreen())
            MinMaxButton.setText("\uF032");
        else
            MinMaxButton.setText("\uF031");
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
                Main.DashboardStage.setX(event.getScreenX() - xOffset);
                Main.DashboardStage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    /**
     * MenuList Button
     */
    @FXML
    private ImageView MenuList;

    /**
     * Show and hides navigation tab
     * @param event onAction
     */
    @FXML
    void MenuList_onAction(MouseEvent event) {
        System.out.println("EVENT: NAV BAR");
    }

    @FXML
    void profileOnClick(MouseEvent event) {
        System.out.println("EVENT: Profile");
    }

    @FXML
    void employeeListOnClick(MouseEvent event) {
        System.out.println("EVENT: Employee List");
    }

    @FXML
    void scheduleOnClick(MouseEvent event) {
        System.out.println("EVENT: Schedule");
    }

    @FXML
    void comments_ratingOnCLick(MouseEvent event) {
        System.out.println("EVENT: Comments and Rating");
    }
    @FXML
    void inventoryOnClick(MouseEvent event) {
        System.out.println("EVENT: Inventory");
    }

    @FXML
    void foodMenuOnClick(MouseEvent event) {
        System.out.println("EVENT: Food Menu");
    }

    @FXML
    void manageDbOnClick(MouseEvent event) {
        System.out.println("EVENT: DB management");
    }

    @FXML
    void settingOnClick(MouseEvent event) {
        System.out.println("EVENT: Settings");
    }

    @FXML
    void logoutOnClick(MouseEvent event) {
        //No prompt message
        System.out.println("Close app");
        Close(event);
    }

    private void loadUI (String fxmlName){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/dashboardTab/" + fxmlName + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(root);
    }
}
