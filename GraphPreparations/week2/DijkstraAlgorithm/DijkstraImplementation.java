package GraphPreparations.week2.DijkstraAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphPreparations.week2.WeightedAdjacencyList;

public class DijkstraImplementation {

    public void ExecuteDijkstra(Integer startVertex, WeightedAdjacencyList weightedAdjacencyList) {
        Integer[] shortestPath = new Integer[weightedAdjacencyList.getVertexCount()];
        Arrays.fill(shortestPath, Integer.MAX_VALUE); // equivalent to infinity
        shortestPath[startVertex] = 0; // Distance from starting point to itself will always be 0

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(data -> data[1])); // based on weight, which is at index 1
        pq.offer(new Integer[]{startVertex, 0});

        while (!pq.isEmpty()) {
            Integer[] currentVertexData = pq.poll();
            Integer currentVertex = currentVertexData[0], currentVertexWeight = currentVertexData[1];

            if (currentVertexWeight > shortestPath[currentVertex]) continue;

            for (Integer[] neighbor: weightedAdjacencyList.getAdjacencyList()[currentVertex]) {
                Integer nextVertex = neighbor[0];
                Integer nextVertexWeightSum = currentVertexWeight + neighbor[1]; // distance of current node from previous node
                if (nextVertexWeightSum < shortestPath[nextVertex]) {
                    shortestPath[nextVertex] = nextVertexWeightSum;
                    pq.offer(new Integer[]{nextVertex, nextVertexWeightSum});
                }
            }
        }

        System.out.println("Shortest distance from the source vertex " + startVertex + ":");
        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println("To node " + i + " -> " + (shortestPath[i] == Integer.MAX_VALUE ? "INF" : shortestPath[i]));
        }
    }

    public static void main(String[] args) {
        WeightedAdjacencyList weightedAdjacencyList = new WeightedAdjacencyList(6, true);
        weightedAdjacencyList.addEdge(0, 1, 4);
        weightedAdjacencyList.addEdge(0, 2, 4);
        weightedAdjacencyList.addEdge(1, 2, 2);
        weightedAdjacencyList.addEdge(2, 3, 3);
        weightedAdjacencyList.addEdge(2, 4, 1);
        weightedAdjacencyList.addEdge(3, 5, 2);
        weightedAdjacencyList.addEdge(4, 5, 3);

        DijkstraImplementation dijkstraImplementation = new DijkstraImplementation();
        dijkstraImplementation.ExecuteDijkstra(0, weightedAdjacencyList);
    }
}
