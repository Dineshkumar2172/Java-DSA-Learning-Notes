package GraphPreparations.practice.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    static class Edge {
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    class DisjointSet {
        int[] parent, rank;
        public DisjointSet(int v) {
            this.parent = new int[v];
            this.rank = new int[v];
            for (int i = 0; i < v; i++) parent[i] = i;
        }

        public int find(int u){
            if (u != parent[u]) {
                parent[u] = find(parent[u]);
            }

            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u), rootV = find(v);

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

    public void executeKruskal(int v, int[][] edges) {
        List<Edge> edgeList = new ArrayList<>();
        for (int[] edge: edges) edgeList.add(new Edge(edge[0], edge[1], edge[2]));
        edgeList.sort(Comparator.comparing((Edge edge) -> edge.weight)
                                .thenComparing(edge -> edge.source)
                                .thenComparing(edge -> edge.destination));

        DisjointSet ds = new DisjointSet(v);

        List<Edge> mstEdgeList = new ArrayList<>();
        int mstTotalWeight = 0;
        for (Edge edge: edgeList) {
            if (ds.union(edge.source, edge.destination)) { // disjoint set comparison
                mstEdgeList.add(edge);
                mstTotalWeight += edge.weight;
            }

            if (mstEdgeList.size() == v-1) break;
        }

        System.out.println("Total MST weight of the given graph is : " + mstTotalWeight);
        for (Edge edge: mstEdgeList) {
            System.out.println(edge.source + " - " + edge.destination + " (weight : " + edge.weight + ")");
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


        Kruskal kruskal = new Kruskal();
        kruskal.executeKruskal(vertices, edges);
    }
}
