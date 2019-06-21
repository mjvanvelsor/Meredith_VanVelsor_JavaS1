public class Warrior extends Character {
    //special property to just warrior
    private int shieldStrength;

    // need super because this will bring all methods from character into child class
    public Warrior() {
        super();
    }

    // shield strength is special to warrior, this is a constructor statement
    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super(name, strength, health, stamina, speed, attackPower);
        this.shieldStrength = shieldStrength;
        this.name = name;
        this.strength = 75;
        this.health = 100;
        this.stamina = 100;
        this.speed = 50;
        this.attackPower = 10;
        this.shieldStrength = 100;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public int decreaseShieldStrength(int shieldStrength){
        return shieldStrength - 10;
    }
}
