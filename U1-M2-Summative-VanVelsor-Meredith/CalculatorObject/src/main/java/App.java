public class App {

    public static void main(String[] args) {

    Calculator calculator = new Calculator();

        System.out.println(calculator.add(1,1));
        System.out.println(calculator.subtract(23,52));
        System.out.println(calculator.multiply(34,2));
        System.out.println(calculator.divide(12,3));
        System.out.println(calculator.divide(12d,7d));
        System.out.println(calculator.add(3.4d, 2.3d));
        System.out.println(calculator.multiply(6.7d,4.4d));
        System.out.println(calculator.subtract(5.5d,0.5d));
        System.out.println(calculator.divide(10.8d,2.2d));


    }
}
