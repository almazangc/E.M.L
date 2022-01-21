/**
 * Program Module Requirement in order to Run without errors
 */
module Employee.Management.System {

    /**
     * JAVAFX JARS
     */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    /**
     * Sql lite jdbc
     */
    requires java.sql;

    requires com.jfoenix;

    opens resources;
    opens resources.controllers;
    opens resources.controllers.dashboardTab;
    opens resources.fxml;
    opens resources.modules;
    opens resources.database;
    opens resources.database.table;
    opens resources.css;

}