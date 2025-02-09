import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        System.out.println(dynamicProgramming.fibonacci(4)); // calculate fibonacci number in a series
        int[] arr = {4, 3, -2, 6, -12, 7, -1, 6};
        System.out.println(dynamicProgramming.maxSumSubarray(arr)); // calculate maximum sum in a given array
        int[] arr2 = {2, 11, 5, 10, 7, 8};
        int[] result = dynamicProgramming.findTwoSum(arr2, 9);
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(dynamicProgramming.isSubsequence("abcde", "ace")); // find if a string is subsequence of original string
        System.out.println(dynamicProgramming.firstNonRepeatingCharacter("racecars")); // find first no repeating character
        System.out.println(dynamicProgramming.removeVowels("what is your name?")); // remove all the vowels from the input string
        System.out.println(dynamicProgramming.reverseInteger(4562)); // reverse an integer
        int[] arr3 = {44, 77, 33, 44, 88, 11};
        List<Integer> arr4 = dynamicProgramming.slidingWindowMax(arr3, 3);
        for (Integer integer : arr4) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }

    public int fibonacci(int n){
        int[] table = new int[n + 1]; // using tabular method instead of recursion
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i-1] + table[i-2];   
        }

        return table[n];
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=149173
    public int maxSumSubarray(int[] arr){
        // two checks
        //      1. Should I become part of current subarray?
        //      2. Should I start a new subarray?
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentMax = currentMax + arr[i]; // check 1 - element become part of the current subarray
            if (currentMax < arr[i]) {
                currentMax = arr[i]; // check 2 - element decides to start its own subarray
            }

            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
        }

        return maxSoFar;
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=151963
    public int[] findTwoSum(int arr[], int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - arr[i]);
                return result;
            }
        }

        return result;
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=154470
    public boolean isSubsequence(String originalString, String seq){
        // Subsequence
        // A subsequence of a string is a new string formed from the original string
        // by deleting some or no characters without changing the order of remaining characters.
        // example:
        //      "ace" is a subsequence of "abcde"
        //      "aec" is not a subsequence of "abcde"

        int i = 0;
        int j = 0;
        while (i < originalString.length() && j < seq.length()) {
            if (originalString.charAt(i) == seq.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == seq.length();
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=156147
    public int firstNonRepeatingCharacter(String str){
        // Given a string s, return the index of first non-repeating character in it.
        // If it does not exist, return -1. The string will only contain lowercase letters.
        // Example:
        //      Input - "codeforcode"
        //      Output - 4
        //      Explanation - The first non-repeating character is 'f' and is found at index 4
        //
        // Example:
        //      Input - "aabb"
        //      Output - -1
        //      Explanation - It doesn't have any non repeating character

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        // build a hashmap of characters and their occurence count.
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            // the first character with occurence count 1 should be returned
            if (map.get(chars[i]) == 1) {
                return i; // index of the first non repeating character
            }   
        }

        return -1;
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=157734
    public String removeVowels(String str){
        // Given a string, remove the vowels from the string and return the string without vowels.
        // The string will contains only lowercase letters.
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();

        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            // filter all the vowels from the input string
            if (!vowels.contains(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=158654
    public long reverseInteger(int number){
        boolean isNegative = number < 0;
        if (isNegative) {
            number = number * -1;
        }

        long reverse = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number%10;
            reverse = reverse*10 + lastDigit;
            number = number/10;
        }
    
        return isNegative ? reverse*-1 : reverse;
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=161942
    public int[] threeSum(int[] arr, int target){
        // Given an array of distinct integers, print all such triplets such that they
        // add up to a specific target. The triplet should be ordered in ascending order.
        return arr;
    }


    // reference - https://youtu.be/2ZLl8GAk1X4?t=163360
    public int[] productExcept(int[] arr){
        // Given an array of integers arr[], return an array result[] such that result[i] is equal
        // to the product of all the elements of arr except arr[i]. The product first in 32-bit integer.
        // This algorithm should run in O(n) time and without using division operator.
        // Example:
        //      Input: arr = {1, 2, 3, 4}
        //      Output: result = {24, 12, 8, 6}
        int temp = 1;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = temp;
            temp = temp *  arr[i];
        }

        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp *  arr[i];            
        }

        return result;
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=164711
    public List<Integer> slidingWindowMax(int[] arr, int k){
        // Given an array of integers arr, there is a sliding window of size k which is moving from the
        // very left of the array to the very right. You can only see the k numbers in the window. Each time
        // the sliding window moves right by one position. Return the max sliding window.

        int[] ngeArr =  nextGreaterElement(arr);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= arr.length - k; i++) {
            int j = i;
            while (ngeArr[j] < i+k) {
                j = ngeArr[j];
            }
            result.add(arr[j]);
        }
        return result;
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=165640
    public int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i --){
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }

        return result;
    }
}
