package GraphPreparations.practice.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {

    static class Edge{
        Integer src;
        Integer destination;
        Integer weight;
        public Edge(Integer src, Integer destination, Integer weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int vertex) {
            this.parent = new int[vertex];
            this.rank = new int[vertex];
            for (int i = 0; i < vertex; i++) parent[i] = i; // each vertex is its own parent
        }

        int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]); // path compression
            }

            return vertex;
        }
 
        boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) return false; // cycle detected

            // union by reank
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

    public void executeKruskals(AdjacencyList adjacencyList) {
        List<Edge> edges = new ArrayList<>();

        // convert adjacency list to edge list
        for (int vertex = 0; vertex < adjacencyList.getNumberOfVertices(); vertex++) {
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(vertex)) {
                edges.add(new Edge(vertex, neighbor[0], neighbor[1]));
            }
        }

        edges.sort(Comparator.comparing(edge -> edge.weight));

        DisjointSet ds = new DisjointSet(adjacencyList.getNumberOfVertices());

        Integer mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge: edges) {
            if (ds.union(edge.src, edge.destination)) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
            }

            if (mstEdges.size() == adjacencyList.getNumberOfVertices() - 1) break;
        }

        // Step 4: Print MST
        System.out.println("Minimum spanning tree (MST) Edges:");
        for (Edge edge: mstEdges) {
            System.out.println(edge.src + " - " + edge.destination + " (weight: " + edge.weight + ")");
        }
        System.out.println("Total MST weight: " + mstWeight);
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false, true);
        adjacencyList.addEdge(0, 1, 3);
        adjacencyList.addEdge(0, 2, 3);
        adjacencyList.addEdge(1, 2, 3);
        adjacencyList.addEdge(1, 3, 3);
        adjacencyList.addEdge(2, 3, 3);
        adjacencyList.addEdge(2, 4, 3);
        adjacencyList.addEdge(3, 4, 3);
        adjacencyList.addEdge(4, 5, 3);

        KruskalsAlgorithm kruskalsAlgorithm = new KruskalsAlgorithm();
        kruskalsAlgorithm.executeKruskals(adjacencyList);
    }
}
