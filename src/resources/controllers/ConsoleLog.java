package resources.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsoleLog implements Initializable {
    /**
     * Mouse Coordinates
     */
    double xOffset, yOffset;

    /**
     * Console Log Title Bar
     */
    @FXML
    private HBox TitleBar;

    /**
     * TextArea where logs is printed
     */
    @FXML
    public TextArea consoleLogText;

    /**
     * Static consoleLogText referenced to consoleLogText
     */
    public static TextArea consoleLog = new TextArea();

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
        consoleLog = consoleLogText;
        TitleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        TitleBar.setOnMouseDragged(event -> {
            Main.ConsoleLog.setX(event.getScreenX() - xOffset);
            Main.ConsoleLog.setY(event.getScreenY() - yOffset);
        });
    }

    public static void setConsoleLog(String Log){
        consoleLog.setText(consoleLog.getText() + Log);
    }
}
