package valid.palidrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidPalidrome {
    public static void main(String[] args) {
        String s = "A man, a plan,  canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String normalized = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] normalizedCharArray = normalized.toCharArray();

        List<String> reversedSequence = new ArrayList<>();

        for (int i = normalizedCharArray.length - 1; i >= 0; i--) {
            reversedSequence.add(String.valueOf(normalizedCharArray[i]));
        }

        char[] reversedCharArray = new char[normalizedCharArray.length];


        for (int y = 0; y < reversedCharArray.length; y++) {
            reversedCharArray[y] = reversedSequence.get(y).toCharArray()[0];
        }

        return Arrays.equals(reversedCharArray, normalizedCharArray);
    }
}
