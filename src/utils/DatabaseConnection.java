package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Krishna K.C on 12/13/2016.
 */
public class DatabaseConnection {

    String url = "jdbc:mysql://localhost:3306/mark_sheet";
    String username = "root";
    String password = "";

    Connection connection = null;

    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query) {
        PreparedStatement pstm = null;
        try {
            pstm =  connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }
}

