module Employee.Management.System {

    /**
     * JAVAFX JARS
     */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    /**
     * SQL DATABASE REQUIREMENT
     */
    requires mysql.connector.java;
    requires java.sql;

    opens fxml;
    opens css;
    opens databaseConnection;
    opens controllers;
}