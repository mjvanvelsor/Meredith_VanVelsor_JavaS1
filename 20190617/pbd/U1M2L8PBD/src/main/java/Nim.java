import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String A = "   A : ";
        String B = "   B : ";
        String C = "   C : ";

        int counterA = 3;
        int counterB = 3;
        int counterC = 3;

        int userNum;
        String winner;

        System.out.print("Player 1, enter your name: ");
        String player1 = myScanner.nextLine();
        System.out.print("Player 2, enter your name: ");
        String player2 = myScanner.nextLine();

        String userPile;

        System.out.println(A + counterA + B + counterB + C + counterC + "\n");

        do {

            //player 1
            System.out.print(player1 + ", choose a pile: ");
            userPile = myScanner.nextLine();

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

                if (counterA <= 0 && counterB <= 0 && counterC <= 0) {
                    winner = player1;
                    System.out.println(winner + ", there are no counters left, so you WIN!");
                    break;
                }

            //player 2
            System.out.print(player2 + ", choose a pile: ");
            userPile = myScanner.nextLine();

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

            if (counterA <= 0 && counterB <= 0 && counterC <= 0) {
                winner = player2;
                System.out.println(winner + ", there are no counters left, so you WIN!");
                break;
            }

        } while (counterA > 0 || counterB > 0 || counterC > 0);

        System.out.println("All piles are empty. Good Job!");
    }
}
