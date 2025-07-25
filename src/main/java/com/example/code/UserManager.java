package com.example.code;

import java.sql.*;

public class UserManager {

    public static boolean registerUser(User user) {
        String sql = "INSERT INTO users(username, password, role) VALUES(?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.error("Database error", e);
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            Logger.error("Database error", e);
        }
        return null;
    }

    public static boolean adminExists() {
        String sql = "SELECT 1 FROM users WHERE role = 'Admin' LIMIT 1";
        try (Connection conn = Database.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // true if admin found
        } catch (SQLException e) {
            Logger.error("Error checking for admin", e);
            return false;
        }
    }
}