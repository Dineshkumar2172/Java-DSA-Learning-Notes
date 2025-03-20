package GraphPreparations.practice.day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskals {
    class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int vertex) {
            this.parent = new int[vertex];
            this.rank = new int[vertex];
            for (int i = 0; i < vertex; i++) parent[i] = i; 
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
            
            if (rootU == rootV) return false; // cycle found

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

    public void executeKruskal(int vertex, int[][] edges) {
        List<Edge> edgeList = new ArrayList<>();
        for (int[] edge: edges) edgeList.add(new Edge(edge[0], edge[1], edge[2]));
        edgeList.sort(Comparator.comparing(edge -> edge.weight));

        DisjointSet ds = new DisjointSet(vertex);

        int totalMstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();
        for (Edge edge: edgeList) {
            if (ds.union(edge.src, edge.dest)) {
                totalMstWeight += edge.weight;
                mstEdges.add(edge);
            }

            // mst has to be performed only for v - 1 times
            if (mstEdges.size() == vertex - 1) break;
        }

        System.out.println("Total MST weight of the given graph is : " + totalMstWeight);
        for (Edge edge: mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + " (weight : " + edge.weight + ")");
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
