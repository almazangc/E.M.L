module Employee.Management.System {

    /**
     * JAVAFX JARS
     */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens resources.css;
    opens resources.controllers;
    opens resources.controllers.dashboardTab;
    opens resources.fxml;
    opens resources;
}