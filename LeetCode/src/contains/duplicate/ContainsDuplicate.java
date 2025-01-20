package contains.duplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int input[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(input));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mapWithNumbers = new HashMap<>();
        for (Integer value : nums) {
            int check = mapWithNumbers.getOrDefault(value, 0) + 1;
            if(check > 1) {
                return true;
            }
            mapWithNumbers.put(value, check);
        }

        return false;
    }
}
