package DynamicProgramming.Recursion;

import java.util.ArrayList;
import java.util.List;

public class StriverL7 {

    // Time complexity - 0(2^n) - for every index we have two options (two stacks) to pick it up or not pick it up. 
    // Space complexity - 0(n) - max stack created at a time is same as number of elements in an array. + also curr array which is 0(n) -> it becomes 0(2n) and 2 is constant so 0(n)

    // 1. printing subsequences whose sum is k
    public static void subseqEqualK(int idx, int[] nums, List<Integer> curr, int summ, int k) {
        if (idx >= nums.length) {
            if (summ == k) System.out.println(curr.toString());
            return;
        }

        // pick
        curr.add(nums[idx]);
        summ += nums[idx];
        subseqEqualK(idx+1, nums, curr, summ, k);

        // not pick
        curr.remove(curr.size() - 1);
        summ -= nums[idx];
        subseqEqualK(idx+1, nums, curr, summ, k);
    }

    // 2. Printing single subsequences whose sum is k
    public static boolean singleSubseqEqualK(int idx, int[] nums, List<Integer> curr, int summ, int k) {
        if (idx >= nums.length) {
            if (summ == k) {
                System.out.println(curr.toString());
                return true;
            }

            return false;
        }

        // pick
        curr.add(nums[idx]);
        summ += nums[idx];
        if(singleSubseqEqualK(idx+1, nums, curr, summ, k)) return true;

        // not pick
        curr.remove(curr.size() - 1);
        summ -= nums[idx];
        if(singleSubseqEqualK(idx+1, nums, curr, summ, k)) return true;
        
        return false;
    }

    // 3. Count all subsequence with sum = k; 
    public static int countSubseqEqualK(int idx, int[] nums, List<Integer> curr, int summ, int k) {
        if (idx >= nums.length) {
            if (summ == k) return 1;
            return 0;
        }

        // picking
        curr.add(nums[idx]);
        summ += nums[idx];
        int left = countSubseqEqualK(idx + 1, nums, curr, summ, k);
        
        // not picking
        curr.remove(curr.size() - 1);
        summ -= nums[idx];
        int right = countSubseqEqualK(idx + 1, nums, curr, summ, k);

        return left + right;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 1};
        subseqEqualK(0, input, new ArrayList<>(), 0, 2);
        System.out.println("Finding only one answer : ");
        singleSubseqEqualK(0, input, new ArrayList<>(), 0, 2);
        System.out.println("Counting number of subsequence equal to k : ");
        System.out.println(countSubseqEqualK(0, input, new ArrayList<>(), 0, 2));
    }
}
