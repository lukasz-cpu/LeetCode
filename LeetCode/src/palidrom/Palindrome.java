package palidrom;

public class Palindrome {
    public static void main(String[] args) {
        String input = "abba";
        String sanitized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(isPalindrome(sanitized));
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
