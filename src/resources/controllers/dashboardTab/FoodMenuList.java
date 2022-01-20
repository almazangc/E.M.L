package resources.controllers.dashboardTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import resources.database.DatabaseConnection;
import resources.database.table.FoodMenuModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Display and Modify Food menu list being served in the restaurant
 */
public class FoodMenuList implements Initializable {


    @FXML
    private TableView<FoodMenuModel> table;

    @FXML
    private TableColumn<FoodMenuModel, String> name;

    @FXML
    private TableColumn<FoodMenuModel, String> type;

    @FXML
    private TableColumn<FoodMenuModel, String> recipes;

    @FXML
    private TableColumn<FoodMenuModel, String> cost;

    @FXML
    private TableColumn<FoodMenuModel, String> description;

    private ObservableList<FoodMenuModel> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String sql_validate = "SELECT * from food_menu";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_validate);
            while (resultSet.next()){
                FoodMenuModel modelTable = new FoodMenuModel(
                        resultSet.getString("type"),
                        resultSet.getString("name"),
                        resultSet.getString("recipes"),
                        resultSet.getDouble("cost"),
                        resultSet.getString("description"));

                this.observableList.add(modelTable);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                System.out.println(e);
            }
        }

        setCellValue();
        this.table.setItems(observableList);
    }

    private void setCellValue() {
        this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.type.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.recipes.setCellValueFactory(new PropertyValueFactory<>("recipes"));
        this.cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        this.description.setCellValueFactory(new PropertyValueFactory<>("description"));
    }
}
