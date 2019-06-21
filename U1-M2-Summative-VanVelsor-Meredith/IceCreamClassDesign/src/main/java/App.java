public class App {
    public static void main(String[] args) {

        // this is app is instantiating the factory and shop and utilizing
        IceCreamFactory factory = new IceCreamFactory();
        IceCreamShop shop = new IceCreamShop();

        // factory custom methods
        System.out.println(factory.totalCost(2.29f, 2));
        System.out.println(factory.churning());

        // shop custom methods
        System.out.println(shop.totalCost(2.50f,2));
        System.out.println(shop.printReceipt());

        /*
        'f' is for float to recognize as it would be seen as a double otherwise.
        'new' instantiates objects in line 3 and 4.
        sout lines about utilize methods in the listed classes.
         */

    }
}
