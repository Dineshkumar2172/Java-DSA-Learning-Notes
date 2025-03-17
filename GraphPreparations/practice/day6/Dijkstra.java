package GraphPreparations.practice.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public void executeDijkstra(int srcVertex, List<List<Integer[]>> adjList) {
        Integer[] shortestPath = new Integer[adjList.size()];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[srcVertex] = 0;
        pq.offer(new Integer[]{srcVertex, 0});

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            int currentVertex = current[0], currentweight = current[1];
            if (currentweight > shortestPath[currentVertex]) continue;
            for (Integer[] neigh: adjList.get(currentVertex)) {
                if (currentweight + neigh[1] < shortestPath[neigh[0]]) {
                    shortestPath[neigh[0]] = currentweight + neigh[1];
                    pq.offer(new Integer[]{neigh[0], shortestPath[neigh[0]]});
                }
            }
        }

        System.out.println("Shortest path from the vertex : " + srcVertex);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("To vertex " + i + ": " + shortestPath[i]);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {
            {0, 1, 4},  // Edge from 0 to 1 with weight 4
            {0, 2, 1},  // Edge from 0 to 2 with weight 1
            {0, 3, 7},  // Edge from 0 to 3 with weight 7
            {1, 2, 2},  // Edge from 1 to 2 with weight 2
            {1, 4, 5},  // Edge from 1 to 4 with weight 5
            {2, 3, 3},  // Edge from 2 to 3 with weight 3
            {2, 4, 1},  // Edge from 2 to 4 with weight 1
            {3, 4, 1}   // Edge from 3 to 4 with weight 1
        };

        List<List<Integer[]>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) adjList.get(edge[0]).add(new Integer[]{edge[1], edge[2]});
        for (int[] edge: edges) adjList.get(edge[1]).add(new Integer[]{edge[0], edge[2]});

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.executeDijkstra(0, adjList);
    }
}
