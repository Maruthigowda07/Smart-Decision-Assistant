
import java.util.ArrayList;
import java.util.Scanner;

public class MobileDecisionEngine {

    // Calculate Score
    public int calculateScore(
            Mobile mobile,
            int requiredCamera,
            int requiredBattery,
            int requiredPerformance) {

        int score = 0;

        // Camera matching
        if (mobile.getCamera() >= requiredCamera) {
            score += 10;
        }

        // Battery matching
        if (mobile.getBattery() >= requiredBattery) {
            score += 10;
        }

        // Performance matching
        if (mobile.getPerformance() >= requiredPerformance) {
            score += 10;
        }

        // Actual specifications
        score += mobile.getCamera();
        score += mobile.getBattery();
        score += mobile.getPerformance();

        return score;
    }


    // Filter by Budget
    public ArrayList<Mobile> filterByBudget(
            ArrayList<Mobile> mobiles,
            int budget) {

        ArrayList<Mobile> filteredMobiles =
                new ArrayList<>();

        for (Mobile mobile : mobiles) {

            if (mobile.getPrice() <= budget) {
                filteredMobiles.add(mobile);
            }
        }

        return filteredMobiles;
    }


    // Find Best Mobile
    public Mobile findBestMobile(
            ArrayList<Mobile> mobiles,
            int requiredCamera,
            int requiredBattery,
            int requiredPerformance) {

        Mobile bestMobile = mobiles.get(0);

        int bestScore =
                calculateScore(
                        bestMobile,
                        requiredCamera,
                        requiredBattery,
                        requiredPerformance
                );

        for (Mobile mobile : mobiles) {

            int score =
                    calculateScore(
                            mobile,
                            requiredCamera,
                            requiredBattery,
                            requiredPerformance
                    );

            if (score > bestScore) {

                bestScore = score;
                bestMobile = mobile;
            }
        }

        return bestMobile;
    }


    // Main Method
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   SMART DECISION ASSISTANT");
        System.out.println("       MOBILE RECOMMENDER");
        System.out.println("=================================");


        // Create Mobiles

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


        // ArrayList

        ArrayList<Mobile> mobiles =
                new ArrayList<>();

        mobiles.add(m1);
        mobiles.add(m2);
        mobiles.add(m3);
        mobiles.add(m4);
        mobiles.add(m5);


        // Scanner

        Scanner sc = new Scanner(System.in);


        // User Budget

        System.out.print("Enter your budget: ");
        int budget = sc.nextInt();


        // Camera Requirement

        System.out.print("Enter required camera level (6-9): ");
        int requiredCamera = sc.nextInt();


        // Battery Requirement

        System.out.print("Enter required battery level (6-9): ");
        int requiredBattery = sc.nextInt();


        // Performance Requirement

        System.out.print("Enter required performance level (6-10): ");
        int requiredPerformance = sc.nextInt();


        // Create Engine

        MobileDecisionEngine engine =
                new MobileDecisionEngine();


        // Filter by Budget

        ArrayList<Mobile> filteredMobiles =
                engine.filterByBudget(
                        mobiles,
                        budget
                );


        System.out.println();
        System.out.println("Mobiles within your budget:");
        System.out.println("---------------------------------");


        for (Mobile mobile : filteredMobiles) {

            System.out.println(
                    mobile.getName()
                    + " - ₹"
                    + mobile.getPrice()
            );
        }


        // No Mobile Found

        if (filteredMobiles.isEmpty()) {

            System.out.println();
            System.out.println(
                    "No mobile found within your budget."
            );

        } else {

            // Find Best Mobile

            Mobile bestMobile =
                    engine.findBestMobile(
                            filteredMobiles,
                            requiredCamera,
                            requiredBattery,
                            requiredPerformance
                    );


            // Calculate Score

            int bestScore =
                    engine.calculateScore(
                            bestMobile,
                            requiredCamera,
                            requiredBattery,
                            requiredPerformance
                    );


            // Final Recommendation

            System.out.println();

            System.out.println("=================================");
            System.out.println("       RECOMMENDED MOBILE");
            System.out.println("=================================");

            System.out.println(
                    "Mobile       : "
                    + bestMobile.getName()
            );

            System.out.println(
                    "Price        : ₹"
                    + bestMobile.getPrice()
            );

            System.out.println(
                    "Camera       : "
                    + bestMobile.getCamera()
            );

            System.out.println(
                    "Battery      : "
                    + bestMobile.getBattery()
            );

            System.out.println(
                    "Performance  : "
                    + bestMobile.getPerformance()
            );

            System.out.println(
                    "Best Score   : "
                    + bestScore
            );

            System.out.println("=================================");
        }

        sc.close();
    }
}
