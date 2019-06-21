public class IceCreamFactory {
    // custom ice cream factory properties
    private String flavor;
    private float ingredientCost;
    private int gallonsIceCream;
    private int numOfMachines;
    private int numEmployees;

    //custom shop methods
    public String churning(){
        return "Churn, Baby, churn.";
    }

    public float totalCost(float ingredientCost, int gallonsIceCream){
        return ingredientCost * gallonsIceCream;
    }


    //need this default constructor to instantiate in App class
    public IceCreamFactory() {
    }


    //constructor (could use this to instantiate too, but must fill in parameters)
    public IceCreamFactory(String flavor, float ingredientCost, int gallonsIceCream, int numOfMachines, int numEmployees) {
        this.flavor = flavor;
        this.ingredientCost = ingredientCost;
        this.gallonsIceCream = gallonsIceCream;
        this.numOfMachines = numOfMachines;
        this.numEmployees = numEmployees;
    }


    //getters and setters
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public float getIngredientCost() {
        return ingredientCost;
    }

    public void setIngredientCost(float ingredientCost) {
        this.ingredientCost = ingredientCost;
    }

    public int getGallonsIceCream() {
        return gallonsIceCream;
    }

    public void setGallonsIceCream(int gallonsIceCream) {
        this.gallonsIceCream = gallonsIceCream;
    }

    public int getNumOfMachines() {
        return numOfMachines;
    }

    public void setNumOfMachines(int numOfMachines) {
        this.numOfMachines = numOfMachines;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }
}
