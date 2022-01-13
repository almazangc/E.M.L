module Employee.Management.System {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires mysql.connector.java;
    requires java.sql;

    opens fxml;
    opens css;
    opens databaseConnection;
    opens controllers;
}