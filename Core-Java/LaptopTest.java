import java.util.ArrayList;

public class LaptopTest {
public static void main(String[] args) {
    Laptop l1 = new Laptop("Dell", 1000, 8, 7);
    Laptop l2= new Laptop("HP", 1200, 16, 8);
    Laptop l3 = new Laptop("Apple", 1500, 32, 9);
    Laptop l4 = new Laptop("Lenovo", 900, 8, 6);
    Laptop l5 = new Laptop("Asus", 1100, 16, 7);

    ArrayList<Laptop> laptops = new ArrayList<>();
    laptops.add(l1);
    laptops.add(l2);    
    laptops.add(l3);
    laptops.add(l4);
    laptops.add(l5);

    for(Laptop laptop : laptops) {
        System.out.println(laptop);
    }
}    
}
