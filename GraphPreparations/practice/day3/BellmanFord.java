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
    public void executeBellmanFord2(int start, List<Edge> edges) {
        int[] shortestPath = new int[edges.size()];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[start] = 0;

        // perform n -1 iteration
        for (int i = 0; i < edges.size() - 1; i++) {
            // performing relaxation on all edges
            for (Edge edge: edges) {
                if (edge.src != Integer.MAX_VALUE &&
                    shortestPath[edge.src] + edge.weight < shortestPath[edge.destination]) {
                        shortestPath[edge.destination] = shortestPath[edge.src] + edge.weight;
                }
            }
        }

        for (Edge edge: edges) {
            if (edge.src != Integer.MAX_VALUE &&
                shortestPath[edge.src] + edge.weight < shortestPath[edge.destination]) {
                    System.out.println("cycle detected");
                    return;
            }
        }

        System.out.println("shortest path from vertex " + start + ": ");
        for (int i = 0; i < edges.size(); i++) {
            System.out.println("To vertex " + i + ": " + (shortestPath[i] != Integer.MAX_VALUE ? shortestPath[i] : "INF"));
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
        bellmanFord.executeBellmanFord2(0, edges);
    }
}
