package GraphPreparations.practice.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    static class Edge {
        Integer src;
        Integer destination;
        Integer weight;
        public Edge(Integer src, Integer destination, Integer weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void executeBellmanFord (int vertex, List<Edge> edges) {
        Integer[] shortestPath = new Integer[edges.size()];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[vertex] = 0;

        // perform relaxation n - 1 times.
        for (int i = 0; i < edges.size() - 1; i++) {
            for (Edge edge: edges) {
                if (shortestPath[edge.src] != Integer.MAX_VALUE &&
                    shortestPath[edge.src] + edge.weight < shortestPath[edge.destination]) {
                        shortestPath[edge.destination] = shortestPath[edge.src] + edge.weight;
                }
            }
        }

        // check for cycle
        for (Edge edge: edges) {
            if (shortestPath[edge.src] != Integer.MAX_VALUE &&
                shortestPath[edge.src] + edge.weight < shortestPath[edge.destination]) {
                    System.out.println("negative cycle detected");
                    return;
            }
        }

        System.out.println("shortest distance from vertex " + vertex + " :");
         for (int i = 0; i < edges.size(); i++) {
            System.out.println("To vertex " + i + " : " + (shortestPath[i] == Integer.MAX_VALUE ? "INF" : shortestPath[i]));
         }
         System.out.println();
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
        bellmanFord.executeBellmanFord(0, edges);
    }
}
