package rescue.boats;

import java.util.Arrays;
import java.util.Collections;

public class RescueBoats {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;

        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
    }
}
