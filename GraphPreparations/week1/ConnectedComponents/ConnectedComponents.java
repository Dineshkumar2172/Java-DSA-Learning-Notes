package GraphPreparations.week1.ConnectedComponents;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.week1.GraphRepresentations.AdjacencyList;

public class ConnectedComponents {
    // Connected compoentes are used to find how many connected components are there in a disconnected graph.
    // It can achieved by simply running DFS/BFS on each unvisited nodes. Because by default dfs and bfs only
    // traverses the connected component to which input source node belongs to. Connected components is a way
    // to traverse all the components even if they are not connected.

    private LinkedList<Integer>[] adjList;
    boolean[] visitedVertices;

    public void bfs(Integer vertex, AdjacencyList adjacencyList) {
        if (!adjacencyList.isValidVertex(vertex)) {
            System.out.println("Invalid start vertex");
            return;
        }

        this.adjList = adjacencyList.getAdjList();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(vertex);
        visitedVertices[vertex] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + ", ");

            for (Integer neighbor : adjList[current]) {
                if (!visitedVertices[neighbor]) { 
                    queue.offer(neighbor);
                    visitedVertices[neighbor] = true;
                }
            }
        }

        System.out.println();
    }

    public void findConnectedComponents(AdjacencyList adjacencyList) {
        this.visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];

        int componentCount = 0;
        for (int i = 0; i < visitedVertices.length; i++) {
            if (!visitedVertices[i]) {
                System.out.print("component count : " + componentCount + " || ");
                bfs(i, adjacencyList);
                System.out.println();
                componentCount++;
            }
        }
    };

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, true);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(2, 4);

        ConnectedComponents connectedComponents = new ConnectedComponents();
        connectedComponents.findConnectedComponents(adjacencyList);
    }
}
