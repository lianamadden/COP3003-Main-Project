package sample;

public class MoviePlayer extends Product implements MultimediaControl {
    public String screen;
    public String monitor;

    public MoviePlayer(String name) {
        super(name);
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setName(String parameter) {

    }

    @Override
    public String getName() {
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
