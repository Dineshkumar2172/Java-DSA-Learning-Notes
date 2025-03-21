package GraphPreparations.practice.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TIME COMPLEXTIY - (O(V * E))
public class BellmanFord {

    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    
    public void executeBellmanFord(int src, List<Edge> edges, int vertex) {
        Integer[] shortestPath = new Integer[vertex];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[src] = 0;

        for (int i = 0; i < vertex - 1; i++) {
            for (Edge edge: edges) {
                if (shortestPath[edge.src] != Integer.MAX_VALUE) {
                    // d[u] + c(u,v) < d[v] → update d[v] = d[u] + c(u,v)
                    if (shortestPath[edge.src] + edge.weight < shortestPath[edge.dest]) {
                        shortestPath[edge.dest] = shortestPath[edge.src] + edge.weight;
                    }
                }
            }
        }

        for (Edge edge: edges) {
            if (shortestPath[edge.src] != Integer.MAX_VALUE) {
                // d[u] + c(u,v) < d[v] → update d[v] = d[u] + c(u,v)
                if (shortestPath[edge.src] + edge.weight < shortestPath[edge.dest]) {
                    System.out.println("negative cycle detected");
                    return;
                }
            }
        }

        System.out.println("Shortest distance from the vertex " + src + ":");
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
