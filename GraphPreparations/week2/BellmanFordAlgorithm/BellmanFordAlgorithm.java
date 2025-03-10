package GraphPreparations.week2.BellmanFordAlgorithm;

import GraphPreparations.week2.WeightedAdjacencyList;

public class BellmanFordAlgorithm {

    // Step 1: Initialize distances: {0, ∞, ∞, ∞, ∞}
    // Step 2: Relax all edges V-1 times.
    // Step 3: Check if any edge can be further relaxed → If yes, there is a negative cycle.
    // Step 4: Print the shortest distances.

    public void executeBellmanFord() {

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

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
    }
}
