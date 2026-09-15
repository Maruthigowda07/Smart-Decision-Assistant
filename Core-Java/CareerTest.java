
import java.util.ArrayList;

public class CareerTest {

    public static void main(String[] args) {

        Career c1 =
                new Career("Java Developer",
                        "Java",
                        600000,
                        9,
                        7);

        Career c2 =
                new Career("Web Developer",
                        "HTML CSS",
                        500000,
                        8,
                        6);

        Career c3 =
                new Career("Data Analyst",
                        "SQL",
                        550000,
                        9,
                        7);

        Career c4 =
                new Career("Software Tester",
                        "Testing",
                        450000,
                        8,
                        5);

        Career c5 =
                new Career("AI Developer",
                        "Python",
                        800000,
                        10,
                        9);


        ArrayList<Career> careers =
                new ArrayList<>();

        careers.add(c1);
        careers.add(c2);
        careers.add(c3);
        careers.add(c4);
        careers.add(c5);


        for (Career career : careers) {

            System.out.println(career);
        }
    }
}
