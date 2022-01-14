module Employee.Management.System {

    /**
     * JAVAFX JARS
     */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens fxml;
    opens css;
    opens controllers;
}