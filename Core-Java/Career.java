
public class Career {

    private String name;
    private String skill;
    private int salary;
    private int demand;
    private int difficulty;


    // Constructor
    public Career(String name, String skill,
                  int salary, int demand, int difficulty) {

        this.name = name;
        this.skill = skill;
        this.salary = salary;
        this.demand = demand;
        this.difficulty = difficulty;
    }


    // Getters

    public String getName() {
        return name;
    }


    public String getSkill() {
        return skill;
    }


    public int getSalary() {
        return salary;
    }


    public int getDemand() {
        return demand;
    }


    public int getDifficulty() {
        return difficulty;
    }


    // toString

    @Override
    public String toString() {

        return "Career [name=" + name
                + ", skill=" + skill
                + ", salary=" + salary
                + ", demand=" + demand
                + ", difficulty=" + difficulty + "]";
    }
}

