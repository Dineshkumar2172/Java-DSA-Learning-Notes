package GraphPreparations.practice.day9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {

    public void executePrims(int vertex, int[][] graph) {
        boolean[] visited = new boolean[vertex];
        Integer[] parent = new Integer[vertex];
        Integer[] minEdgeWeights = new Integer[vertex];

        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        minEdgeWeights[0] = 0;
        pq.offer(new Integer[]{0, 0});

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            int currentVertex = current[0];
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;
            for (int i = 0; i < vertex; i++) {
                if (graph[currentVertex][i] != Integer.MAX_VALUE && !visited[i] && graph[currentVertex][i] < minEdgeWeights[i]) {
                    parent[i] = currentVertex;
                    minEdgeWeights[i] = graph[currentVertex][i];
                    pq.offer(new Integer[]{i, graph[currentVertex][i]});
                }
            }
        }

        for (int i = 0; i < vertex; i++) {
            System.out.println(parent[i] + " - " + i + " ( weight: " + minEdgeWeights[i] + " )");
        }
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
