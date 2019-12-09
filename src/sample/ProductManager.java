package sample;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    static final String UID = "";
    static final String PASSWORD = "";

    private Connection conn = null;
    private Statement statement;

    /*public ProductManager() throws SQLException {
        conn = DriverManager.getConnection("BIN.PUBLIC.EMPLOYEE");
    }
*/
    public void connectToDB() {
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, UID, PASSWORD);
            statement = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//end connectToDB

    public void insertIntoProduct(String val1, String val2, String val3, String val4, String val5, String val6) throws SQLException{
        connectToDB();
         String[] insertValues = {val1, val2, val3, val4, val5, val6};
        try {
            String insertQuery = "INSERT INTO PRODUCT"
                    + "(PRODUCT_NAME, MANUFACTURER, PRODUCT_TYPE, NUMBER_OF_ITEMS, CREATOR, CREATE_DATE)" + " VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, insertValues[0]);
            pstmt.setString(2, insertValues[1]);
            pstmt.setString(3, insertValues[2]);
            pstmt.setString(4, insertValues[3]);
            pstmt.setString(5, insertValues[4]);
            pstmt.setString(6,insertValues[5]);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println("ERROR: insertIntoProducts Failed!");
            System.out.println(e);

        }
    }
    public void insertIntoUsers(String val1, String val2, String val3, String val4) throws SQLException {
        connectToDB();
        if (!selectFromUsersWhereUsernameIs(val1)) {
            String[] insertValues = {val1, val2, val3, val4};
            try {
                String insertQuery = "INSERT INTO EMPLOYEE"
                        + "(UID, PASSWORD, FIRST_NAME, LAST_NAME)" + " VALUES (?, ?, ?, ?);";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, insertValues[0]);
                pstmt.setString(2, insertValues[1]);
                pstmt.setString(3, insertValues[2]);
                pstmt.setString(4, insertValues[3]);
                pstmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                System.out.println("ERROR: insertIntoUsers Failed!");
                System.out.println(e);
            }
        }else {
            System.out.println("User Already Exists!");
        }
    }//end insert into users

    /*public void insertProd(String iQuery, String[] insertValues) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(iQuery);
        pstmt.setInt(1, Integer.parseInt(insertValues[0]));
        pstmt.setString(2, insertValues[1]);
        pstmt.executeUpdate();
    }

    public void selectAll() {
        ResultSet rs = null;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee;");

            while (rs.next()) {
                System.out.printf("UID = %d%n", rs.getInt("uid"));
                System.out.printf("Name = %s%n", rs.getString("name"));
            }

        } catch (SQLException e) {
            sqlExceptionHandler(e);
        }
    }
*/

    public boolean selectFromUsersWhereUsernameIs(String value) {
        connectToDB();
        boolean userExists = true;
        ResultSet rs = null;
        try {
            String insertQuery = "SELECT * FROM EMPLOYEE WHERE UID IS ?;";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, value);
            rs = pstmt.executeQuery(insertQuery);
            conn.close();
        } catch (SQLException e) {
            userExists = false;
        }
        return userExists;
    }

    public ArrayList<String> logInUser(String uid, String password) throws SQLException {
        ArrayList<String> person = new ArrayList<String>();

        connectToDB();
        ResultSet rs = null;

        try {
            String insertQuery = "SELECT * FROM EMPLOYEE WHERE UID = \'" + uid + "\'";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(insertQuery);

            while(rs.next()) {
                person.add(rs.getString("UID"));
                person.add(rs.getString("PASSWORD"));
                System.out.println(person.add(rs.getString("FIRST_NAME")));
                person.add(rs.getString("LAST_NAME"));
            }
    }
    catch (Exception e){
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
    }
        conn.close();
        return person;
    }

    public ArrayList<String> pullProductTable() throws SQLException {
        ArrayList<String> productList = new ArrayList<String>();
        connectToDB();
        ResultSet rs = null;

        try {
            String insertQuery = "SELECT * FROM PRODUCT";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(insertQuery);

            while(rs.next()) {
                productList.add(rs.getString("PRODUCT_NAME"));
                productList.add(rs.getString("MANUFACTURER"));
                productList.add(rs.getString("PRODUCT_TYPE"));
                productList.add(rs.getString("NUMBER_OF_ITEMS"));
                productList.add(rs.getString("CREATOR"));
                productList.add(rs.getString("CREATE_DATE"));
            }
        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        conn.close();
        return productList;
    }

}
