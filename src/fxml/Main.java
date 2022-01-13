package fxml;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    public static Stage MainStage;
    public static Stage DashboardStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED); //Borderless

        MainStage = primaryStage;
        primaryStage.show();
    }

    public static void createAdminDashboard(){
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("DashboardAdmin.fxml"));
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.initStyle(StageStyle.UNDECORATED);
            Main.DashboardStage = dashboardStage;
            dashboardStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public static void createUserDashboard(){
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("DashboardUser.fxml"));
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.initStyle(StageStyle.UNDECORATED);
            Main.DashboardStage = dashboardStage;
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
