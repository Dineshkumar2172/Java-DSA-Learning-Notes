import java.util.HashMap;
import java.util.Map;

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
}
