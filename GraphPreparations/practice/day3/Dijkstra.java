package GraphPreparations.practice.day3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphPreparations.practice.day2.AdjacencyList;

public class Dijkstra {
    // works based on relaxation
    public void executeDijkstra(int start, AdjacencyList adjacencyList) {
        int[] shortestDistance =  new int[adjacencyList.getNumberOfVertices()];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[start] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1]));
        pq.offer(new Integer[]{start, 0});
        
        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentWeight = current[1];

            if (currentWeight > shortestDistance[currentVertex]) continue;

            for (Integer[] neighbors: adjacencyList.getAdjacencyList().get(currentVertex)) {
                Integer nextVertex = neighbors[0];
                Integer nextWeight = neighbors[1];
                if (currentWeight + nextWeight < shortestDistance[nextVertex]) {
                    shortestDistance[nextVertex] = currentWeight + nextWeight;
                    pq.offer(new Integer[]{nextVertex, currentWeight + nextWeight});
                }
            }
        }

        System.out.println("The shortest distance from vertex " + start + ": ");
        for (int i  = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            System.out.println("To vertex " + i + ": " + shortestDistance[i]);
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
