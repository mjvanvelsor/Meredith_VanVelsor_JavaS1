import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GettingTheLargestValueInAnArrayList {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int ranNum = randomGenerator.nextInt(100) + 1;
            arrList.add(ranNum);
        }

        System.out.println("ArrayList: " + arrList);
        int largestNum = 0;

        for(int i = 0; i < arrList.size(); i++){
            if (arrList.get(i) > largestNum){
                largestNum = arrList.get(i);
            }
        }
        System.out.println("\nThe largest value is " + largestNum);

    }
}
