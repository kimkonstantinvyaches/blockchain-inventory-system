package Helper;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    
    //* Database connection constants
    private static final String DB_URL = "jdbc:mysql://localhost:3307/inventory_system";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    //* Init connection and properties object
    private static Connection connection;
    private Properties dbConnCred;

    private Properties getProperties() {
        if (dbConnCred == null) {
            dbConnCred = new Properties();
            dbConnCred.setProperty("user", DB_USERNAME);
            dbConnCred.setProperty("password", DB_PASSWORD);
        }
        return dbConnCred;
    }

    public Connection connect()  {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, getProperties());
                System.out.println("Database connected!");
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect to database!", e);
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
