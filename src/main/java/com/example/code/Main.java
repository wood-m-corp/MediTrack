package com.example.code;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        createUsersTable();
        javafx.application.Application.launch(MediTrackApp.class);
    }

    private static void createUsersTable() {
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement()) {
            String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                );
            """;
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}