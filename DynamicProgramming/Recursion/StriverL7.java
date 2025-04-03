package DynamicProgramming.Recursion;

import java.util.ArrayList;
import java.util.List;

public class StriverL7 {

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

    public static void main(String[] args) {
        int[] input = {1, 2, 1};
        subseqEqualK(0, input, new ArrayList<>(), 0, 2);
        System.out.println("Finding only one answer : ");
        singleSubseqEqualK(0, input, new ArrayList<>(), 0, 2);
    }
}
