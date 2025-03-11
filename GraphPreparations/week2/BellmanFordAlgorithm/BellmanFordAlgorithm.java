package GraphPreparations.week2.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import GraphPreparations.week2.WeightedAdjacencyList;

class BellmanFordAlgorithm {

    static class Edge {
        Integer src, dest, weight;
        public Edge(Integer src, Integer dest, Integer weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Step 1: Initialize distances: {0, ∞, ∞, ∞, ∞}
    // Step 2: Relax all edges V-1 times.
    // Step 3: Check if any edge can be further relaxed → If yes, there is a negative cycle.
    // Step 4: Print the shortest distances.

    public void executeBellmanFord(Integer startVertex, Integer vertices, List<Edge> edges) {
        int[] shortestDistance = new int[vertices];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[startVertex] = 0;

        // Step 1: Relax all edges V-1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge: edges) {
                // performing relaxation operation here: formula -> if d[u] + c(u, v) < d[v] then d[v] = d[u] + c(u, v)
                if (shortestDistance[edge.src] != Integer.MAX_VALUE &&
                    shortestDistance[edge.src] + edge.weight < shortestDistance[edge.dest]) {
                    shortestDistance[edge.dest] = shortestDistance[edge.src] + edge.weight;
                }
            }
        }

        // Step 2: Check for negative cycles - if we see the weight changes even after performing relaxation for n-1 times,
        // it indicates there is a presence of negative cycle. Because in positive cycles, data won't change after performing relaxation
        // for n-1 times no matter how many iteration of relaxations we perform.
        for (Edge edge: edges) {
            if (shortestDistance[edge.src] != Integer.MAX_VALUE &&
                shortestDistance[edge.src] + edge.weight < shortestDistance[edge.dest]) {
                System.out.println("Graph contains a negative cycle!");
                return;
            }
        }

        // printing shortest distances from source vertex
        System.out.println("Shortest distance from source " + startVertex + ": ");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " : " + (shortestDistance[i] == Integer.MAX_VALUE ? "INF" : shortestDistance[i]));
        }

    }

    public static void main(String[] args) {
        // In bellman-ford, data should be representted as (startVertex, endVertex, weight)
        Integer vertices = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        bellmanFordAlgorithm.executeBellmanFord(0, vertices, edges);
    }
}
