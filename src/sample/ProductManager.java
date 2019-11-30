package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String USER = "";
    static final String PASS = "";
    private Connection conn = null;
    private Statement statement;

    public ProductManager() throws SQLException {/*
        conn = DriverManager.getConnection("BIN.PUBLIC.EMPLOYEE");
    }

    public void insertProd(String iQuery, String[] insertValues) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(iQuery);
        pstmt.setInt(1, Integer.parseInt(insertValues[0]));
        pstmt.setString(2, insertValues[1]);
        pstmt.executeUpdate();
    }

    public void selectAll() {
        ResultSet rs = null;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee;");

            while (rs.next()) {
                System.out.printf("UID = %d%n", rs.getInt("uid"));
                System.out.printf("Name = %s%n", rs.getString("name"));
            }

        } catch (SQLException e) {
            sqlExceptionHandler(e);
        }
    }

    public void closeCon() {
        try {
            con.close();
        } catch (SQLException e) {
            sqlExceptionHandler(e);
        }
    }

    public void sqlExceptionHandler(SQLException error) {
        // add logging, could make into a wrapper function
        System.out.println("Standard Failure: " + error.getMessage());
    }*/
    }
}
