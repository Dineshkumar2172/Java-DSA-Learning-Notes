package GraphPreparations.practice.day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {

    public void executePrims(int v, int[][] graph) {
        boolean[] visited = new boolean[v];
        Integer[] parent = new Integer[v];
        Integer[] minEdgeWeights = new Integer[v];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));

        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);
        minEdgeWeights[0] = 0;
        parent[0] = -1;
        pq.offer(new Integer[]{0, 0});

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            int currentVertex = current[0], currentWeight = current[1];
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;
            for (int i = 0; i < v; i++) {
                if (!visited[i] && graph[currentVertex][i] != Integer.MAX_VALUE && graph[currentVertex][i] < minEdgeWeights[i]) {
                    minEdgeWeights[i] = graph[currentVertex][i];
                    parent[i] = currentVertex;
                    pq.offer(new Integer[]{i, graph[currentVertex][i]});
                }
            }
        }

        Integer mstTotalWeight = 0;
        for (int i = 1; i < v; i++) {
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
