package GraphPreparations.practice.day14;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    // reference:
    //      1. It's a way of representing graph using arrays of lists.
    //      2. Each index in the array represents each vertices in a graph.
    //      3. Each list stored in those index represents the edges connected to other vertices from itself.
    //      4. It can be weighted, unweighted, directional, undirectional.

    private ArrayList<LinkedList<Integer[]>> adjacencyList;
    private Integer numberOfVertices;
    private Integer numberOfEdges;
    private boolean isUndirectedGraph;
    private boolean isWeightedGraph;

    public AdjacencyList(Integer graphSize, boolean isWeightedGraph, boolean isUndirectedGraph) {
        this.adjacencyList = new ArrayList<>(graphSize);
        this.numberOfVertices = graphSize;
        this.numberOfEdges = 0;
        this.isUndirectedGraph = isUndirectedGraph;
        this.isWeightedGraph = isWeightedGraph;
        for (int i = 0; i < graphSize; i++) {
            // add append the element in the order it gets called
            // since we iterating over graphSize - 1, it initialised linkedlist in all
            // of the arraylist index making it possible to add elements.
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(Integer startVertex, Integer endVertex) {
        this.adjacencyList.get(startVertex).add(new Integer[]{endVertex, 0});
        this.numberOfEdges++;
        if (isUndirectedGraph) {
            this.adjacencyList.get(endVertex).add(new Integer[]{startVertex, 0});
            this.numberOfEdges++;
        }
    }

    public void addEdge(Integer startVertex, Integer endVertex, Integer weight) {
        this.adjacencyList.get(startVertex).add(new Integer[]{endVertex, weight});
        this.numberOfEdges++;
        if (isUndirectedGraph) {
            this.adjacencyList.get(endVertex).add(new Integer[]{startVertex, weight});
            this.numberOfEdges++;
        }
    }

    public void removeEdge(Integer startVertex, Integer endVertex) {
        this.adjacencyList.get(startVertex).removeIf(edge -> edge[0] == endVertex);
        this.numberOfEdges--;
        if (isUndirectedGraph) {
            this.adjacencyList.get(endVertex).removeIf(edge -> edge[0] == startVertex);
            this.numberOfEdges--;
        }
    }

    public void displayGraph() {
        for (int i = 0; i < this.numberOfVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer[] edge: this.adjacencyList.get(i)) {
                System.out.print(isWeightedGraph ? "[" + edge[0] + ", " + edge[1] +"], " : edge[0] + ", ");
            }
            System.out.println();
        }
    }

    public ArrayList<LinkedList<Integer[]>> getAdjacencyList() { return this.adjacencyList; }

    public Integer getNumberOfVertices() { return this.numberOfVertices; }

    public Integer getNumberOfEdges() { return this.numberOfEdges; }

    public LinkedList<Integer[]> getEdgesByVertex(Integer vertex) { return this.adjacencyList.get(vertex); }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5, false, false);
        adjacencyList.addEdge(2, 3);
        adjacencyList.displayGraph();
    }
}
