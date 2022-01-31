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
    /**
     * JFOENIX STYLE
     */
    requires com.jfoenix;

    opens resources;
    opens resources.fxml;
    opens resources.modules;
    opens resources.css;
    opens resources.database;
    opens resources.database.table;
    opens resources.controllers;
    opens resources.controllers.dashboardTab;
    opens resources.controllers.dashboardTab.dialogBox.employeeList;
    opens resources.controllers.dashboardTab.dialogBox.foodMenu;
    opens resources.controllers.dashboardTab.dialogBox.inventory;
    opens resources.controllers.dashboardTab.dialogBox.schedule;
}