import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String A = "   A : ";
        String B = "   B : ";
        String C = "   C : ";

        int counterA = 3;
        int counterB = 3;
        int counterC = 3;

        int userNum;

        System.out.println(A + counterA + B + counterB + C + counterC + "\n");

        do {
            System.out.print("Choose a pile: ");
            String userPile = myScanner.nextLine();

            switch (userPile) {
                case "A":
                case "a":
                    System.out.print("How many to remove from pile A: ");
                    userNum = Integer.parseInt(myScanner.nextLine());
                     counterA -= userNum;

                     System.out.println(A + counterA + B + counterB + C + counterC + "\n");
                    break;
                case "B":
                case "b":
                    System.out.print("How many to remove from pile B: ");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    counterB -= userNum;

                    System.out.println(A + counterA + B + counterB + C + counterC + "\n");
                    break;
                case "C":
                case "c":
                    System.out.print("How many to remove from pile C: ");
                    userNum = Integer.parseInt(myScanner.nextLine());
                    counterC -= userNum;

                    System.out.println(A + counterA + B + counterB + C + counterC + "\n");
                    break;
            }

        } while (counterA > 0 || counterB > 0 || counterC > 0);

            System.out.println("All piles are empty. Good Job!");
    }
}

