package DSAPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return result;
        
        HashMap<Integer, List<Character>> hashmap = new HashMap<>();
        hashmap.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        hashmap.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        hashmap.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        hashmap.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        hashmap.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        hashmap.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        hashmap.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        hashmap.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        
        backTrack(0, digits, new StringBuilder(), hashmap, result);
        return result;
    }

    public void backTrack(
        int idx, String digits, StringBuilder sb, HashMap<Integer, 
        List<Character>> hashmap, List<String> result) {

            if (idx == digits.length()) {
                result.add(sb.toString());
                return;
            }

            List<Character> indexCharacters = hashmap.get(Integer.parseInt(""+digits.charAt(idx)));
            for (Character chr: indexCharacters) {
                sb.append(chr);
                backTrack(idx+1, digits, sb, hashmap, result);
                sb.deleteCharAt(sb.length() - 1);
            }

    }
}
