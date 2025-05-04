package GraphPreparations.practice.day16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    
    // It's used to find single source shortest path.
    // It's a greedy algorithm - meaning it makes optimised decision during each step by choosing less weighted edges.
    // It works on positive weighted graph and cycle irrespective of directionality.
    // It doesn't support negative edges, negative weighted cycle.
    public void executeDijkstra(Integer startVertex, AdjacencyList adjacencyList) {
        Integer[] shortestDistance = new Integer[adjacencyList.getNumberOfVertices()];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[startVertex] = 0;
        pq.offer(new Integer[]{startVertex, 0});

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            if (current[1] > shortestDistance[current[0]]) continue;
            int currentVertex = current[0], currentWeight = current[1];
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                int neighborVertex = neighbor[0], neighborWeight = neighbor[1];
                if (currentWeight + neighborWeight < shortestDistance[neighborVertex]) {
                    shortestDistance[neighborVertex] = currentWeight + neighborWeight;
                    pq.offer(new Integer[]{neighborVertex, shortestDistance[neighborVertex]});
                }
            }
        }

        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            System.out.println(i + " - " + shortestDistance[i]);
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, true, true);
        adjacencyList.addEdge(0, 1, 4);
        adjacencyList.addEdge(0, 2, 4);
        adjacencyList.addEdge(1, 2, 2);
        adjacencyList.addEdge(2, 3, 3);
        adjacencyList.addEdge(2, 4, 1);
        adjacencyList.addEdge(3, 5, 2);
        adjacencyList.addEdge(4, 5, 3);
        adjacencyList.displayGraph();

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.executeDijkstra(0, adjacencyList);
    }
}
