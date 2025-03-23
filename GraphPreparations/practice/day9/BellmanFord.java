package GraphPreparations.practice.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    static class Edge {
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void executeBellmanFord(int startVertex, List<Edge> edges, int vertex) {
        Integer[] shortestPath = new Integer[vertex];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[startVertex] = 0;

        // perform relaxation for v - 1 times
        for (int i = 0; i < vertex - 1; i++) {
            for (Edge edge: edges) {
                if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                    shortestPath[edge.source] + edge.weight < shortestPath[edge.destination]) {
                        shortestPath[edge.destination] = shortestPath[edge.source] + edge.weight;
                }
            }
        }

        for (Edge edge: edges) {
            if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                shortestPath[edge.source] + edge.weight < shortestPath[edge.destination]) {
                    System.out.println("Negative cycle detected");
                    return;
            }
        }

        System.out.println("Shortest distance from vertex " + startVertex + ": ");
        for (int i = 0; i < vertex; i++) {
            System.out.println("To vertex " + i + ": " + shortestPath[i]);
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        int[][] edges = {
            {0, 1, 4},  // Edge from 0 to 1 with weight 4
            {0, 2, 1},  // Edge from 0 to 2 with weight 1
            {1, 2, 2},  // Edge from 1 to 2 with weight 2
            {1, 3, 5},  // Edge from 1 to 3 with weight 5
            {2, 3, 3},  // Edge from 2 to 3 with weight 3
            {2, 4, 1},  // Edge from 2 to 4 with weight 1
            {3, 4, 1}   // Edge from 3 to 4 with weight 1
        };
        int srcVertex = 0;

        List<Edge> adjEdges = new ArrayList<>();
        for (int[] edge: edges) adjEdges.add(new Edge(edge[0], edge[1], edge[2]));
        
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.executeBellmanFord(srcVertex, adjEdges, vertex);
    }
}
