package GraphPreparations.practice.day3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphPreparations.practice.day2.AdjacencyList;

public class Dijkstra {
    // works based on relaxation

    public void executeDijkstra(int vertex, AdjacencyList adjacencyList) {
         int[] shortestPath = new int[adjacencyList.getNumberOfVertices()];
         Arrays.fill(shortestPath, Integer.MAX_VALUE);
         PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
         shortestPath[vertex] = 0;
         pq.offer(new Integer[]{vertex, 0});

         while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentWeight = current[1];
            if (currentWeight > shortestPath[currentVertex]) continue;
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                Integer nextVertex = neighbor[0];
                // relaxation data computation: c(U, V)
                Integer nextVertexWeight = currentWeight + neighbor[1];
                if (nextVertexWeight < shortestPath[nextVertex]) {
                    shortestPath[nextVertex] = nextVertexWeight;
                    pq.offer(new Integer[]{nextVertex, nextVertexWeight});
                }
            }
         }

         System.out.println("shortest distance from vertex " + vertex + " :");
         for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            System.out.println("To " + i + ": " + shortestPath[i]);
         }
         System.out.println();
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

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.executeDijkstra(0, adjacencyList);
    }
}
