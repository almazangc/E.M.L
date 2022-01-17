package resources.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Handles dashboard actions and events
 */
public class Dashboard implements Initializable {

    /**
     * Variable for storing mouse x and y coordinate on the monitor
     */
    private double xOffset,yOffset = 0;

    /**
     * Border pane of dashboard
     */
    @FXML
    private BorderPane dashboard_BorderPane;


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
//        String defaultTab = (Main.dashboardType == 0 ? "EmployeeProfile" : "EmployeeList");
//        Main.loadUI(defaultTab , dashboard_BorderPane);
        TitleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        TitleBar.setOnMouseDragged(event -> {
            Main.DashboardStage.setX(event.getScreenX() - xOffset);
            Main.DashboardStage.setY(event.getScreenY() - yOffset);
        });
    }

    /**
     * MenuList Button
     */
    @FXML
    private ImageView MenuList;

    /**
     * Show and hides navigation tab
     */
    @FXML
    void MenuList_onAction() {
        System.out.println("EVENT: NAV BAR");
    }

    /**
     * Loads profile fxml in user dashboard
     */
    @FXML
    void profileOnClick() {
        System.out.println("EVENT: Profile");
        Main.loadUI("EmployeeProfile" , dashboard_BorderPane);
    }

    /**
     * Loads employeeList fxml on admin dashboard
     */
    @FXML
    void employeeListOnClick() {
        System.out.println("EVENT: Employee List");
        Main.loadUI("EmployeeList" , dashboard_BorderPane);
    }

    /**
     * Loads schedule fxml on user and admin dashboard
     */
    @FXML
    void scheduleOnClick() {
        System.out.println("EVENT: Schedule");
        Main.loadUI("Schedule" , dashboard_BorderPane);
    }

    /**
     * Loads comments and rating fxml on user dashboard
     */
    @FXML
    void comments_ratingOnCLick() {
        System.out.println("EVENT: Comments and Rating");
        Main.loadUI("CommentsRating" , dashboard_BorderPane);
    }

    /**
     * Loads inventory  fxml on admin dashboard
     */
    @FXML
    void inventoryOnClick() {
        System.out.println("EVENT: Inventory");
        Main.loadUI("Inventory" , dashboard_BorderPane);
    }

    /**
     * Loads food menu on admin dashboard
     */
    @FXML
    void foodMenuOnClick() {
        System.out.println("EVENT: Food Menu");
        Main.loadUI("FoodMenuList" , dashboard_BorderPane);
    }

    /**
     * Loads manage database fxml on admin dashboard
     */
    @FXML
    void manageDbOnClick() {
        System.out.println("EVENT: DB management");
        Main.loadUI("ManageDatabase" , dashboard_BorderPane);
    }

    /**
     * Load setting fxml on admin dashboard
     */
    @FXML
    void settingOnClick() {
        System.out.println("EVENT: Settings");
        Main.loadUI("Settings" , dashboard_BorderPane);
    }

    /**
     * Logout user from dashboard
     * @param event on mouse click
     */
    @FXML
    void logoutOnClick(MouseEvent event) {
        //No prompt message
        System.out.println("Logged out");
        Main.logOut(event);
    }
}
