package resources.controllers.dashboardTab;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import resources.Main;
import resources.controllers.ConsoleLog;
import resources.modules.global_variable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Displays information about the logged in employee
 */
public class EmployeeProfile implements Initializable {
    /**
     * Age
     */
    @FXML
    private Label age;
    /**
     * Barangay
     */
    @FXML
    private Label barangay;
    /**
     * Birthdate
     */
    @FXML
    private Label birthdate;
    /**
     * First name
     */
    @FXML
    private Label firstname;
    /**
     * Last name
     */
    @FXML
    private Label lastname;
    /**
     * Middle initial
     */
    @FXML
    private Label middleInitial;
    /**
     * Municipality
     */
    @FXML
    private Label municipality;
    /**
     * Position
     */
    @FXML
    private Label position;
    /**
     * Postal Code
     */
    @FXML
    private Label postalCode;
    /**
     * ProfilePhoto
     */
    @FXML
    private ImageView profilePhoto;
    /**
     * Province
     */
    @FXML
    private Label province;
    /**
     * Sex
     */
    @FXML
    private Label sex;
    /**
     * Reference address pointer for logged accountInfo
     */
    private static global_variable accountDetails;

    /**
     * Setter for values as initialization
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ConsoleLog.setConsoleLog("\nEmployeeModel Profile: Initialize Method");

        accountDetails = Main.AccountInfo;

        this.firstname.setText(accountDetails.getFirstName());
        this.middleInitial.setText(accountDetails.getMiddleInitial());
        this.lastname.setText(accountDetails.getLastName());

        this.age.setText(Integer.toString(accountDetails.getAge()));
        this.birthdate.setText(accountDetails.getBirthdate());
        this.sex.setText(accountDetails.getSex());

        this.position.setText(accountDetails.getJobPosition());

        this.barangay.setText(accountDetails.getBarangay());
        this.municipality.setText(accountDetails.getMunicipality());
        this.province.setText(accountDetails.getProvince());
        this.postalCode.setText(Integer.toString(accountDetails.getPostalCode()));

        ConsoleLog.setConsoleLog("\nEmployeeModel Profile: Initialized Complete");
    }
}

