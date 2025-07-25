package com.example.code;
import java.sql.*;
public class Database {
    private static final String DB_URL = "jdbc:sqlite:myapp.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}