public class Constable extends Character {

    //special property to just constable
    private String jurisdiction;

    // need super because this will bring all methods from character into child class
    public Constable() {
        super();
    }

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction) {
        super(name, strength, health, stamina, speed, attackPower);
        this.jurisdiction = jurisdiction;
        this.name = name;
        this.strength = 60;
        this.health = 100;
        this.stamina = 60;
        this.speed = 20;
        this.attackPower = 5;
    }

    //special method to just constable
    public void arrest(){
        System.out.println("You are under arrest.");
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
