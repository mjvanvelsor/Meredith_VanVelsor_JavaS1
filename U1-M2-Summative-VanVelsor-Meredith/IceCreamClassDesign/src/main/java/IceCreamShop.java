public class IceCreamShop {
    // custom ice cream shop properties
    private float pricePerCup;
    private String flavor;
    private int numCups;
    private int numCustomers;
    private String coneFlavor;

    //custom shop methods

    public float totalCost(float pricePerCup, int numCups){
        return pricePerCup * numCups;
    }

    public String printReceipt(){
        return "Here's your receipt. Thanks for shopping!";
    }


    //need this default constructor to instantiate in App class
    public IceCreamShop() {
    }

    //constructor (could use this to instantiate too, but must fill in parameters)
    public IceCreamShop(float pricePerCup, String flavor, int numCups) {
        this.pricePerCup = pricePerCup;
        this.flavor = flavor;
        this.numCups = numCups;
    }

    //getters and setters
    public float getPricePerCup() {
        return pricePerCup;
    }

    public void setPricePerCup(float pricePerCup) {
        this.pricePerCup = pricePerCup;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getNumCups() {
        return numCups;
    }

    public void setNumCups(int numCups) {
        this.numCups = numCups;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public String getConeFlavor() {
        return coneFlavor;
    }

    public void setConeFlavor(String coneFlavor) {
        this.coneFlavor = coneFlavor;
    }
}
