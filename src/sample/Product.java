package sample;

import java.sql.SQLException;
import java.util.ArrayList;

public class Product implements Item{
    //this is an abstract class
    private String UID;
    private String type;
    private String manufacturer;
    private String productName;
    private String numberOfItems;
    private String creator;
    private String date;


    public Product(String productName, String manufacturer, String numberOfItems, String type, String creator, String date) throws SQLException {
        this.type = type;
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.numberOfItems = numberOfItems;
        this.creator = creator;
        this.date = date;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(String numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

}
