package resources.controllers.dashboardTab.dialogBox.schedule;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.controllers.dashboardTab.Inventory;
import resources.controllers.dashboardTab.Schedule;

import java.net.URL;
import java.util.ResourceBundle;

public class New   implements Initializable {

    /**
     * Use to get and set mouse location on screen for dragging application
     */
    private double xOffset,yOffset = 0;

    /**
     * Program Title Bar
     */
    @FXML
    private HBox TitleBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TitleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        TitleBar.setOnMouseDragged(event -> {
            Schedule.newStage.setX(event.getScreenX() - xOffset);
            Schedule.newStage.setY(event.getScreenY() - yOffset);
        });
    }

    /**
     * Close the program on mouseClickEvent
     * @param event close button click
     */
    @FXML
    void Close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
