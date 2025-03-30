package maximum.subarray;

public class MaximumSubArray {
    public static void main(String[] args)  {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;   // Dodajemy bieżący element do okna
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
