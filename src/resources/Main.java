package resources;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resources.controllers.Dashboard;
import resources.modules.global_variable;

import java.io.IOException;
import java.util.Objects;

/**
 * Employee restaurant manager
 * @author Gilbert Almazan
 *
 */
public class Main extends Application {
    /**
     * Stage declaration for passing non static stage
     */
    public static Stage MainStage;

    /**
     * ConsoleLogger Stage
     */
    public static Stage ConsoleLog;

    /**
     * Stage declaration for passing non static stage for dashboard
     */
    public static Stage DashboardStage;

    /**
     * Stage declaration
     */
    private static Stage stage;
    /**
     * Scene declaration
     */
    private static Scene scene;
    /**
     * Parent declaration
     */
    private static Parent root;
    /**
     * Instance of global_variable class
     */
    public static global_variable AccountInfo;

    /**
     * Type of dashboard displayed depending on account type
     */
    public static int dashboardType;

    /**
     * Start up program
     * @param primaryStage stage to be loaded
     * @throws Exception in case of some error
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/Login.fxml")));
        scene = new Scene(root, Color.TRANSPARENT); //changes
        primaryStage.setScene(scene); // new Scene(root)
        primaryStage.initStyle(StageStyle.TRANSPARENT); //Borderless
        MainStage = primaryStage;

        Parent consoleRoot = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/ConsoleLog.fxml")));
        Scene consoleScene = new Scene(consoleRoot, Color.TRANSPARENT);
        Stage consoleStage = new Stage();
        consoleStage.setScene(consoleScene);
        consoleStage.initStyle(StageStyle.TRANSPARENT);
        ConsoleLog = consoleStage;
        consoleStage.show();
        primaryStage.show();
    }

    /**
     * Loads a dashboard depending on what type of account is logged in
     * @param event on mouse click login button
     * @param type type of dashboard loaded
     */
    public static void loadDashboard(MouseEvent event, int type) {
        try {
            if (type == 0)
                root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/DashboardUser.fxml")));
            else if (type == 1)
                root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/DashboardAdmin.fxml")));

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, Color.TRANSPARENT);
            stage.setScene(scene);
            DashboardStage = stage;
            dashboardType = type;
            Dashboard.setDefault();
            stage.show();
        } catch (Exception e){
            e.getCause();
        }
    }

    /**
     * Loads login form when logout button is clicked
     * @param event on mouse click
     */
    public static void logOut(MouseEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/Login.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, Color.TRANSPARENT);
            stage.setScene(scene);
            Main.DashboardStage = stage;
            stage.show();
        } catch (Exception e){
            e.getCause();
        }
    }

    /**
     * Loads a selected a tab on a dashboard
     * @param fileName fxml being loaded on boarder pane center of a dashboard
     * @param borderPane reference for dashboard border pane to set fxml on center
     */
    public static void loadUI(String fileName, BorderPane borderPane){
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/dashboardTab/" + fileName + ".fxml"));
            //Here the value should be set from database before showing
            root = loader.load();
        } catch (IOException e) {
            e.getCause();
        }
        borderPane.setCenter(root);
    }

    /**
     * Launch program at start
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
