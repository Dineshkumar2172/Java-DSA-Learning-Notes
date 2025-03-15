package GraphPreparations.practice.day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskals {
    static class Edge {
        int src;
        int destination;
        int weight;
        public Edge(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    class DisjointSet {
        int[] parent;
        int[] rank;
        public DisjointSet(int v) {
            this.parent = new int[v];
            this.rank = new int[v];
            // each vertex is their own parent  upon initialisation
            for (int i = 0; i < v; i++) parent[i] = i;
        }

        public int find(int v) {
            if (v != parent[v]) {
                parent[v] = find(parent[v]);
            }

            return parent[v];
        }

        public boolean union(int u, int v) {
            int rootU = find(u), rootV = find(v);
            if (rootU == rootV) return false; // cycle detected - both belong to same set

            if(rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV] > rank[rootU]) {
                parent[rootU] = rootV;
            } else {
                parent[rootU] = rootV;
                rank[rootU]++;
            }

            return true;
        }
    }

    public void executeKruskals(int vertex, List<Edge> edges) {
        edges.sort(Comparator.comparing(edge -> edge.weight));

        DisjointSet ds = new DisjointSet(vertex);

        Integer mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();
        
        for (Edge edge: edges) {
            // if the edge doesn't form a cycle
            if (ds.union(edge.src, edge.destination)) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
            }

            // we have to find MST for v-1 times
            if (mstEdges.size() == vertex - 1) break;
        }

        System.out.println("Minimum Spanning Tree weight : " + mstWeight);
        for (Edge edge: mstEdges) {
            System.out.println(edge.src + " - " + edge.destination + " (weight: " + edge.weight + ")");
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 6));
        edges.add(new Edge(2, 3, 8));
        edges.add(new Edge(2, 4, 10));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(3, 5, 14));
        edges.add(new Edge(4, 5, 7));

        Kruskals kruskals = new Kruskals();
        kruskals.executeKruskals(vertices, edges);
    }
}
