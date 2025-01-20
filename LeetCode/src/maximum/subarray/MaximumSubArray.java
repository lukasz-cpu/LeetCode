package maximum.subarray;

public class MaximumSubArray {
    public static void main(String[] args)  {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};


        System.out.println(maxSubArray(nums1));

    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }


        return maxSum;
    }
}
