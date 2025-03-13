package GraphPreparations.practice.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    // It's a single source shortest path algorithm based on dynamic approach.
    // It can detect negative cycles in graph unlike Dijkstra though it still fails.
    // It works irrespective of directionality, it supports negative weight as well.
    // It can detect the negative cycle in a graph, though it fails with respec to finding shortest path.
    // Works based on relaxation d[u] + c(u,v) < d[v]: then update d[v] = d[u] + c(u,v)
    static class Edge {
        Integer source;
        Integer destination;
        Integer weight;
        public Edge(Integer source, Integer destination, Integer weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight; 
        }
    }

    public void executeBellmanFord(Integer startVertex, List<Edge> edges) {
        Integer[] shortestPath = new Integer[edges.size()];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[startVertex] = 0;

        // relaxing all edges n - 1 times
        for (int i = 0; i < edges.size() - 1; i++) {
            for (Edge edge: edges) {
                // performing relaxation operation if weights matches this condition
                if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                    shortestPath[edge.source] + edge.weight < shortestPath[edge.destination]) {
                    shortestPath[edge.destination] = shortestPath[edge.source] + edge.weight;
                }
            }
        }

        for (Edge edge: edges) {
            if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                shortestPath[edge.source] + edge.weight < shortestPath[edge.destination]) {
                System.out.println("negative cycle detected");
                return;
            }
        }

        // printing shortest distances from source vertex
        System.out.println("Shortest distance from source " + startVertex + ": ");
        for (int i = 0; i < edges.size(); i++) {
            System.out.println("To vertex " + i + " : " + (shortestPath[i] == Integer.MAX_VALUE ? "INF" : shortestPath[i]));
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
        bellmanFord.executeBellmanFord(0, edges);
    }
    
}
