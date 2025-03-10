package GraphPreparations.week2;

import java.util.LinkedList;

public class WeightedAdjacencyList {

    private LinkedList<Integer[]>[] adjacencyList;
    private Integer vertexCount;
    private Integer edgeCount;
    private boolean isUndirectedGraph;

    public WeightedAdjacencyList(Integer graphSize, boolean isUndirectedGraph) {
        this.adjacencyList = new LinkedList[graphSize];
        this.vertexCount = graphSize;
        this.edgeCount = 0;
        this.isUndirectedGraph = isUndirectedGraph;

        for (int i = 0; i < graphSize; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(Integer startVertex, Integer endVertex, Integer weight) {
        this.adjacencyList[startVertex].add(new Integer[]{endVertex, weight}); // connected vertex at index 0 and edge weight at index 1
        this.edgeCount++;
        if (isUndirectedGraph) {
            this.adjacencyList[endVertex].add(new Integer[]{startVertex, weight});
            this.edgeCount++;
        }
    }

    public void removeEdge(Integer startVertex, Integer endVertex) {
        this.adjacencyList[startVertex].removeIf(edge -> edge[0] == endVertex);
        this.vertexCount--;
        if (isUndirectedGraph) {
            this.adjacencyList[endVertex].removeIf(edge -> edge[0] == startVertex);
            this.vertexCount--;
        }
    }

    public void displayGraph() {
        for(int i = 0; i < this.vertexCount; i++) {
            System.out.print(i + " : ");
            for(Integer[] edge: this.adjacencyList[i]) {
                System.out.print("[" + edge[0] + ", "+ edge[1] + "], ");
            }
            System.out.println();
        }
    }

    // function to get the adjacency list of the graph
    public LinkedList<Integer[]>[] getAdjacencyList() { return this.adjacencyList; }

    // function to get the number of vertices in a graph
    public Integer getVertexCount() { return this.vertexCount; }

    // function to get the number of edges in a graph
    public Integer getEdgeCount() { return this.edgeCount; }
}
