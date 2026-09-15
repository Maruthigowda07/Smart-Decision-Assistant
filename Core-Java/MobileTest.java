import java.util.ArrayList;

public class MobileTest {

    public static void main(String[] args) {

        Mobile m1 =
                new Mobile("Samsung", 25000, 8, 8, 8);

        Mobile m2 =
                new Mobile("OnePlus", 30000, 8, 9, 9);

        Mobile m3 =
                new Mobile("iPhone", 60000, 9, 8, 10);

        Mobile m4 =
                new Mobile("Redmi", 18000, 7, 9, 7);

        Mobile m5 =
                new Mobile("Realme", 22000, 8, 9, 8);


        ArrayList<Mobile> mobiles =
                new ArrayList<>();

        mobiles.add(m1);
        mobiles.add(m2);
        mobiles.add(m3);
        mobiles.add(m4);
        mobiles.add(m5);


        for (Mobile mobile : mobiles) {

            System.out.println(mobile);
        }
    }
}
