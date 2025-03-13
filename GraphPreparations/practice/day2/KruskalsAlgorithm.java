package GraphPreparations.practice.day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {

    // reference:
    //  1. It's undirected and weighted

    public static class Edge {
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
            // making each vertex as its own parent upon initialising
            for (int i = 0; i < vertex; i++) this.parent[i] = i;
        }

        public int find(int vertex) {
            // recurse till we find the parent
            // parent should be a parent of itself - it's the base condition

            // if the vertex is not its own parent
            if (parent[vertex] != vertex) {
                // update the root parent for the vertex during first find operation incase of multiple levels
                // so that the find will be faster from further search operation.
                parent[vertex] = find(parent[vertex]); // path compression
            }

            return parent[vertex];
        }

        // should return false if there is a cycle
        // should perform union of two sets in case of vertices belongs to different sets and return true.
        // union operation:
        //      1. check the rank.
        //      2. if both ranks are same: then keep either of em are parent and other one as child.
        //      3. incase of different rank: keep highest rank as parent and smallest rank as child.
        //      4. update the parent and rank accordingly after union operation.
        // return true
        public boolean union(int u, int v){
            int rootU = find(u); // find parent of u
            int rootV = find(v); // find parent of v

            if (rootU == rootV) return false; // cycle detected

            // if the rank of U's root parent is greater than the rank of V's parent
            // then male U's root parent as a parent of V's root parent.
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV] > rank[rootU]) {
                // if V's root parent has higher rank than U's root parent
                // make V's root parent as a parent of U's root parent
                parent[rootU] = rootV;
            } else {
                // if both rank's are equal
                // keep any of them as a parent and the other one as child
                parent[rootV] = rootU; // keeping root of U as parent of root of V
                rank[rootU]++;
            }

            return true;
        }
    }

    public void executeKruskals(AdjacencyList adjacencyList) {
        // step 1: collect adjacency list as list of edges having src, dest and weight
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(i)) {
                edges.add(new Edge(i, neighbor[0], neighbor[1]));
            }
        }

        // step 2: sort them based on weight
        edges.sort(Comparator.comparing(edge -> edge.weight));

        // step 3: Initialise dijoint set
        DisjointSet ds = new DisjointSet(adjacencyList.getNumberOfVertices());


        Integer mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        // step 4: access each edge one after another and perform disjoint set operation
        for (Edge edge: edges) {
            // if the edge doesn't form a cycle, then it should be a part of MST
            if (ds.union(edge.src, edge.weight)) {
                mstEdges.add(edge);
                mstWeight += edge.weight;
            }

            // Edge selection should be performed only for v - 1 times. As you know it's MST
            if (mstEdges.size() == adjacencyList.getNumberOfVertices() - 1) break;
        }

        // step 5: print the MST and weight
        System.out.println("Minimu spanning tree edges : ");
        for (Edge edge: mstEdges) {
            System.out.println(edge.src + " - " + edge.destination + "( weight: "+ edge.weight +")");
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
