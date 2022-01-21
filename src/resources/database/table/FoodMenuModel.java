package resources.database.table;

public class FoodMenuModel {
    /**
     * Food Type/ Category, Name, Recipes, Description
     */
    private String type, name, recipes, description;
    /**
     * Food Cost
     */
    private double cost;

    /**
     * FoodMenuModel Constructor
     * @param type type | category
     * @param name name
     * @param recipes recipes
     * @param cost cost
     * @param description description
     */
    public FoodMenuModel(String type, String name, String recipes, double cost, String description) {
        this.type = type;
        this.name = name;
        this.recipes = recipes;
        this.cost = cost;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipes() {
        return recipes;
    }

    public void setRecipes(String recipes) {
        this.recipes = recipes;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
