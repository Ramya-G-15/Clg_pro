import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KeyManagement {
    public boolean storeEncryptionKey(String userId, String encryptionKey) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isStored = false;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO encryption_keys (user_id, key_value) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, userId);
            statement.setString(2, encryptionKey);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isStored = true; // Key stored successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return isStored;
    }
}
