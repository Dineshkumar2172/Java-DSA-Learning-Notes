package DSAPreparation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, Set<Integer>> hashmap = new HashMap<>();
        for (int[] point: points) {
            if (!hashmap.containsKey(point[0])) {
                hashmap.put(point[0], new HashSet<Integer>());
            }

            hashmap.get(point[0]).add(point[1]);
        }

        Integer minimumArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int x1 =  points[i][0], y1 = points[i][1];
                int x2 =  points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    if (hashmap.get(x1).contains(y2) && hashmap.get(x2).contains(y1)) {
                        minimumArea = Math.min(minimumArea, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                    }
                }
            }
        }

        return minimumArea != Integer.MAX_VALUE ? minimumArea : 0;
    }
}
