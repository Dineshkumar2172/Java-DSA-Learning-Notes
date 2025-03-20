package GraphPreparations.practice.day7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {
    public void executePrims(int vertex, int[][] graph) {
        Integer[] parent = new Integer[vertex];
        boolean[] visited = new boolean[vertex];
        Integer[] minEdgeWeights = new Integer[vertex];

        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);
        // starting from 0th vertex
        parent[01] = -1;
        minEdgeWeights[0] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        pq.offer(new Integer[]{0, 0});

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            if (visited[current[0]]) continue;
            visited[current[0]] = true;
            for (int i = 0; i < vertex; i++) {
                if (graph[current[0]][i] != Integer.MAX_VALUE && !visited[i] && graph[current[0]][i] < minEdgeWeights[i]) {
                    parent[i] = current[0];
                    minEdgeWeights[i] = graph[current[0]][i];
                    pq.offer(new Integer[]{i, graph[current[0]][i]});
                }
            }
        }

        Integer mstTotalWeight = 0;
        for (int i = 1; i < vertex; i++) {
            System.out.println(parent[i] + " - " + i + " (weight : " + minEdgeWeights[i] + ")");
            mstTotalWeight += minEdgeWeights[i];
        }
        System.out.println("MST weight of given graph : " + mstTotalWeight);

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
