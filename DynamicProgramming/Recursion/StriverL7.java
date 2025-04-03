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

        curr.add(nums[idx]);
        summ += nums[idx];
        subseqEqualK(idx+1, nums, curr, summ, k);
        curr.remove(curr.size() - 1);
        summ -= nums[idx];

        subseqEqualK(idx+1, nums, curr, summ, k);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 1};
        subseqEqualK(0, input, new ArrayList<>(), 0, 2);
    }
}
