module Employee.Management.System {

    /**
     * JAVAFX JARS
     */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens css;
    opens controllers;
    opens controllers.dashboardTab;
    opens fxml;
}