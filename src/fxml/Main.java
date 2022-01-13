package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED); //Borderless

        stage = primaryStage;
        primaryStage.show();
    }

    public static void createDashboard(){
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("Dashboard.fxml"));
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.initStyle(StageStyle.UNDECORATED);
            Main.stage = dashboardStage;
            dashboardStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
