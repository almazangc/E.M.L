package resources.controllers;

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
import resources.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

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

    /**
     * Loads profile fxml in user dashboard
     * @param event on mouse click
     */
    @FXML
    void profileOnClick(MouseEvent event) {
        System.out.println("EVENT: Profile");
        Main.loadUI("EmployeeProfile" , dashboard_BorderPane);
    }

    /**
     * Loads employeeList fxml on admin dashboard
     * @param event on mouse click
     */
    @FXML
    void employeeListOnClick(MouseEvent event) {
        System.out.println("EVENT: Employee List");
        Main.loadUI("EmployeeList" , dashboard_BorderPane);
    }

    /**
     * Loads schedule fxml on user and admin dashboard
     * @param event on mouse click
     */
    @FXML
    void scheduleOnClick(MouseEvent event) {
        System.out.println("EVENT: Schedule");
        Main.loadUI("Schedule" , dashboard_BorderPane);
    }

    /**
     * Loads comments and rating fxml on user dashboard
     * @param event on mouse click
     */
    @FXML
    void comments_ratingOnCLick(MouseEvent event) {
        System.out.println("EVENT: Comments and Rating");
        Main.loadUI("CommentsRating" , dashboard_BorderPane);
    }

    /**
     * Loads inventory  fxml on admin dashboard
     * @param event on mouse click
     */
    @FXML
    void inventoryOnClick(MouseEvent event) {
        System.out.println("EVENT: Inventory");
        Main.loadUI("Inventory" , dashboard_BorderPane);
    }

    /**
     * Loads food menu on admin dashboard
     * @param event on mouse click
     */
    @FXML
    void foodMenuOnClick(MouseEvent event) {
        System.out.println("EVENT: Food Menu");
        Main.loadUI("FoodMenuList" , dashboard_BorderPane);
    }

    /**
     * Loads manage database fxml on admin dashboard
     * @param event on mouse click
     */
    @FXML
    void manageDbOnClick(MouseEvent event) {
        System.out.println("EVENT: DB management");
        Main.loadUI("ManageDatabase" , dashboard_BorderPane);
    }

    /**
     * Load setting fxml on admin dashboard
     * @param event on mouse click
     */
    @FXML
    void settingOnClick(MouseEvent event) {
        System.out.println("EVENT: Settings");
        Main.loadUI("Settings" , dashboard_BorderPane);
    }

    /**
     * Logout user from dashboard
     * @param event on mouse click
     */
    @FXML
    void logoutOnClick(MouseEvent event) throws IOException {
        //No prompt message
        System.out.println("Logged out");
        Main.logOut(event);
    }
}
