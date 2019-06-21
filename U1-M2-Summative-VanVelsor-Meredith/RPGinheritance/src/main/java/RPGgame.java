public class RPGgame {
    public static void main(String[] args) {
        Constable constable = new Constable();
        Warrior warrior = new Warrior();
        Farmer farmer = new Farmer();

        warrior.decreaseHealth(10);
        warrior.run();

        /*
        This class was to show and confirm these objects will instantiate.
         */

    }
}
