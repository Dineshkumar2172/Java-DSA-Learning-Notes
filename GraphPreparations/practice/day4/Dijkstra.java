package GraphPreparations.practice.day4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphPreparations.practice.day1.AdjacencyList;

public class Dijkstra {

    public void executeDijkstra(int vertex, AdjacencyList adjacencyList) {
        Integer[] shortestPath = new Integer[adjacencyList.getNumberOfVertices()];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[vertex] = 0;

        pq.offer(new Integer[]{vertex, 0});
        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentWeight = current[1];

            if (currentWeight > shortestPath[currentVertex]) continue;

            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(currentVertex)) {
                // performing relaxation
                if (currentWeight + neigh[1] < shortestPath[neigh[0]]) {
                    shortestPath[neigh[0]] = currentWeight + neigh[1];
                    pq.offer(new Integer[]{neigh[0], shortestPath[neigh[0]]});
                }
            }
        }

        System.out.println("Shortest distance from vertex " + vertex + ": ");
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            System.out.println("To veretx " + i + ": " + shortestPath[i]);
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

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.executeDijkstra(0, adjacencyList);
    }
}
