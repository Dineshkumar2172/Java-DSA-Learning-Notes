package GraphPreparations.week3.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import GraphPreparations.week2.WeightedAdjacencyList;

public class KruskalAlgorithm {
    // Kruskal’s Algorithm Steps
    // 1. Sort all edges in ascending order based on weight.
    // 2. Use Disjoint Set (Union-Find)
    //      i) Keep track of connected components.
    //     ii) Avoid cycles using the Union-Find data structure.
    // 3. Select edges one by one, ensuring no cycle is formed.
    // 4. Stop when we have V-1 edges in the Minimum Spanning Tree (MST).

    // Edge class to store (source, destination, weight)
    static class Edge {
        int src, destination, weight;
        Edge(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Disjoint Set (Union-Find) with Path Compression
    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int vertex) {
            parent = new int[vertex];
            rank = new int[vertex];
            for (int i = 0; i < vertex; i++) parent[i] = i; // Each node is its own parent
        }

        int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]); // path compression
            }

            return parent[vertex];
        }

        boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) return false; // cycle detected
            
            // union by rank
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }

            return true;
        }
    }

    public void executeKruskal(WeightedAdjacencyList adjacencyList) {
        List<Edge> edges = new ArrayList<>();

        // convert adjacency list to edge list
        for (int vertex = 0; vertex < adjacencyList.getVertexCount(); vertex++) {
            for (Integer[] neighbor: adjacencyList.getAdjacencyList()[vertex]) {
                int neighborVertex = neighbor[0], neighborVertexWeight = neighbor[1];
                edges.add(new Edge(vertex, neighborVertex, neighborVertexWeight));
            }
        }

        // step 1: sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // step 2: Initialize disjoint set
        DisjointSet ds = new DisjointSet(adjacencyList.getVertexCount());

        // step3: process edges
        Integer mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge: edges) {
            if (ds.union(edge.src, edge.destination)) { // If adding this edge doesn't form a cycle
                mstEdges.add(edge);
                mstWeight += edge.weight;
            }

            if (mstEdges.size() == adjacencyList.getVertexCount() - 1) break; // Stop when MST is complete
        }

        // Step 4: Print MST
        System.out.println("Minimum spanning tree (MST) Edges:");
        for (Edge edge: mstEdges) {
            System.out.println(edge.src + " - " + edge.destination + " (weight: " + edge.weight + ")");
        }
        System.out.println("Total MST weight: " + mstWeight);
    }

    public static void main(String[] args) {
        WeightedAdjacencyList adjacencyList = new WeightedAdjacencyList(6, false);
        adjacencyList.addEdge(0, 1, 3);
        adjacencyList.addEdge(0, 2, 3);
        adjacencyList.addEdge(1, 2, 3);
        adjacencyList.addEdge(1, 3, 3);
        adjacencyList.addEdge(2, 3, 3);
        adjacencyList.addEdge(2, 4, 3);
        adjacencyList.addEdge(3, 4, 3);
        adjacencyList.addEdge(4, 5, 3);

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        kruskalAlgorithm.executeKruskal(adjacencyList);
    }
}
