package ransom.note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean b = canConstruct(ransomNote, magazine);
        System.out.println(b);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineCharArray = magazine.toCharArray();

        List<Character> magazineCharList = new ArrayList<>();

        for (char c : magazineCharArray) {
            magazineCharList.add(c);
        }

        List<Character> ransomNoteList = ransomNote.chars()
                .mapToObj(c -> (char) c) // Zamiana int na char
                .collect(Collectors.toList());


        Iterator<Character> iterator = ransomNoteList.iterator();
        while (iterator.hasNext()) {
            Character c = iterator.next();
            if (magazineCharList.contains(c)) {
                magazineCharList.remove(c);
                iterator.remove(); // Usuwanie za pomocą iteratora
            }
        }
        return ransomNoteList.isEmpty();

    }
}
