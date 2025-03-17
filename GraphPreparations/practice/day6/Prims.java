package GraphPreparations.practice.day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {

    public void executePrims (int v, int[][] graph) {
        boolean[] visitedVertices = new boolean[v];
        Integer[] parent = new Integer[v];
        Integer[] minEdgeWeights = new Integer[v];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));

        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);
        pq.offer(new Integer[]{0, 0});
        parent[0] = -1;

        int totalMstWeight = 0;
        
    }

    public static void main(String[] args) {
        int vertices = 5;
        int[][] graph = {
            {0, 2, Integer.MAX_VALUE, 6, Integer.MAX_VALUE},
            {2, 0, 3, 8, 5},
            {Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE, 7},
            {6, 8, Integer.MAX_VALUE, 0, 9},
            {Integer.MAX_VALUE, 5, 7, 9, 0}
        };

        Prims prims = new Prims();
        prims.executePrims(vertices, graph);
    }
}
