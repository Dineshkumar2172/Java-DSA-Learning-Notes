package GraphPreparations.practice.day13;

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
