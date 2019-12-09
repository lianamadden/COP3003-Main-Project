package sample;

import java.sql.SQLException;

public class MoviePlayer extends Product implements MultimediaControl {
    public String screen;
    public String monitor;

    public MoviePlayer(String productName, String manufacturer, String numberOfItems, String type, String creator, String date) throws SQLException {
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
    public void setManufacturer(String manufacturer) {
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void next() {

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMonitor: " + monitor +
                "\nScreen:" + screen;
    }
}
