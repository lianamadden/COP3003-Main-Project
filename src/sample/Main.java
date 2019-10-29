//Main Java Project
//Liana Madden

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    public Main() throws SQLException {
    }
    //"extends Application" provides functionality for the javafx to work
    //"implements EventHandler<ActionEvent>" allows the program to allow Events
    //<ActionEvent> is the event for a button click

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Product Inventory");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        ProductManager pm = new ProductManager();
        pm.selectAll();

        // Finally let's insert some data
        // Will use stringBuilder or similar in video to build/map this
        // Main point for both: USE PLACEHOLDERS
        String insertQuery = "INSERT INTO employee " +
                "(uid, name)" +
                " VALUES (?, ?)";
        //String[] itemp = {"5854", "New Value"};

        //pm.insertProd(insertQuery, itemp);
        pm.selectAll();


        // And close our connection at end
        pm.closeCon();
    }


    public static void main(String[] args) throws IOException, SQLException {
        launch(args); //method inside of application class that sets up the javafx application (which calls method start)
    }


}
