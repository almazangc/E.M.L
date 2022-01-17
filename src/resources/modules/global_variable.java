package resources.modules;

import resources.database.DatabaseConnection;

import java.sql.*;

/**
 * Class Containing Recently Logged Account
 */
public class global_variable {
    /**
     * Logged Account ID
     */
    private int id;
    /**
     * Logged Account First name
     */
    private String firstName;
    /**
     * Logged Account Middle Initial
     */
    private String middleInitial;
    /**
     * Logged Account Last name
     */
    private String lastName;
    /**
     * Logged Account Profile Picture
     */
    private Blob profileImage;
    /**
     * Logged Account Type
     */
    private int accountType;
    /**
     * Logged Account Job Position
     */
    private String jobPosition;
    /**
     * Logged Account Job Contract Type
     */
    private String contractType;
    /**
     * Logged Account Rating
     */
    private int rating;
    /**
     * Logged Account Comments
     */
    private String comments;
    /**
     * Logged Account Suggestion
     */
    private String suggestion;

    /**
     * Constructor for initializing values of declared variables
     * @param username validated account
     * @param passcode of validated account
     * @throws SQLException sql exception error
     */
    public global_variable(String username, String passcode) throws SQLException {
        global_variable(username, passcode);
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

    /**
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Middle initial
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return blob profile picture
     */
    public Blob getProfileImage() {
        return profileImage;
    }

    /**
     * @return type of account
     */
    public int getAccountType() {
        return accountType;
    }

    /**
     * @return job position
     */
    public String getJobPosition() {
        return jobPosition;
    }

    /**
     * @return job contract type
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * @return firstname, middleInitial, and lastname string concat
     */
    public String getCompleteName() {
        return this.firstName + " " + this.middleInitial + ". " + this.lastName;
    }

    /**
     * @return boss rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @return manager comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @return manager suggestion
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * Sout information gotta remove later
     */
    public void displayAllUserInformation(){
        System.out.println("Complete Name: " + getCompleteName() +
                            "\nRating: " + getRating() +
                            "\nComment: " + getComments() +
                            "\nSuggestion " + getSuggestion());
    }
}
