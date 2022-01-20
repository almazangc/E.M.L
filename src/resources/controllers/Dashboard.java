package resources.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.Main;

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
     * Static borderPane for dashboard_BorderPane
     */
    private static BorderPane borderPane;

    /**
     * Program Title Bar
     */
    @FXML
    private HBox TitleBar;

    /**
     * Fullscreen Button
     */
    @FXML
    private Button MinMaxButton;

    /**
     * Greet Logged Account by Firstname
     */
    @FXML
    private Label greetFirstName;

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
        borderPane = dashboard_BorderPane; //initializing borderPane
        greetFirstName.setText(Main.AccountInfo.getFirstName());
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
        ConsoleLog.setConsoleLog("\nClicked: Navigation Bar....");
    }

    /**
     * Loads profile fxml in user dashboard
     */
    @FXML
    void employeeProfileOnClick() {
        ConsoleLog.setConsoleLog("\nLoaded: Employee Profile....");
        Main.loadUI("EmployeeProfile" , dashboard_BorderPane);
    }

    /**
     * Loads employeeList fxml on admin dashboard
     */
    @FXML
    void employeeListOnClick() {
        ConsoleLog.setConsoleLog("\nLoaded: Employee List....");
        Main.loadUI("EmployeeList" , dashboard_BorderPane);
    }

    /**
     * Loads schedule fxml on admin dashboard
     */
    @FXML
    void scheduleOnClickAdmin() {
        ConsoleLog.setConsoleLog("\nLoaded: Schedule....");
        Main.loadUI("ScheduleAdmin" , dashboard_BorderPane);
    }

    /**
     * Loads schedule fxml on user dashboard
     */
    @FXML
    void scheduleOnClickUser() {
        ConsoleLog.setConsoleLog("\nLoaded: Schedule....");
        Main.loadUI("ScheduleUser" , dashboard_BorderPane);
    }

    /**
     * Loads comments and rating fxml on user dashboard
     */
    @FXML
    void comments_ratingOnCLick() {
        ConsoleLog.setConsoleLog("\nLoaded: Employee Evaluation....");
        Main.loadUI("CommentsRating" , dashboard_BorderPane);
    }

    /**
     * Loads inventory  fxml on admin dashboard
     */
    @FXML
    void inventoryOnClick() {
        ConsoleLog.setConsoleLog("\nLoaded: Inventory....");
        Main.loadUI("Inventory" , dashboard_BorderPane);
    }

    /**
     * Loads food menu on admin dashboard
     */
    @FXML
    void foodMenuOnClick() {
        ConsoleLog.setConsoleLog("\nLoaded: Food Menu List....");
        Main.loadUI("FoodMenuList" , dashboard_BorderPane);
    }

    /**
     * Loads manage database fxml on admin dashboard
     */
    @FXML
    void manageDbOnClick() {
        ConsoleLog.setConsoleLog("\nLoaded: Manage Employee Database....");
        Main.loadUI("ManageDatabase" , dashboard_BorderPane);
    }

    /**
     * Load setting fxml on admin dashboard
     */
    @FXML
    void settingOnClick() {
        ConsoleLog.setConsoleLog("\nLoaded: Settings....");
        Main.loadUI("Settings" , dashboard_BorderPane);
    }

    /**
     * Logout user from dashboard
     * @param event on mouse click
     */
    @FXML
    void logoutOnClick(MouseEvent event) {
        ConsoleLog.setConsoleLog("\nDashboard: Log out....");
        Main.logOut(event);
    }

    /**
     * Set Default Tab of Dashboard
     */
    public static void setDefault(){
//        Intializable is not working as expected
          ConsoleLog.setConsoleLog("\nDefault Dashboard Tab: Need fix....");
//        Main.loadUI((Main.dashboardType == 0 ? "EmployeeProfile" : "EmployeeList") , borderPane);
    }
}
