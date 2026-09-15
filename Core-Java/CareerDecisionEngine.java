
import java.util.ArrayList;
import java.util.Scanner;

public class CareerDecisionEngine {

    // Calculate Career Score
    public int calculateScore(
            Career career,
            int requiredDemand,
            int maximumDifficulty) {

        int score = 0;

        // Demand matching
        if (career.getDemand() >= requiredDemand) {
            score += 10;
        }

        // Difficulty matching
        if (career.getDifficulty() <= maximumDifficulty) {
            score += 10;
        }

        // Add actual demand
        score += career.getDemand();

        // Add salary points
        score += career.getSalary() / 100000;

        return score;
    }


    // Find Best Career
    public Career findBestCareer(
            ArrayList<Career> careers,
            int requiredDemand,
            int maximumDifficulty) {

        Career bestCareer = careers.get(0);

        int bestScore =
                calculateScore(
                        bestCareer,
                        requiredDemand,
                        maximumDifficulty
                );

        for (Career career : careers) {

            int score =
                    calculateScore(
                            career,
                            requiredDemand,
                            maximumDifficulty
                    );

            if (score > bestScore) {

                bestScore = score;
                bestCareer = career;
            }
        }

        return bestCareer;
    }


    // Main Method
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   SMART DECISION ASSISTANT");
        System.out.println("       CAREER RECOMMENDER");
        System.out.println("=================================");


        // Create Careers

        Career c1 =
                new Career(
                        "Java Developer",
                        "Java",
                        600000,
                        9,
                        7
                );

        Career c2 =
                new Career(
                        "Web Developer",
                        "HTML CSS",
                        500000,
                        8,
                        6
                );

        Career c3 =
                new Career(
                        "Data Analyst",
                        "SQL",
                        550000,
                        9,
                        7
                );

        Career c4 =
                new Career(
                        "Software Tester",
                        "Testing",
                        450000,
                        8,
                        5
                );

        Career c5 =
                new Career(
                        "AI Developer",
                        "Python",
                        800000,
                        10,
                        9
                );


        // ArrayList

        ArrayList<Career> careers =
                new ArrayList<>();

        careers.add(c1);
        careers.add(c2);
        careers.add(c3);
        careers.add(c4);
        careers.add(c5);


        // Scanner

        Scanner sc = new Scanner(System.in);


        // User Requirements

        System.out.print(
                "Enter minimum demand level (6-10): "
        );

        int requiredDemand = sc.nextInt();


        System.out.print(
                "Enter maximum difficulty level (5-9): "
        );

        int maximumDifficulty = sc.nextInt();


        // Create Engine

        CareerDecisionEngine engine =
                new CareerDecisionEngine();


        // Find Best Career

        Career bestCareer =
                engine.findBestCareer(
                        careers,
                        requiredDemand,
                        maximumDifficulty
                );


        // Calculate Score

        int bestScore =
                engine.calculateScore(
                        bestCareer,
                        requiredDemand,
                        maximumDifficulty
                );


        // Final Recommendation

        System.out.println();

        System.out.println("=================================");
        System.out.println("       RECOMMENDED CAREER");
        System.out.println("=================================");

        System.out.println(
                "Career       : "
                + bestCareer.getName()
        );

        System.out.println(
                "Main Skill   : "
                + bestCareer.getSkill()
        );

        System.out.println(
                "Salary       : ₹"
                + bestCareer.getSalary()
        );

        System.out.println(
                "Demand       : "
                + bestCareer.getDemand()
        );

        System.out.println(
                "Difficulty   : "
                + bestCareer.getDifficulty()
        );

        System.out.println(
                "Best Score   : "
                + bestScore
        );

        System.out.println("=================================");


        sc.close();
    }
}

