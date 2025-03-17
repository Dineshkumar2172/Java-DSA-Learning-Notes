package GraphPreparations.practice.day6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    class Edge {
        int src, destination, weight;
        public Edge(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // kruskal algorithm uses disjoint set to find MST
    class DisjointSet {
        int[] parent, rank;
        
        public DisjointSet(int v) {
            this.parent = new int[v];
            this.rank = new int[v];
            for (int i = 0; i < v; i++) parent[i] = i;
        }

        public int find(int vertex) {
            if (vertex != parent[vertex]) {
                parent[vertex] = find(parent[vertex]);
            }

            return parent[vertex];
        }

        public boolean union(int u, int v) {
            int rootU = parent[u], rootV = parent[v];

            if (rootU == rootV) return true;

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV] > rank[rootU]) {
                parent[rootU] = rootV;
            } else {
                parent[rootU] = rootV;
                rank[rootV]++;
            }
            
            return false;
        }
    }

    public void executeKruskal(int vertices, int[][] edges) {
        List<Edge> mstEdges = new ArrayList<>();
        for (int[] edge: edges) mstEdges.add(new Edge(edge[0], edge[1], edge[2]));

        mstEdges.sort(Comparator.comparing(edge -> edge.weight));

        DisjointSet ds = new DisjointSet(vertices);

        List<Edge> result = new ArrayList<>();
        int totalMST = 0;
        for (Edge edge: mstEdges) {
            if (!ds.union(edge.src, edge.destination)) {
                result.add(edge);
                totalMST += edge.weight;
            }

            if(result.size() == vertices - 1) break;
        }

        System.out.println("Total weight of kruskal MST : " + totalMST);
        for (Edge edge: result) {
            System.out.println(edge.src + " - " + edge.destination + " (weight : " + edge.weight + ")");
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
