package com.example.code;
import java.sql.*;
//will need to fix this up
public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:myapp.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initialize() throws SQLException {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            // Create roles table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE,
                    password TEXT,
                    role TEXT CHECK(role IN ('user', 'admin', 'owner')) NOT NULL
                )
            """);

            // Create some sample data table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS data (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    owner_id INTEGER,
                    content TEXT,
                    FOREIGN KEY(owner_id) REFERENCES users(id)
                )
            """);
        }
    }
}