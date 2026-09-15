
import java.util.ArrayList;
import java.util.Scanner;

public class DecisionEngine {

    // Calculate laptop score
    public int calculateScore(Laptop laptop, int requiredRam, int requiredPerformance) {

        int score = 0;

        // RAM matching
        if (laptop.getRam() >= requiredRam) {
            score += 10;
        }

        // Performance matching
        if (laptop.getPerformance() >= requiredPerformance) {
            score += 10;
        }

        // Add actual RAM and performance
        score += laptop.getRam();
        score += laptop.getPerformance();

        return score;
    }


    // Filter laptops according to budget
    public ArrayList<Laptop> filterByBudget(
            ArrayList<Laptop> laptops, int budget) {

        ArrayList<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {

            if (laptop.getPrice() <= budget) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }


    // Find best laptop
    public Laptop findBestLaptop(
            ArrayList<Laptop> laptops,
            int requiredRam,
            int requiredPerformance) {

        Laptop bestLaptop = laptops.get(0);

        int bestScore =
                calculateScore(bestLaptop, requiredRam, requiredPerformance);


        for (Laptop laptop : laptops) {

            int score =
                    calculateScore(
                            laptop,
                            requiredRam,
                            requiredPerformance
                    );

            if (score > bestScore) {

                bestScore = score;

                bestLaptop = laptop;
            }
        }

        return bestLaptop;
    }


    // Main method
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   SMART DECISION ASSISTANT");
        System.out.println("=================================");


        // Create laptops
        Laptop l1 =
                new Laptop("Dell", 1000, 8, 7);

        Laptop l2 =
                new Laptop("HP", 1200, 16, 8);

        Laptop l3 =
                new Laptop("Apple", 1500, 32, 9);

        Laptop l4 =
                new Laptop("Lenovo", 900, 8, 6);

        Laptop l5 =
                new Laptop("Asus", 1100, 16, 7);


        // Store laptops
        ArrayList<Laptop> laptops =
                new ArrayList<>();

        laptops.add(l1);
        laptops.add(l2);
        laptops.add(l3);
        laptops.add(l4);
        laptops.add(l5);


        // Scanner
        Scanner sc = new Scanner(System.in);


        // Get user requirements
        System.out.print("Enter your budget: ");
        int budget = sc.nextInt();


        System.out.print("Enter required RAM: ");
        int requiredRam = sc.nextInt();


        System.out.print("Enter required performance: ");
        int requiredPerformance = sc.nextInt();


        // Create engine
        DecisionEngine engine =
                new DecisionEngine();


        // Budget filtering
        ArrayList<Laptop> filteredLaptops =
                engine.filterByBudget(laptops, budget);


        System.out.println();
        System.out.println("Laptops within your budget:");
        System.out.println("---------------------------------");


        for (Laptop laptop : filteredLaptops) {

            System.out.println(laptop);
        }


        // No laptop found
        if (filteredLaptops.isEmpty()) {

            System.out.println();
            System.out.println(
                    "No laptop found within your budget."
            );

        } else {

            // Find best laptop
            Laptop bestLaptop =
                    engine.findBestLaptop(
                            filteredLaptops,
                            requiredRam,
                            requiredPerformance
                    );


            // Calculate best score
            int bestScore =
                    engine.calculateScore(
                            bestLaptop,
                            requiredRam,
                            requiredPerformance
                    );


            System.out.println();
            System.out.println("=================================");
            System.out.println("       RECOMMENDED LAPTOP");
            System.out.println("=================================");

            System.out.println(
                    "Laptop       : " + bestLaptop
            );

            System.out.println(
                    "Best Score   : " + bestScore
            );

            System.out.println(
                    "================================="
            );
        }


        sc.close();
    }
}

