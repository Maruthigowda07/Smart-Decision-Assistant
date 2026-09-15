
public class Travel {

    private String destination;
    private int budget;
    private int duration;
    private int adventure;
    private int relaxation;


    // Constructor
    public Travel(String destination, int budget,
                  int duration, int adventure,
                  int relaxation) {

        this.destination = destination;
        this.budget = budget;
        this.duration = duration;
        this.adventure = adventure;
        this.relaxation = relaxation;
    }


    // Getters

    public String getDestination() {
        return destination;
    }


    public int getBudget() {
        return budget;
    }


    public int getDuration() {
        return duration;
    }


    public int getAdventure() {
        return adventure;
    }


    public int getRelaxation() {
        return relaxation;
    }


    // toString

    @Override
    public String toString() {

        return "Travel [destination=" + destination
                + ", budget=" + budget
                + ", duration=" + duration
                + ", adventure=" + adventure
                + ", relaxation=" + relaxation + "]";
    }
}
