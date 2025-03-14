package GraphPreparations.practice.day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import GraphPreparations.practice.day1.AdjacencyList;

public class Kruskal {
    static class Edge {
        Integer src, dest, weight;
        public Edge(Integer src, Integer dest, Integer weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    } 

    static class DisjointSet {

        int[] parent;
        int[] rank;

        public DisjointSet(Integer vertex) {
            this.parent = new int[vertex];
            this.rank = new int[vertex];
            for (int i = 0; i < vertex; i++) parent[i] = i;
        }

        // two operations - find, unions
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
            } else if (rank[rootV] > rank[rootU]) {
                parent[rootU] = rootV;
            } else {
                parent[rootU] = rootV;
                rank[rootU]++;
            }

            return true;
        }
    }

    public void executeKruskals(AdjacencyList adjacencyList) {
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(i)) {
                edges.add(new Edge(i, neighbor[0], neighbor[1]));
            }
        }

        edges.sort(Comparator.comparing(edge -> edge.weight));

        DisjointSet ds = new DisjointSet(adjacencyList.getNumberOfVertices());
        List<Edge> mstEdges = new ArrayList<>();
        Integer mstWeight = 0;
        
        for (Edge edge: edges) {
            if (ds.union(edge.src, edge.dest)) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
            }

            if (mstEdges.size() == adjacencyList.getNumberOfVertices() - 1) break;
        }

        System.out.println("Total weight of MST : " + mstWeight);
        for(Edge edge: mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + " (weight: " + edge.weight + ")");
        }
        System.out.println();

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

        Kruskal kruskal = new Kruskal();
        kruskal.executeKruskals(adjacencyList);
    }
}