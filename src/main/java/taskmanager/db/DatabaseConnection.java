package taskmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnection {
    // 1. New field: This variable holds the ONLY instance of this class
    private static DatabaseConnection instance;

    // 2. New field: This variable holds the actual connection to the DB
    private Connection connection;

    private static final String URL =
            "jdbc:postgresql://aws-1-ap-southeast-2.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.rclpzboctpicuiyizexo";
    private static final String PASSWORD = loadPassword();

    private static String loadPassword() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            String value = props.getProperty("DB_PASSWORD");
            if (value == null || value.isBlank()) {
                throw new RuntimeException("DB_PASSWORD is not set in config.properties");
            }
            return value;
        } catch (IOException e) {
            throw new RuntimeException("Cannot load DB_PASSWORD from config.properties", e);
        }
    }

    // 3. New Private Constructor:
    // It is "private" so no other class can do 'new DatabaseConnection()'
    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    // 4. New Static Method:
    // This is the "Gatekeeper". It checks if an instance exists.
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // 5. Getter for the connection
    public Connection getConnection() {
        return connection;
    }
}