package resources.controllers.dashboardTab;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import resources.Main;
import resources.modules.global_variable;

import java.net.URL;
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

    private void ChangePassword(){

    }
}
