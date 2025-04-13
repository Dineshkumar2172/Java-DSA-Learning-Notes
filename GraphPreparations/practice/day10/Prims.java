package GraphPreparations.practice.day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {
    public void executePrims(int vertices, int[][] graph) {
        boolean[] visited = new boolean[vertices];
        Integer[] minWeights = new Integer[vertices];
        Arrays.fill(minWeights, Integer.MAX_VALUE);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1])); // min heap
        pq.offer(new Integer[]{0, 0}); // vertex, weight

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            int currentVertex = current[0], currentWeight = current[1];
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;
            for (int i = 0; i < vertices; i++) {
                if (graph[currentVertex][i] != 0 && !visited[i] && graph[currentVertex][i] < minWeights[i]) {
                    minWeights[i] = graph[currentVertex][i];
                    pq.offer(new Integer[]{i, minWeights[i]});
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println((minWeights[i] == Integer.MAX_VALUE ? "INF" : minWeights[i]) + "");
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
