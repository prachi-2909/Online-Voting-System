import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateDatabase {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";  // Use your MySQL username
        String password = "prachisundaram@29";  // Use your MySQL password

        // Name of the database to be created
        String dbName = "online_voting_system";

        // SQL query to create a database
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;

        try {
            // Step 1: Establish the connection to MySQL server
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 2: Create a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute the SQL statement to create the database
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database " + dbName + " created or already exists.");

            // Step 4: Close the resources (statement and connection)
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
