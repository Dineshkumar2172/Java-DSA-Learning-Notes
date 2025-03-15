package GraphPreparations.practice.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    // relaxation between edges
    // works by relaxaing edges v-1 times
    static class Edge {
        int src, destination, weight;
        public Edge(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void executeBellmanFord(int vertex, List<Edge> edges, Integer vertices) {
        Integer[] shortestPath = new Integer[edges.size()];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[vertex] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge: edges) {
                if (shortestPath[edge.src] != Integer.MAX_VALUE &&
                    shortestPath[edge.src] + edge.weight < shortestPath[edge.destination]) {
                    shortestPath[edge.destination] = shortestPath[edge.src] + edge.weight;
                }
            }
        }

        // detecting negative weighted cycles
        for (Edge edge: edges) {
            if (shortestPath[edge.src] != Integer.MAX_VALUE &&
                shortestPath[edge.src] + edge.weight < shortestPath[edge.destination]) {
                    System.out.println("Negative weighted cycles detected!");
                    return;
            }
        }

        System.out.println("Shortest distance from Vertex " + vertex + ": ");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + ": " + shortestPath[i]);
        }
    }


    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.executeBellmanFord(0, edges, 5);
    }
}
