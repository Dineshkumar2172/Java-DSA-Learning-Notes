package GraphPreparations.practice.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalsAlgorithm {

    // reference:
    //  1. It's undirected and weighted

    public static class Edge {
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] rank;
        int[] parent;
        public DisjointSet(int vertex) {
            this.rank = new int[vertex];
            this.parent = new int[vertex];
            for (int i = 0; i < vertex; i++) parent[i] = i;
        }

        public int find(int vertex) {
            if (vertex != parent[vertex]) {
                parent[vertex] = find(parent[vertex]);
            }

            return parent[vertex];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false;

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootU] = rootV;
                rank[rootV]++;
            }

            return true;
        }
    }

    public void executeKruskals(AdjacencyList adjacencyList) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge.weight));
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] edge: adjacencyList.getAdjacencyList().get(i)) {
                pq.offer(new Edge(i, edge[0], edge[1]));
            }
        } 

        DisjointSet ds = new DisjointSet(adjacencyList.getNumberOfVertices());

        List<Edge> mstEdges = new ArrayList<>();
        int mstWeight = 0;
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (ds.union(current.source, current.destination)) {
                mstEdges.add(current);
                mstWeight += current.weight;
            }

            if (mstEdges.size() == adjacencyList.getNumberOfVertices() - 1) break;
        }

        System.out.println("Minimu spanning tree edges : ");
        for (Edge edge: mstEdges) {
            System.out.println(edge.source + " - " + edge.destination + "( weight: "+ edge.weight +")");
        }
        System.out.println("Total MST weight : " + mstWeight);
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, true, false);
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
