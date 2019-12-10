package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


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
    @FXML
    ComboBox deviceTypeComboBox = new ComboBox();
    @FXML
    AnchorPane shadowPane = new AnchorPane();
    @FXML
    Label byEmployeeLabel = new Label();
    @FXML
    Label dateTimeLabel = new Label();
    @FXML
    Label numberNameLabel = new Label();
    @FXML
    AnchorPane confirmationPane = new AnchorPane();
    @FXML
    AnchorPane addProductPane = new AnchorPane();
    @FXML
    Button addProductBtn = new Button();
    @FXML
    TextField manufacturerFill = new TextField();
    @FXML
    TextField productNameFill = new TextField();
    @FXML
    TextField numItemFill = new TextField();
    @FXML
    TableView<Product> trackingTable;
    @FXML
    private
    TableColumn<Product, String> productNameColumn;
    @FXML
    private
    TableColumn<Product, String> manufacturerColumn;
    @FXML
    private
    TableColumn<Product, String> itemColumn;
    @FXML
    private
    TableColumn<Product, String> typeColumn;
    @FXML
    private
    TableColumn<Product, String> createdByColumn;
    @FXML
    private
    TableColumn<Product, String> dateColumn;
    @FXML
    TableView<Product> trackingTable1;
    @FXML
    private
    TableColumn<Product, String> productNameColumn1;
    @FXML
    private
    TableColumn<Product, String> manufacturerColumn1;
    @FXML
    private
    TableColumn<Product, String> itemColumn1;


    private ProductManager SignUpController = new ProductManager();
    private ProductManager SignInController = new ProductManager();
    private ProductManager ProductController = new ProductManager();
    private ProductManager CreateNewAccount = new ProductManager();



    @FXML
    private void handleOpenNewAccountPaneBtnPressed(ActionEvent event) {
        //New Account Button Pressed and Create New Account Pane opens
        employeeAccountTab.setVisible(false);
        newUIDPane.setVisible(false);
        newAccountPane.setVisible(true);
    }

    @FXML
    private void handleSignInAgainBtn(ActionEvent event) {
        employeeAccountTab.setVisible(true);
        newUIDPane.setVisible(false);
        newAccountPane.setVisible(false);
        signInUID.setText("");
        signInPW.setText("");
    }

    @FXML
    private void handleAddProductBtnPressed(ActionEvent event) throws SQLException {
        String type = deviceTypeComboBox.getValue().toString();
        String manufacturer = manufacturerFill.getText();
        String productName = productNameFill.getText();
        String numberOfItems = numItemFill.getText();
        String creator = UID;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        String date = now.toString();
        ProductController.insertIntoProduct(productName, manufacturer, type, numberOfItems, creator, date);
        //ArrayList<String> productList = ProductController.pullProductTable(productName, manufacturer, type, numberOfItems, creator);
        initialize();
        numberNameLabel.setText(numberOfItems + " " + productName + "s");
        dateTimeLabel.setText(date);
        byEmployeeLabel.setText("by employee: " + creator);
        shadowPane.setVisible(true);
        confirmationPane.setVisible(true);
        manufacturerFill.setText("");
        productNameFill.setText("");
        numItemFill.setText("");
        //deviceTypeComboBox.
    }

    @FXML
    private void handleShadowPanePressed() {
        confirmationPane.setVisible(false);
        shadowPane.setVisible(false);
    }

    @FXML
    private void handleCreateNewAccountBtn(ActionEvent event) throws SQLException {
        //Create new employee button pressed and account is created in Database
        firstName = newFirstName.getText();
        lastName = newLastName.getText();
        UID = (firstName.charAt(0) + lastName).toLowerCase();
        password = newPassword.getText();
        Boolean UIDStatus = checkUIDAvailability(UID);
        Boolean PasswordStatus = checkPasswordLength();

        if (UIDStatus) {
            concatUIDLabel.setText("Your username is: " + UID);
        } else {
            int i = 1;
            UID = UID + i++;
            System.out.println("Checking 1" + UID);
            checkUIDAvailability(UID);
            concatUIDLabel.setText("Your username is: " + UID);
        }

        if (UIDStatus && PasswordStatus) { // If Username is UNIQUE, then add user to DataBase
            System.out.println(UID);
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
        if ((newPassword.getText().trim()).length() < 4
                && (confirmPassword.getText().trim()).length() < 4) { // Both Fields < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
            errorCodeBottom.setText("Both Password Fields Too Short.");
        } else if (((newPassword.getText().trim()).length() >= 4
                && (confirmPassword.getText().trim()).length() < 4)) { // Field 2 < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000")); // Red
            errorCodeBottom.setText("Second Password Field Too Short.");
        } else if (((newPassword.getText().trim()).length() < 4
                && (confirmPassword.getText().trim()).length() >= 4)) { // Field 1 < 6
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

    public boolean checkUIDAvailability(String UID) {
        boolean isGoodUID = true;
        System.out.println(UID);
        isGoodUID = !(CreateNewAccount.selectFromUsersWhereUsernameIs(UID));
        System.out.println(isGoodUID);
        return isGoodUID;
    }


    @FXML
    public void initialize() throws SQLException {
        //deviceTypeComboBox.getItems().removeAll(deviceTypeComboBox.getItems());
        deviceTypeComboBox.getItems().addAll("Audio", "Visual", "AudioMobile", "VisualMobile");
        //deviceTypeComboBox.getSelectionModel().select("Option B");
        fillTableView();
        fillTableViewInventory();
    }

    @FXML
    public void fillTableViewInventory() throws SQLException {
        productNameColumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        manufacturerColumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("manufacturer"));
        itemColumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("numberOfItems"));

        ArrayList<String> inventory = ProductController.pullProductTable();
        System.out.println(inventory);

        ObservableList<Product> productInventory = FXCollections.observableArrayList();

        for (int i = 0; i <= inventory.size()- 1;i++) {
            if (!(inventory.get(i).equals("null"))) {

                //product name
                String arg1 = inventory.get(i);
                i++;
                //manufacturer
                String arg2 = inventory.get(i);
                i++;
                //item type
                String arg3 = inventory.get(i);
                i++;
                //item number
                String arg4 = inventory.get(i);
                i++;
                //username
                String arg5 = inventory.get(i);
                i++;
                //date
                String arg6 = inventory.get(i);

                productInventory.addAll(FXCollections.observableArrayList(
                        new Product(arg1, arg2, arg4, arg3, arg5, arg6)));
            }
            trackingTable1.setItems(productInventory);
        }

    }

    @FXML
    public void fillTableView() throws SQLException {
        trackingTable.getColumns().removeAll();
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("manufacturer"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("numberOfItems"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        createdByColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("creator"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("date"));

        ArrayList<String> product = ProductController.pullProductTable();

        ArrayList<String> productName = new ArrayList<String>();
        for (int j = 0; j < product.size() - 1; j += 6) {
            productName.add(product.get(j));
        }

        ArrayList<String> manufacturer = new ArrayList<String>();
        for (int j = 1; j < product.size() - 1; j += 6) {
            manufacturer.add(product.get(j));
        }

        ArrayList<String> itemNum = new ArrayList<String>();
        for (int j = 3; j < product.size() - 1; j += 6) {
            itemNum.add(product.get(j));
        }


        for (int k = 0; k >= product.size()-1; k++ ) {
            System.out.print(productName);
            if (productName.get(k).equals(productName.get(k+1))) {
                String args2 = String.valueOf(Integer.parseInt(itemNum.get(k)) + Integer.parseInt(itemNum.get(k+1)));
                itemNum.add(k+1, args2);
                itemNum.remove(k);
                productName.remove(k);
                manufacturer.remove(k);
            }else{
                k++;
                System.out.print(itemNum);
                System.out.println(k);
            }
        }


        ObservableList<Product> products = FXCollections.observableArrayList();

        for (int i = 0; i <= product.size()- 1;i++) {
            if (!(product.get(i).equals("null"))) {

                //product name
                String arg1 = product.get(i);
                i++;
                //manufacturer
                String arg2 = product.get(i);
                i++;
                //item type
                String arg3 = product.get(i);
                i++;
                //item number
                String arg4 = product.get(i);
                i++;
                //username
                String arg5 = product.get(i);
                i++;
                //date
                String arg6 = product.get(i);

                //products.add(new Product(arg1, arg2, arg3, arg4, arg5, arg6));
                    products.addAll(FXCollections.observableArrayList(
                            new Product(arg1, arg2, arg3, arg4, arg5, arg6)));
                }
                trackingTable.setItems(products);
            }
        }
        }
