package longest.palidrom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s1 = "aaaa";

        //dcc c ccd
        //dcc a ccd
        //dcc b ccd

        System.out.println(longestPalindrome(s1));

    }

    public static int longestPalindrome(String s) {
        Map<String, Integer> mapWithLetters = new HashMap<>();

        char[] sCharArray = s.toCharArray();
        if (sCharArray.length == 1) return 1;

        for (char c : sCharArray) {
            mapWithLetters.put(c + "", mapWithLetters.getOrDefault(c + "", 0) + 1);
        }

        Map<String, Integer> letterWithNumberOfParis = new HashMap<>();


        for (Map.Entry<String, Integer> letter : mapWithLetters.entrySet()) {
            String key = letter.getKey();
            Integer value = letter.getValue();
            int numberOfLetters = (value / 2) * 2;
            letterWithNumberOfParis.put(key, numberOfLetters);
        }

        Map<String, Integer> withoutPairs = new HashMap<>();
        List<Integer> numbersWithoutPairs = new ArrayList<>();



        for (Map.Entry<String, Integer> mapWithLetter : mapWithLetters.entrySet()) {
            String mapWithLetterKey = mapWithLetter.getKey();
            Integer value = mapWithLetter.getValue();
            Integer valueFromMapWithLetters = letterWithNumberOfParis.get(mapWithLetterKey);
            Integer valueFromMapWithLetters1 = value - valueFromMapWithLetters;
            withoutPairs.put(mapWithLetterKey, valueFromMapWithLetters1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : withoutPairs.entrySet()) {
            Integer t = stringIntegerEntry.getValue();
            if(t != 0){
                numbersWithoutPairs.add(t);
            }
        }

        System.out.println("Map with Letters: " + mapWithLetters);
        System.out.println("Map with pairs: " + letterWithNumberOfParis);
        System.out.println("Map without pairs: " + withoutPairs);
        System.out.println("List without pairs: " + numbersWithoutPairs);

        Integer result = 0;

        for (Map.Entry<String, Integer> stringIntegerEntry : letterWithNumberOfParis.entrySet()) {
            Integer value = stringIntegerEntry.getValue();
            result += value;
        }

        if(!numbersWithoutPairs.isEmpty()){
            result += 1;
        }


        return result;


    }
}
