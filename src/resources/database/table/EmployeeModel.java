package resources.database.table;

public class EmployeeModel {
    /**
     * ID, Min_wage, rating
     */
    private int id, min_wage, rating;
    /**
     * Name, Position, Comment, Suggestion
     */
    private String name, position, comment, suggestion;

    /**
     * EmployeeModel Constructor
     * @param name name
     * @param position position
     * @param comment comment
     * @param suggestion suggestion
     * @param id id
     * @param min_wage min wage
     * @param rating rating
     */
    public EmployeeModel(String name, String position, String comment, String suggestion, int id, int min_wage, int rating) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.comment = comment;
        this.suggestion = suggestion;
        this.rating = rating;
        this.min_wage = min_wage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public int getMin_wage() {
        return min_wage;
    }

    public void setMin_wage(int min_wage) {
        this.min_wage = min_wage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
