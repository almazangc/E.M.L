package resources.controllers.dashboardTab;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import resources.Main;
import resources.modules.global_variable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Display information about the employee
 * Job comments and suggestion
 * Along with its rating for doing well on assign job
 * Which later can be used to make evaluation who will be the employee of the month
 */
public class Evaluation implements Initializable {
    /**
     * Rating
     */
    @FXML
    private Label rating;
    /**
     * Comment
     */
    @FXML
    private Label comment;
    /**
     * Suggestion
     */
    @FXML
    private Label suggestion;
    /**
     * Reference address pointer for logged accountInfo
     */
    private global_variable evaluation;

    /**
     * Setter for values as initialization
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        evaluation = Main.AccountInfo;
        this.rating.setText(Integer.toString(evaluation.getRating()));
        this.comment.setText(evaluation.getComments());
        this.suggestion.setText(evaluation.getSuggestion());
    }
}
