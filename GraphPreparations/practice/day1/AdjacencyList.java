package GraphPreparations.practice.day1;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    // Representation
    //      1. It's gonna be an array of linkedlist.
    //      2. Each index in the array represent different vertices in the graph.
    //      3. Each node in the linkedlist represents edges connecting vertex i to other vertices.
    //      4. It could be either weighted, unweighted, directed or undirected.
    //
    // Operations:
    //      1. GetAdjacencyList
    //      2. GetNumberOfVertices
    //      3. GetNumberOfEdges
    //      4. GetEdgesByVertex
    //      5. Display Graph
    //      5. AddEdge
    //      6. RemoveEdge
    
    private ArrayList<LinkedList<Integer[]>> adjacencyList;
    private Integer edgeCount;
    private Integer vertexCount;
    private boolean isUndirectedGraph;
    private boolean isWeightedGraph;

    public AdjacencyList(Integer graphSize, boolean isUndirectedGraph, boolean isWeightedGraph) {
        this.adjacencyList = new ArrayList<>(graphSize);
        this.vertexCount = graphSize;
        this.isUndirectedGraph = isUndirectedGraph;
        this.isWeightedGraph = isWeightedGraph;
        this.edgeCount = 0;
        for (int i = 0; i < graphSize; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(Integer startVertex, Integer endVertex) {
        this.adjacencyList.get(startVertex).add(new Integer[]{endVertex});
        this.edgeCount++;
        if (this.isUndirectedGraph) {
            this.adjacencyList.get(endVertex).add(new Integer[]{startVertex});
            this.edgeCount++;
        }
    }

    public void addEdge(Integer startVertex, Integer endVertex, Integer weight) {
        this.adjacencyList.get(startVertex).add(new Integer[]{endVertex, weight});
        this.edgeCount++;
        if (this.isUndirectedGraph) {
            this.adjacencyList.get(endVertex).add(new Integer[]{startVertex, weight});
            this.edgeCount++;
        }
    }

    public void removeEdge(Integer startVertex, Integer endVertex) {
        this.adjacencyList.get(startVertex).removeIf(arr -> arr[0] == endVertex);
        this.edgeCount--;
        if (this.isUndirectedGraph) {
            this.adjacencyList.get(endVertex).removeIf(arr -> arr[0] == startVertex);
            this.edgeCount--;
        }
    }

    public void displayGraph() {
        System.out.println("graphical representation of the adjacency list");
        for (int i = 0; i < this.vertexCount; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer[] neighbor: this.getAdjacencyList().get(i)) {
                if (isWeightedGraph) {
                    System.out.print("[" + neighbor[0] + ", " + neighbor[1]  + "]");
                    continue;
                }
                System.out.print(neighbor[0] + ", ");
            }
            System.out.println();
        }
    }

    public LinkedList<Integer[]> getEdgesByVertex(Integer vertex) {
        return this.adjacencyList.get(vertex);
    }

    public ArrayList<LinkedList<Integer[]>> getAdjacencyList() { return this.adjacencyList; }

    public Integer getNumberOfVertices() { return this.vertexCount; }

    public Integer getEdgeCount() { return this.edgeCount; }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(10, true, true);
        adjacencyList.addEdge(1, 2, 10);
        adjacencyList.addEdge(5, 6, 30);
        adjacencyList.removeEdge(1, 2);
        adjacencyList.displayGraph();
    }

}
