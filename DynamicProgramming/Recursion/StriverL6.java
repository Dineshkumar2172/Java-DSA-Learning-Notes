package DynamicProgramming.Recursion;

import java.util.ArrayList;
import java.util.List;

public class StriverL6 {
     /*********************************** RECURSION ON SUBSEQUENCES ***********************************/

    // reference - https://youtu.be/AxNNVECce8c?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
    // 1. Print all subsequences - (a contiguous / non-contiguous sequences which follows the order)
    // For a note: a subarray is contiguous, but a subsequence can be contiguous or non-contiguous
    public static void findSubsequence(int idx, int[] nums, List<Integer> curr) {
        if (idx >= nums.length) {
           System.out.println(curr.toString());
           return;
        }

        for (int i = idx + 1; i < nums.length; i++) {
            curr.add(nums[idx]); // take
            findSubsequence(i + 1, nums, curr);
            curr.remove(curr.size() - 1); // not - take
        }
    }

     
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        findSubsequence(0, nums, new ArrayList<>());
    }
}
