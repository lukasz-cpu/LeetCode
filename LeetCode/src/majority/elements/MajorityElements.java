package majority.elements;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};


        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        // Pierwsze przejście - znajdowanie kandydata
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Ponieważ zakłada się, że element majority zawsze istnieje,
        // nie musimy robić drugiego przebiegu do weryfikacji.

        return candidate;
    }


//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> liczbaILiczbaWystapien = new HashMap<>();
//
//        for (int num : nums) {
//            liczbaILiczbaWystapien.put(num, liczbaILiczbaWystapien.getOrDefault(num, 0) + 1);
//        }
//
//        int n = nums.length;
//        int majorityCount = n / 2;
//
//        for (Map.Entry<Integer, Integer> entry : liczbaILiczbaWystapien.entrySet()) {
//            if (entry.getValue() > majorityCount) {
//                // Zwracamy element, który spełnia warunek majority
//                return entry.getKey();
//            }
//        }
//
//        return -1;
//    }
}
