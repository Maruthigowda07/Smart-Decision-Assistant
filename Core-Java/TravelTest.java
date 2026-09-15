
import java.util.ArrayList;

public class TravelTest {

    public static void main(String[] args) {

        Travel t1 =
                new Travel("Goa", 15000, 3, 9, 7);

        Travel t2 =
                new Travel("Manali", 20000, 5, 10, 8);

        Travel t3 =
                new Travel("Kerala", 18000, 4, 7, 10);

        Travel t4 =
                new Travel("Ooty", 10000, 2, 6, 9);

        Travel t5 =
                new Travel("Jaipur", 12000, 3, 8, 8);


        ArrayList<Travel> travels =
                new ArrayList<>();

        travels.add(t1);
        travels.add(t2);
        travels.add(t3);
        travels.add(t4);
        travels.add(t5);


        for (Travel travel : travels) {

            System.out.println(travel);
        }
    }
}

