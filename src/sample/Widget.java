package sample;

import java.sql.SQLException;

public class Widget extends Product{
    public Widget(String productName, String manufacturer, String numberOfItems, String type, String creator, String date) throws SQLException {
        super(productName, manufacturer, numberOfItems, type, creator, date);
    }

    @Override
    public String getUID() {
        return null;
    }

    @Override
    public void setProductName(String productName) {

    }

    @Override
    public String getProductName() {
        return null;
    }

    @Override
    public void setManufacturer(String parameter) {

    }

    @Override
    public String getManufacturer() {
        return null;
    }
}
