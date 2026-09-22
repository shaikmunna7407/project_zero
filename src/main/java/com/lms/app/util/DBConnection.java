package com.lms.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/connect_world",
                "root",
                "123@Munna"
        );


    }
}
