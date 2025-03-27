package DSAPreparation;

import java.util.ArrayList;
import java.util.List;

public class FinalAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                duplicates.add(Math.abs(nums[i]));
                continue;
            }

            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }

        return duplicates;
    }
}
