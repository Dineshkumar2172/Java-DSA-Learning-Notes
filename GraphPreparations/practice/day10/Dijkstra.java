package GraphPreparations.practice.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public void executeDijsktra(int src, List<List<Integer[]>> adjList) {
        Integer[] shortestDistance = new Integer[adjList.size()];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        pq.offer(new Integer[]{src, 0});
        shortestDistance[src] = 0;

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            int currentVertex = current[0], currentWeight = current[1];

            if (currentWeight < shortestDistance[currentVertex]) continue;

            for (Integer[] neighbor: adjList.get(currentVertex)) {
                int neighborVertex = neighbor[0], neighborWeight = neighbor[1];
                int cost  = shortestDistance[currentVertex] + neighborWeight;
                if (cost < shortestDistance[neighborVertex]) {
                    pq.offer(new Integer[]{neighborVertex, cost});
                    shortestDistance[neighborVertex] = cost;
                }
            }
        }

        System.out.println("Shortest distance from vertex : " + src);
        for (int i = 0; i < adjList.size(); i++) {
            if  (shortestDistance[i] == Integer.MAX_VALUE) {
            System.out.println("To vertex " + i + ": INF");
            continue;
        }

        System.out.println("To vertex " + i + ": " + shortestDistance[i]);
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
        dijkstra.executeDijsktra(0, adjList);
    }
}
