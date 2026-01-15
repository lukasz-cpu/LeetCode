package product;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf(nums); 
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int zeroCount = 0;
        int product = 1;

        // Pierwsze przejście: policz produkt elementów niezerowych i liczbę zer
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                if (zeroCount > 1) return result;   // dwa zera → same zera
            } else {
                product *= num;
            }
        }

        System.out.println(product);
        
        // Drugie przejście: zbuduj wynik
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = (zeroCount == 1) ? product : 0;
            } else {
                result[i] = (zeroCount == 0) ? product / nums[i] : 0;
            }
        }

        return result;
    }

}
