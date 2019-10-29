package sample;

public abstract class Product implements Item{
    //this is an abstract class
    public int id;
    public String type;
    public String manufacturer;
    public String name;

    public Product(String name){
        name = this.name;
    }
    public String toString(String name, String manufacturer, String type){
        return "Name:" + name +
                "\nManufacturer:" + manufacturer +
                "\nType:" + type;
    }
}
