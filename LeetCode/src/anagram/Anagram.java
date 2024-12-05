package anagram;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        char[] firstCharArray = s.toCharArray();
        char[] secondCharArray = t.toCharArray();

        List<String> firstArrayList = new ArrayList<>();
        List<String> secondArrayList = new ArrayList<>();

        for (char c : firstCharArray) {
            firstArrayList.add(String.valueOf(c));
        }

        for (char c : secondCharArray) {
            secondArrayList.add(String.valueOf(c));
        }

        Collections.sort(firstArrayList);
        Collections.sort(secondArrayList);

        return firstArrayList.equals(secondArrayList);

    }
}
