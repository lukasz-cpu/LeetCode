package contains.duplicate;

import java.util.*;
import java.util.stream.Collectors;

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

    public static boolean containsDuplicate2(int[] nums) {
        Map<Integer, Long> mapWithNumbers = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        return mapWithNumbers.values().stream().anyMatch(count -> count > 1);
    }

    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate4(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    public boolean containsDuplicate5(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

}
