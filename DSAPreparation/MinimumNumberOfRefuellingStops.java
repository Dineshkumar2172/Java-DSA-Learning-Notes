package DSAPreparation;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuellingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // our initial fuel capacity is already enough to travel to target dest
        if (startFuel >= target) return 0;

        // initialising max heap to access fuel station with max capacity within our range
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0, maxDistance = startFuel, stops = 0;
        // if our current fuel capacity is not enough to travel till target distance
        while (maxDistance < target) {
            if (i < stations.length && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]); // update fuel capacity with maxheap
                i++; // mark our first station as visited
            } else if (!maxHeap.isEmpty()) { // if we have fuel capacity to increase our range
                maxDistance += maxHeap.poll(); // increase our range by pumping more fuel to our distance
                stops++; // increase the stops since we stopped here for refuelling
            } else {
                // if we don't have any stations to increase our fuel capacity to reach next station
                // then we are stuck - travelling to target is not possible.
                return -1; 
            }
        }

        return stops;
    }
}
