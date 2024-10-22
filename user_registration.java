public class UserRegistration {
    public boolean registerUser(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isRegistered = false;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true; // User registered successfully
                String generatedKey = EncryptionUtils.generateKey();
                new KeyManagement().storeEncryptionKey(username, generatedKey); // Store encryption key
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return isRegistered;
    }
}
