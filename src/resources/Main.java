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
import resources.controllers.Dashboard;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {

    public static Stage MainStage;
    public static Stage DashboardStage;

    private static Stage stage;
    private static Scene scene;
    private static Parent root;

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
     * @param fileName file name of fxml being loaded on boarder pane center of a dashboard
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
    public static void main(String[] args) {
        launch(args);
    }
}
