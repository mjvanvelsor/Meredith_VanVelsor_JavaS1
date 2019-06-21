import java.util.Scanner;

public class Character {
    // all of these properties were shared with the other classes.
    // This is the parent class and it is extended to the other classes.

    protected String name;
    protected int strength;
    protected int health;
    protected int stamina;
    protected int speed;
    protected int attackPower;

    // default constructor
    public Character() {
    }

    //constructor
    public Character(String name, int strength, int health, int stamina, int speed,
                     int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    // run method for ALL characters that are extended
    public void run(){
        System.out.println("Run, run, run!");
    }

    // attack method for ALL characters that are extended
    public void attack(){
        System.out.println("* Punch *");
    }

    // methods hard set with actions/values for each character/action
    public int heal(int hit){
        return health + 10;
    }
    public int decreaseHealth(int hit){
        return health - 10;
    }
    public int increaseStamina(int hit){
        return stamina + 10;
    }
    public int decreaseStamina(int hit){
        return stamina - 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
