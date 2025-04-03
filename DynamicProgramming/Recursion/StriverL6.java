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
        
        // take the particular index into the subsequence
        curr.add(nums[idx]);
        findSubsequence(idx+1, nums, curr);

        // not take condition, this element is not added to your subsequence
        curr.remove(curr.size() - 1);
        findSubsequence(idx+1, nums, curr);
    }

     
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        findSubsequence(0, nums, new ArrayList<>());
    }
}
