
import java.util.ArrayList;
import java.util.Scanner;

public class TravelDecisionEngine {

    // Calculate Travel Score
    public int calculateScore(
            Travel travel,
            int requiredAdventure,
            int requiredRelaxation) {

        int score = 0;

        // Adventure matching
        if (travel.getAdventure() >= requiredAdventure) {
            score += 10;
        }

        // Relaxation matching
        if (travel.getRelaxation() >= requiredRelaxation) {
            score += 10;
        }

        // Duration points
        score += travel.getDuration();

        // Adventure and relaxation points
        score += travel.getAdventure();
        score += travel.getRelaxation();

        return score;
    }


    // Filter by Budget
    public ArrayList<Travel> filterByBudget(
            ArrayList<Travel> travels,
            int budget) {

        ArrayList<Travel> filteredTravels =
                new ArrayList<>();

        for (Travel travel : travels) {

            if (travel.getBudget() <= budget) {
                filteredTravels.add(travel);
            }
        }

        return filteredTravels;
    }


    // Find Best Travel Destination
    public Travel findBestTravel(
            ArrayList<Travel> travels,
            int requiredAdventure,
            int requiredRelaxation) {

        Travel bestTravel = travels.get(0);

        int bestScore =
                calculateScore(
                        bestTravel,
                        requiredAdventure,
                        requiredRelaxation
                );

        for (Travel travel : travels) {

            int score =
                    calculateScore(
                            travel,
                            requiredAdventure,
                            requiredRelaxation
                    );

            if (score > bestScore) {

                bestScore = score;
                bestTravel = travel;
            }
        }

        return bestTravel;
    }


    // Main Method
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   SMART DECISION ASSISTANT");
        System.out.println("       TRAVEL RECOMMENDER");
        System.out.println("=================================");


        // Create Travel Destinations

        Travel t1 =
                new Travel(
                        "Goa",
                        15000,
                        3,
                        9,
                        7
                );

        Travel t2 =
                new Travel(
                        "Manali",
                        20000,
                        5,
                        10,
                        8
                );

        Travel t3 =
                new Travel(
                        "Kerala",
                        18000,
                        4,
                        7,
                        10
                );

        Travel t4 =
                new Travel(
                        "Ooty",
                        10000,
                        2,
                        6,
                        9
                );

        Travel t5 =
                new Travel(
                        "Jaipur",
                        12000,
                        3,
                        8,
                        8
                );


        // ArrayList

        ArrayList<Travel> travels =
                new ArrayList<>();

        travels.add(t1);
        travels.add(t2);
        travels.add(t3);
        travels.add(t4);
        travels.add(t5);


        // Scanner

        Scanner sc = new Scanner(System.in);


        // User Budget

        System.out.print("Enter your travel budget: ");
        int budget = sc.nextInt();


        // Adventure Requirement

        System.out.print(
                "Enter required adventure level (6-10): "
        );

        int requiredAdventure = sc.nextInt();


        // Relaxation Requirement

        System.out.print(
                "Enter required relaxation level (6-10): "
        );

        int requiredRelaxation = sc.nextInt();


        // Create Engine

        TravelDecisionEngine engine =
                new TravelDecisionEngine();


        // Filter by Budget

        ArrayList<Travel> filteredTravels =
                engine.filterByBudget(
                        travels,
                        budget
                );


        System.out.println();

        System.out.println("Destinations within your budget:");
        System.out.println("---------------------------------");


        for (Travel travel : filteredTravels) {

            System.out.println(
                    travel.getDestination()
                    + " - ₹"
                    + travel.getBudget()
            );
        }


        // No Destination Found

        if (filteredTravels.isEmpty()) {

            System.out.println();

            System.out.println(
                    "No destination found within your budget."
            );

        } else {


            // Find Best Travel

            Travel bestTravel =
                    engine.findBestTravel(
                            filteredTravels,
                            requiredAdventure,
                            requiredRelaxation
                    );


            // Calculate Score

            int bestScore =
                    engine.calculateScore(
                            bestTravel,
                            requiredAdventure,
                            requiredRelaxation
                    );


            // Final Recommendation

            System.out.println();

            System.out.println("=================================");
            System.out.println("       RECOMMENDED DESTINATION");
            System.out.println("=================================");


            System.out.println(
                    "Destination  : "
                    + bestTravel.getDestination()
            );


            System.out.println(
                    "Budget       : ₹"
                    + bestTravel.getBudget()
            );


            System.out.println(
                    "Duration     : "
                    + bestTravel.getDuration()
                    + " days"
            );


            System.out.println(
                    "Adventure    : "
                    + bestTravel.getAdventure()
            );


            System.out.println(
                    "Relaxation   : "
                    + bestTravel.getRelaxation()
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
