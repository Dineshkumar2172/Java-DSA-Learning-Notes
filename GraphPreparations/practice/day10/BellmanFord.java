package GraphPreparations.practice.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int source;
    int desination;
    int weight;
    public Edge(int source, int desination, int weight) {
        this.source = source;
        this.desination = desination;
        this.weight = weight;
    }
}

public class BellmanFord {

    public void executeBellmanFord(int source, List<Edge> edges, int vertex) {
        Integer[] shortestPath = new Integer[vertex];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[source] = 0;
        
        for (int i = 0; i < vertex - 1; i++) {
            for (Edge edge: edges) {
                if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                shortestPath[edge.source] + edge.weight <  shortestPath[edge.desination]) {
                    shortestPath[edge.desination] = shortestPath[edge.source] + edge.weight;
                }
            }
        }

        for (Edge edge: edges) {
            if (shortestPath[edge.source] != Integer.MAX_VALUE &&
                shortestPath[edge.source] + edge.weight <  shortestPath[edge.desination]) {
                    System.out.println("negative cycle detected");
                    return;
            }
        }

        System.out.println("Shortest distance from vertex : " + source);
        for (int i = 0; i < vertex; i++) {
            if  (shortestPath[i] == Integer.MAX_VALUE) {
                System.out.println("To vertex " + i + ": INF");
                continue;
            }

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
        int sourceVertex = 0;

        List<Edge> adjEdges = new ArrayList<>();
        for (int[] edge: edges) adjEdges.add(new Edge(edge[0], edge[1], edge[2]));
        
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.executeBellmanFord(sourceVertex, adjEdges, vertex);
    }
}
