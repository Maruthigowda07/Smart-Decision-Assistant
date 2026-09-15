 public class Mobile {

    private String name;
    private int price;
    private int camera;
    private int battery;
    private int performance;

    
    // Constructor
    public Mobile(String name, int price, int camera,
                  int battery, int performance) {

        this.name = name;
        this.price = price;
        this.camera = camera;
        this.battery = battery;
        this.performance = performance;
    }


    // Getters

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }


    public int getCamera() {
        return camera;
    }


    public int getBattery() {
        return battery;
    }


    public int getPerformance() {
        return performance;
    }


    // toString

    @Override
    public String toString() {

        return "Mobile [name=" + name
                + ", price=" + price
                + ", camera=" + camera
                + ", battery=" + battery
                + ", performance=" + performance + "]";
    }
 
    
}
