package GraphPreparations.practice.day1;

import java.util.Arrays;

import GraphAlgorithmCrashCourse.Vertex;

public class AdjacencyMatrix {
    // representation
    //
    // Operations:
    //      1. getAdjacencyMatrix
    //      2. getNumberOfVertices
    //      3. getNumberOfEdges
    //      4. getEdgesByVertex
    //      5. displayGraph
    //      5. addEdge
    //      6. removeEdge

    private int[][] adjacencyMatrix;
    private boolean isUndirectedGraph; // flag to indicate graph is directed or not
    private boolean isWeightedGraph; // flag to indicate graph is weighted or not
    private Integer edgeCount;
    private Integer vertexCount;

    public AdjacencyMatrix(Integer graphSize, boolean isUndirectedGraph, boolean isWeightedGraph) {
        this.adjacencyMatrix = new int[graphSize][graphSize];  
        this.vertexCount = graphSize;
        this.isUndirectedGraph = isUndirectedGraph;
        this.isWeightedGraph = isWeightedGraph;
        this.edgeCount = 0;        
        
        if (isWeightedGraph) {
            for (int i = 0; i < graphSize; i++) {
                Arrays.fill(this.adjacencyMatrix[i], -1);
            }
        }
    }

    public int[][] getAdjacencyMatrix() { return this.adjacencyMatrix; }

    public Integer getNumberOfVertices() { return this.vertexCount; }

    public Integer getNumberOfEdges() { return this.edgeCount; }

    public int[] getEdgesByVertex(int vertex) { return this.adjacencyMatrix[vertex]; }

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
        for (int i = 0; i < this.vertexCount; i++) {
            System.out.print("Vertex " + i + " : ");
            for (Integer neighbor: this.adjacencyMatrix[i]) {
                System.out.print(neighbor + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, true, true);
        adjacencyMatrix.addEdge(1, 2, 10);
        adjacencyMatrix.displayGraph();
    } 
}
