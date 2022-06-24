package pl.coderslab.workshop2;

import java.sql.*;

public class DbUtils {
    private static final String DB_BASE = "workshop2";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_OPTIONS = "?characterEncoding=utf8&serverTimezone=CET";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_OPTIONS, DB_USER, DB_PASS)){
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS workshop2\n" +
                    "    CHARACTER SET utf8 COLLATE utf8_unicode_ci");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void initializeTables() {
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_BASE + DB_OPTIONS, DB_USER, DB_PASS)){
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users(\n" +
                    "                    id          INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                    "            email       VARCHAR(255) NOT NULL UNIQUE,\n" +
                    "                    username    VARCHAR(255) NOT NULL UNIQUE,\n" +
                    "                    password    VARCHAR(255) NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL + DB_BASE + DB_OPTIONS, DB_USER, DB_PASS);
    }

}
