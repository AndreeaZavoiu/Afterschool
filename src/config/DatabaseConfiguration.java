package com.company.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    //                                protocol:subprotocol://subname     (schema)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_afterschool"; // utilitar in clasa => static final
    private static final String USER = "root";
    private static final String PASSWORD = "jdbcPAO10.";

    // singleton pt ca folosim mereu aceeasi conexiune
    private static Connection databaseConnection;
    private DatabaseConfiguration() {}

    public static Connection getDatabaseConnection() {
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return databaseConnection;
    }

    public static void closeDatabaseConfiguration() {
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
