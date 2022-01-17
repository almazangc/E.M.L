package resources.modules;

import resources.database.DatabaseConnection;

import java.sql.*;

/**
 * Class Containing Recently Logged Account
 */
public class global_variable {
    private int id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private Blob profileImage;
    private int accountType;
    private String jobPosition;
    private String contractType;
    private int rating;
    private String comments;
    private String suggestion;

    public global_variable(String username, String passcode) throws SQLException {
        global_variable(username, passcode);
    }

    /**
     * Default Constructor
     */
    void global_variable(){

    }

    /**
     * Populated User Details
     * @param username entered username
     * @param passcode entered passcode
     * @throws SQLException some error exception
     */
    void global_variable(String username, String passcode) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String sql_validate = "select * from employee where username = '" + username + "' and passcode = '" + passcode + "'";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_validate);
            while (resultSet.next()){
                this.id = resultSet.getInt("id");
                this.firstName = resultSet.getString("firstName");
                this.middleInitial = resultSet.getString("middleInitial");
                this.lastName = resultSet.getString("lastName");
                this.accountType = resultSet.getInt("accountType");
                //this.profileImage = resultSet.getBlob("profile"); // Need to learn about blobs
                this.jobPosition = resultSet.getString("position");
                this.contractType = resultSet.getString("contractType");
                this.rating = resultSet.getInt("rating");
                this.comments = resultSet.getString("comment");
                this.suggestion = resultSet.getString("suggestion");
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public Blob getProfileImage() {
        return profileImage;
    }

    public int getAccountType() {
        return accountType;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getContractType() {
        return contractType;
    }

    public String getCompleteName() {
        return this.firstName + " " + this.middleInitial + ". " + this.lastName;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void displayAllUserInformation(){
        System.out.println("Complete Name: " + getCompleteName() +
                            "\nRating: " + getRating() +
                            "\nComment: " + getComments() +
                            "\nSuggestion " + getSuggestion());
    }
}
