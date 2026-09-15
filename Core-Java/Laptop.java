
public class Laptop {
    String name;
    int price;
    int ram;
    int performance;

    
    public Laptop(String name, int price, int ram, int performance) {
        this.name = name;
        this.price = price;
        this.ram = ram;
        this.performance = performance;
    }
    public int getRam() {
        return ram;
    }
    public int getPerformance() {
        return performance;
    }
    public int getPrice() {
        return price;
    }
        @Override
     public String toString() {
     return "Laptop [name=" + name + ", price=" + price + ", ram=" + ram + ", performance=" + performance + "]";
}
    }



