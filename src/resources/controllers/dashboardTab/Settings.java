package resources.controllers.dashboardTab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resources.Main;
import resources.modules.global_variable;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Display and Modify User Authentication
 * Such as Username and password change
 */
public class Settings implements Initializable {
    @FXML
    private Label age;

    @FXML
    private Label barangay;

    @FXML
    private Label birthdate;

    @FXML
    private Label municipality;

    @FXML
    private Label province;

    @FXML
    private Label sex;

    @FXML
    private Label fullName;

    private static global_variable accountDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountDetails = Main.AccountInfo;

        this.fullName.setText(accountDetails.getCompleteName());

        this.age.setText(Integer.toString(accountDetails.getAge()));
        this.birthdate.setText(accountDetails.getBirthdate());
        this.sex.setText(accountDetails.getSex());

        this.barangay.setText(accountDetails.getBarangay());
        this.municipality.setText(accountDetails.getMunicipality());
        this.province.setText(accountDetails.getProvince());
    }

    public static Stage newStage;

    @FXML
    void changePasscode() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/dashboardTab/dialogBox/ChangePasscode.fxml")));
        Scene scene = new Scene(root, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        newStage = stage;
        stage.show();
    }
}
