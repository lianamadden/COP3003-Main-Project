package sample;

import java.sql.SQLException;

public class AudioPlayer extends Product implements MultimediaControl {

    private String audioSpecification;
    private String mediaType;

    public AudioPlayer(String productName, String manufacturer, String numberOfItems, String type, String creator, String date, String mediaType, String audioSpecification) throws SQLException {
        super(productName, manufacturer, numberOfItems, type, creator, date);
        this.mediaType = mediaType;
    }


    @Override
    public String getUID() {
        return null;
    }

    @Override
    public void setUID(String UID) {
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
    @Override
    public String toString(){
        return super.toString() +
                "\nAudio Spec: " + audioSpecification +
                "\nMedia Type:" + mediaType;

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
}
