package data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    public static java.sql.Connection connectSQLite() {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:ActBD001.db?foreign_keys=on;";
            conn = DriverManager.getConnection(dbURL); 
            System.out.println("Are you connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error the connection" + e);
        }
        return conn;
    }
}
