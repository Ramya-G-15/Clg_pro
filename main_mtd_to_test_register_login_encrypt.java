public class Main {
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        if (registration.registerUser("testuser", "password123")) {
            System.out.println("User registered successfully!");

            UserLogin login = new UserLogin();
            if (login.authenticateUser("testuser", "password123")) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("Authentication failed!");
            }
        } else {
            System.out.println("User registration failed!");
        }
    }
}
