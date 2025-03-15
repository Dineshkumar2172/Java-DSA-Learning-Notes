package GraphPreparations.practice.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    static class Edge {
        int destination;
        int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void executePrims(int vertices, List<List<Edge>> edges) {
        boolean[] visited = new boolean[vertices];
        Integer[] parent = new Integer[vertices];
        Integer[] minEdgeWeight = new Integer[vertices];
        Arrays.fill(minEdgeWeight, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.offer(new Integer[]{0,0}); // start from vertex 0;
        parent[0] = -1; // root node of the MST
        minEdgeWeight[0] = 0;

        while (!pq.isEmpty()) {
            Integer[] currentVertex = pq.poll();

            if (visited[currentVertex[0]]) continue;

            visited[currentVertex[0]] = true;

            for (Edge edge: edges.get(currentVertex[0])) {
                if (!visited[edge.destination] && edge.weight < minEdgeWeight[edge.destination]) {
                    parent[edge.destination] = currentVertex[0];
                    minEdgeWeight[edge.destination] = edge.weight;
                    pq.offer(new Integer[]{edge.destination, edge.weight});
                }
            }
        }

        Integer mstTotalWeight = 0;
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + " (weight : " + minEdgeWeight[i] + ")");
            mstTotalWeight += minEdgeWeight[i];
        }
        System.out.println("MST weight of given graph : " + mstTotalWeight);
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 6));
        graph.get(2).add(new Edge(0, 4));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 10));
        graph.get(3).add(new Edge(1, 6));
        graph.get(3).add(new Edge(2, 8));
        graph.get(3).add(new Edge(4, 9));
        graph.get(3).add(new Edge(5, 14));
        graph.get(4).add(new Edge(2, 10));
        graph.get(4).add(new Edge(3, 9));
        graph.get(4).add(new Edge(5, 7));
        graph.get(5).add(new Edge(3, 14));
        graph.get(5).add(new Edge(4, 7));

        Prims prims = new Prims();
        prims.executePrims(vertices, graph);

    }
}
