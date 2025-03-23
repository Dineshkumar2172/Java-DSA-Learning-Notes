package GraphPreparations.practice.day9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskals {

    class Edge {
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class DisjointSet{
        private int[] parent, rank;
        
        public DisjointSet(int vertices) {
            this.parent = new int[vertices];
            this.rank = new int[vertices];
            for (int i = 0; i < vertices; i++) parent[i] = i;
        }

        public int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]);
            }

            return parent[vertex];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false; // cycle detected

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV] > rank[rootU]) {
                parent[rootU] = rootV;
            } else {
                parent[rootU] = rootV;
                rank[rootV]++;
            }

            return true;
        }
    }

    public void executeKruskal(int vertices, int[][] edges) {
        List<Edge> edgeList = new ArrayList<>();
        for (int[] edge: edges) edgeList.add(new Edge(edge[0], edge[1], edge[2]));
        edgeList.sort(Comparator.comparing(edge -> edge.weight));

        DisjointSet ds = new DisjointSet(vertices);

        List<Edge> mstEdges = new ArrayList<>();
        int totalWeight = 0;
        for (Edge edge: edgeList) {
            if (ds.union(edge.source, edge.destination)) {
                mstEdges.add(edge);
                totalWeight += edge.weight;
            }

            if (edgeList.size() == vertices - 1) break;
        }

        System.out.println("Total weight of minimum spanning tree : " + totalWeight);
        for (Edge edge: mstEdges) {
            System.out.println(edge.source + " - " + edge.destination + " (weight: " + edge.weight + ")");
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 4},
            {1, 2, 2},
            {1, 3, 5},
            {2, 3, 8},
            {2, 4, 10},
            {3, 4, 6},
            {3, 5, 7},
            {4, 5, 3}
        };


        Kruskals kruskal = new Kruskals();
        kruskal.executeKruskal(vertices, edges);
    }
}
