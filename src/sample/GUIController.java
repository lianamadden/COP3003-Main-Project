package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GUIController {

    private String UID = "";
    private String firstName = "";
    private String lastName = "";
    private String password = "";

    @FXML
    Button button1 = new Button();
    @FXML
    TextField signInUID = new TextField();
    @FXML
    TextField signInPW = new TextField();
    @FXML
    Button signInBtn = new Button();
    @FXML
    Button newAccountBtn = new Button();
    @FXML
    TextField newFirstName = new TextField();
    @FXML
    TextField newLastName = new TextField();
    @FXML
    TextField newPassword = new TextField();
    @FXML
    TextField confirmPassword = new TextField();
    @FXML
    AnchorPane newAccountPane = new AnchorPane();
    @FXML
    AnchorPane employeeAccountTab = new AnchorPane();
    @FXML
    AnchorPane addProductTab = new AnchorPane();
    @FXML
    Label errorCodeBottom = new Label();
    @FXML
    AnchorPane newUIDPane = new AnchorPane();
    @FXML
    Label lastNameLabel = new Label();
    @FXML
    Label firstNameLabel = new Label();
    @FXML
    Label usernameLabel = new Label();
    @FXML
    Label concatUIDLabel = new Label();
    @FXML
    Button signInAgainBtn = new Button();

    private ProductManager SignUpController = new ProductManager();
    private ProductManager SignInController = new ProductManager();



    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        System.out.println("You pressed the button!");

    }

    @FXML
    private void handleOpenNewAccountPaneBtnPressed(ActionEvent event) {
        //New Account Button Pressed and Create New Account Pane opens
        employeeAccountTab.setVisible(false);
        newUIDPane.setVisible(false);
        newAccountPane.setVisible(true);
    }

    @FXML
    private void handleSignInAgainBtn (ActionEvent event) {
        //employeeAccountTab.setVisible(false);
        //newUIDPane.setVisible(false);
        //newAccountPane.setVisible(false);
    }

    @FXML
    private void handleCreateNewAccountBtn(ActionEvent event) throws SQLException {
        //Create new employee button pressed and account is created in Database
        firstName = newFirstName.getText();
        lastName = newLastName.getText();
        UID = (firstName.charAt(0) + lastName).toLowerCase();
        password = newPassword.getText();
        Boolean UIDStatus = true;
        Boolean PasswordStatus = true;
        /*This portion will also be used to check if user already exists.
         * based on this result as well as username and password status
         * we will create a new user or reject and prompt the User*/
            if (UIDStatus && PasswordStatus) { // If Username is UNIQUE, then add user to DataBase
                SignUpController.insertIntoUsers(UID, password, firstName, lastName);
                System.out.println("[remove this later] NEW USER CREATED!");
                newAccountPane.setVisible(false);
                employeeAccountTab.setVisible(true);
            } else { // If Username is not UNIQUE, then reject user Creation
                errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
                errorCodeBottom.setText("Unable to Create New User.");
            }
    }

    @FXML
    private void handleSignInBtnPressed(ActionEvent event) throws SQLException {
        //Logs user into Database
        UID = signInUID.getText().trim();
        password = signInPW.getText().trim();
        ArrayList<String> person = SignInController.logInUser(UID, password);
        firstNameLabel.setText(person.get(2));
        lastNameLabel.setText(person.get(3));
        usernameLabel.setText(person.get(0));
        employeeAccountTab.setVisible(false);
        newAccountPane.setVisible(false);
        newUIDPane.setVisible(true);
    }

    public boolean checkPasswordLength() {
        boolean isGoodPassword = false;
        String PasswordField1Entry = newPassword.getText();
        String PasswordField2Entry = confirmPassword.getText();
        if ((newPassword.getText().trim()).length() < 6
                && (confirmPassword.getText().trim()).length() < 6) { // Both Fields < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
            errorCodeBottom.setText("Both Password Fields Too Short.");
        } else if (((newPassword.getText().trim()).length() >= 6
                && (confirmPassword.getText().trim()).length() < 6)) { // Field 2 < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
            errorCodeBottom.setText("Second Password Field Too Short.");
        } else if (((newPassword.getText().trim()).length() < 6
                && (confirmPassword.getText().trim()).length() >= 6)) { // Field 1 < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
            errorCodeBottom.setText("First Password Field Too Short.");
        } else { // Both correct Length
            if ((PasswordField1Entry.trim()).equals((PasswordField2Entry.trim()))) { // Both Fields Match
                errorCodeBottom.setTextFill(Paint.valueOf("#009918")); // Green
                errorCodeBottom.setText("Password Valid.");
                isGoodPassword = true;
            } else { // Fields Dont Match
                errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
                errorCodeBottom.setText("Password Fields Don't Match.");
            } // end internal if-else
        } // end external if-else
        return isGoodPassword;
    } // end checkPasswordLength

    public boolean checkUIDAvailability() {
        boolean isGoodUID = true;

        return isGoodUID;
    }
}
