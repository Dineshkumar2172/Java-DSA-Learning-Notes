package GraphPreparations.week1.GraphRepresentations;

import java.util.LinkedList;

public class AdjacencyList {
    // representation
    //      1. its an array where each index represents each vertex
    //      2. Each of these indices i contains a linkedlist where each node represents the
    //         vertices that are connected to the vertex i.
    //      3. Operations include addEdge, removeEdge, displayGraph, some validations.


    // Improvement: Could use List<Set<Integer>> to handle duplicate edges
    private LinkedList<Integer>[] adjList;
    private boolean isUndirectedGraph;
    private int numEdges;
    private int numVertices;

    public AdjacencyList(int v, boolean isUndirectedGraph) {
        this.adjList = new LinkedList[v]; // initialising array with v (number of vertices)
        this.isUndirectedGraph = isUndirectedGraph;
        this.numVertices = v;

        for (int i = 0; i < v; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int startVertex, int endVertex) {
        // method responsible for adding edge between vertices
        if (!isValidVertex(startVertex) || !isValidVertex(endVertex)) {
            System.out.println("Invalid vertex: Reverify the entered vertex");
            return;
        }

        if (startVertex == endVertex) {
            System.out.println("Invalid action");
            return;
        }

        this.adjList[startVertex].add(endVertex);
        this.numEdges++;
        if (isUndirectedGraph) {
            this.adjList[endVertex].add(startVertex);
            this.numEdges++;
        }
    }

    public void removeEdge(int startVertex, int endVertex) {
        // method responsible for removing edges between vertices
        if (!isValidVertex(startVertex) || !isValidVertex(endVertex)) {
            System.out.println("Invalid vertex: Reverify the entered vertex");
            return;
        }

        if (startVertex == endVertex) {
            System.out.println("Invalid action");
            return;
        }

        this.adjList[startVertex].remove(endVertex);
        this.numEdges--;
        if (isUndirectedGraph) {
            this.adjList[endVertex].remove(startVertex);
            this.numEdges--;
        }
    }

    public void displayGraph() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + " --> ");
            // iterating over all the elements from an LinkedList of integer elements
            for (Integer vertex : adjList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidVertex(int v) {
        return v >= 0 && v < adjList.length;
    }

    public int getNumberOfEdges() {
        return numEdges;
    }

    public int getNumberOfVertices() {
        return numVertices;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(4, true);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(3, 2);
        adjacencyList.addEdge(0, 2);
        adjacencyList.displayGraph();
    }
}
