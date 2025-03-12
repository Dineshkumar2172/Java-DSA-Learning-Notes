package GraphPreparations.practice.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    // 1. it's a single source shortest path algorithm in dynamic programming.
    // 2. It supports both directed and undirected graphs with weighted edges.
    // 2. unlike Dijkstra, it works with negative edges, and it can detect negative cycles (though it fails negative cycles)
    // 3. works based on relaxation, if (d[u] + c(u,v) > d[v]) then update d[v] with d[u] + c(u,v)

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

    public void executeBellmanfordAlgorithm(Integer startVertex, List<Edge> edges) {
        Integer[] shortestPath = new Integer[edges.size()];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[startVertex] = 0;

        // step1: relax all edges v -1 times
        for (int i = 0; i < edges.size() - 1; i++) {
            for (Edge edge: edges) {
                // performing relaxation operation here: formula -> if d[u] + c(u, v) < d[v] then d[v] = d[u] + c(u, v)
                if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                    shortestPath[edge.source] + edge.weight < shortestPath[edge.destination]) {
                    shortestPath[edge.destination] = shortestPath[edge.source] + edge.weight;
                }
            }
        }

        // step 2: check for negative cycles by performing relaxation one more time and see if there are any negative cycles
        for (Edge edge: edges) {
            if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                shortestPath[edge.source] + edge.weight < shortestPath[edge.destination]) {
                System.out.println("Graph contains negative cycles");
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

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        bellmanFordAlgorithm.executeBellmanfordAlgorithm(0, edges);
    }
}
