public class ConverterApplication {
    public static void main(String[] args) {

        /* ConverterInterface: Create your solution in an IntelliJ project called ConverterInterface.
            In this exercise you will create two different implementations of the following interface.
            The first implementation must use if/else/else if statements and be called ConverterIf.
            The second implementation must use switch statements and be called ConverterSwitch.
            Once you have your classes written, create a class called ConverterApplication which has your main method.
            In that main method, instantiate and use both the ConverterIf and ConverterSwitch classes.
         */

        ConverterIf dayOfWeekIf = new ConverterIf();
        ConverterIf monthOfYearIf = new ConverterIf();
        ConverterSwitch dayOfWeekSwitch = new ConverterSwitch();
        ConverterSwitch monthOfYearSwitch = new ConverterSwitch();

        System.out.println("\nThis is If/Else Method:");
        System.out.println(dayOfWeekIf.convertDay(1));
        System.out.println(monthOfYearIf.convertMonth(1));

        System.out.println("\nThis is Switch Method:");
        System.out.println(dayOfWeekSwitch.convertDay(1));
        System.out.println(monthOfYearSwitch.convertMonth(1));
    }
}
