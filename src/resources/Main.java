package resources;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
     * Start up program
     * @param primaryStage stage to be loaded
     * @throws Exception in case of some error
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/Login.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED); //Borderless

        MainStage = primaryStage;
        primaryStage.show();
    }

    /**
     * load a dashboard depending on what type of account is logged in
     * @param event on mouse click login button
     * @param type type of dashboard loaded
     * @throws IOException errors
     */
    public static void loadDashboard(MouseEvent event, String type) throws IOException{
        try {
            if (type.equals("admin"))
                root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/DashboardAdmin.fxml")));
            else if (type.equals("user"))
                root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/DashboardUser.fxml")));

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            Main.DashboardStage = stage;
            stage.show();
        } catch (Exception e){
            e.getCause();
        }
    }

    /**
     * Loads login form when logout button is clicked
     * @param event on mouse click
     * @throws IOException errors
     */
    public static void logOut(MouseEvent event) throws IOException{
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/Login.fxml")));

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
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
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/dashboardTab/" + fileName + ".fxml")));
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
