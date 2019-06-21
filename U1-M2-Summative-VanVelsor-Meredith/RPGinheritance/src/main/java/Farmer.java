public class Farmer extends Character {

    // need super because this will bring all methods from character into child class
    public Farmer() {
        super();            // Tim had me add this.
    }

    // this is constructor with content, you can have several constructor (if needed)
    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);
        this.name = name;
        this.strength = 75;
        this.health = 100;
        this.stamina = 75;
        this.speed = 10;
        this.attackPower = 1;
    }

    //both of these are special to just farmer
    public void plow(){
        System.out.println("plowing... plowing... plowing...");
    }

    public void harvest(){
        System.out.println("corn" + "beans" + "wheat" + "tobacco" + "strawberries");
    }

}
