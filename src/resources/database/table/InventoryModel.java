package resources.database.table;

public class InventoryModel {
    private double amount, cost;
    private String name, type, description;

    public InventoryModel(double amount, double cost, String name, String type, String description) {
        this.amount = amount;
        this.cost = cost;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
