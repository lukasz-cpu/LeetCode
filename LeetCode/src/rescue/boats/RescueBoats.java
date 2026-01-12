package rescue.boats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RescueBoats {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1, 2, 3, 3, 1, 2};
        int limit = 3;

        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }

}



//        3
//        3
//        3
//        2
//        2
//        2
//        2
//        1
//        1