package two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    //First solution
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int y = i + 1; y <= nums.length - 1; y++) {
                if (nums[i] + nums[y] == target) {
                    return new int[]{i, y};
                }
            }
        }
        return new int[]{};
    }

    //Second solution
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{};
    }
}