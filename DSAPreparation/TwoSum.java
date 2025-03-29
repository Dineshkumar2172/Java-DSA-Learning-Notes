package DSAPreparation;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // key will be the difference / compliment and value will be its index.
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (hashmap.containsKey(difference)) {
                return new int[]{hashmap.get(difference), i};
            }

            hashmap.put(nums[i], i);
        }

        return new int[2];
    }
}
