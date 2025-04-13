package GraphPreparations.practice.day16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {

    // reference:
    //  1. It's undirected and weighted

    public static class Edge {

    }

    static class DisjointSet {
        
    }

    public void executeKruskals(AdjacencyList adjacencyList) {
        
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
