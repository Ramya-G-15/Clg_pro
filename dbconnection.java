import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB URL
    private static final String USER = "your_db_username";
    private static final String PASSWORD = "your_db_password";
    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle JDBC Driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
