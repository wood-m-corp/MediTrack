package com.example.code;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = getDatabasePath();

    public static Connection connect() throws SQLException {
        ensureDirectoryExists();
        return DriverManager.getConnection(DB_URL);
    }

    private static String getDatabasePath() {
        String dbDir = System.getenv("APPDATA") + File.separator + "MediTrack";
        String dbPath = dbDir + File.separator + "myapp.db";
        return "jdbc:sqlite:" + dbPath;
    }

    private static void ensureDirectoryExists() {
        String dbDir = System.getenv("APPDATA") + File.separator + "MediTrack";
        File dir = new File(dbDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}