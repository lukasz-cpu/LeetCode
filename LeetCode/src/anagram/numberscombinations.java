package anagram;

import java.util.ArrayList;
import java.util.List;

public class numberscombinations {
    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 0;

        List<Integer> combinations = new ArrayList<Integer>();

        for (int i = 0; i <= 9; i++) {
            for (int y = 0; y <= 9; y++) {
                for (int z = 0; z <= 9; z++) {
                    String number = String.valueOf(i) + String.valueOf(y) + String.valueOf(z);
                    combinations.add(Integer.valueOf(number));
                }
            }

        }

        System.out.println(combinations.size());

    }
}
