package sample;

public class Widget extends Product{
    public Widget(String name) {
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
}
