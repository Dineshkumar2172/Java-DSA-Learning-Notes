package DSAPreparation;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.offer(num);
        }

        for (int i = 0; i < nums.length - k; i++) pq.poll();

        return pq.poll();
    }
}
