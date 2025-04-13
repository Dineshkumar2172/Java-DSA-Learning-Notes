package GraphPreparations.practice.day16;

import java.util.Arrays;

public class AdjacencyMatrix {
    // references:
    // 1. It's the same as adjacencyList, but with different representation
    // 2. But instead of saving elements as LinkedList in a list, here we store them as V*V matrix.
    // 3. It should support all directed, undirected, weighted and unnweighted graphs.

    private int[][] adjacencyMatrix;
    private boolean isWeightedGraph;
    private boolean isUndirectedGraph;
    private int vertexCount;
    private int edgeCount;

    public AdjacencyMatrix(int graphSize, boolean isWeightedGraph, boolean isUndirectedGraph) {
        this.adjacencyMatrix = new int[graphSize][graphSize];
        this.vertexCount = graphSize;
        this.isWeightedGraph = isWeightedGraph;
        this.isUndirectedGraph = isUndirectedGraph;
        if (this.isWeightedGraph) {
            for (int i = 0; i < this.vertexCount; i++) { Arrays.fill(this.adjacencyMatrix[i], -1); }
        }
    }

    public void addEdge(int startVertex, int endVertex) {
        this.adjacencyMatrix[startVertex][endVertex] = 1;
        this.edgeCount++;
        if (isUndirectedGraph) {
            this.adjacencyMatrix[endVertex][startVertex] = 1;
            this.edgeCount++;
        }
    }

    public void addEdge(int startVertex, int endVertex, int weight) {
        this.adjacencyMatrix[startVertex][endVertex] = weight;
        this.edgeCount++;
        if (isUndirectedGraph) {
            this.adjacencyMatrix[endVertex][startVertex] = weight;
            this.edgeCount++;
        }
    }

    public void removeEdge(int startVertex, int endVertex) {
        this.adjacencyMatrix[startVertex][endVertex] = this.isWeightedGraph ? -1 : 0;
        this.edgeCount--;
        if (isUndirectedGraph) {
            this.adjacencyMatrix[endVertex][startVertex] = this.isWeightedGraph ? -1 : 0;
            this.edgeCount--;
        }
    }

    public void displayGraph() {
        System.out.println("graphical representation of adjancecy Matrix : ");
        for (int i = 0; i < this.vertexCount; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < this.vertexCount; j++) {
                System.out.print(this.adjacencyMatrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public int getVertexCount() { return this.vertexCount; }

    public int getEdgeCount() { return this.edgeCount; }

    public int[][] getAdjacencyMatrix() { return this.adjacencyMatrix; }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, false, false);
        adjacencyMatrix.addEdge(2, 3);
        adjacencyMatrix.displayGraph();
    }

}
