package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCSDL {
    public static Connection getConnection() {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/casemodule3";
            String jdbcUsername = "root";
            String jdbcPassword = "raisingthebar12";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername,jdbcPassword);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
