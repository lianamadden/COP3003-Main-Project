package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class GUIController {

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
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        System.out.println("You pressed the button!");

    }

    @FXML
    private void handleOpenNewAccountPaneBtnPressed(ActionEvent event) {
        //New Account Button Pressed and Create New Account Pane opens
        newAccountPane.setVisible(true);
    }

    @FXML
    private void handleCreateNewAccountBtn(ActionEvent event) {
        //Create new employee button pressed and account is created in Database
        newAccountPane.setVisible(false);
    }

    @FXML
    private void handleSignInBtnPressed(ActionEvent event) {
        //Logs user into Database
        employeeAccountTab.setVisible(false);
        addProductTab.setVisible(true);
    }


}
