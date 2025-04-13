package GraphPreparations.practice.day11;

import java.util.Stack;

public class DFSAdjacencyMatrix {
    
    public void executeDFSIterative(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        int vertex = adjacencyMatrix.getVertexCount();
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;

            visited[current] = true;
            System.out.print(current + ", ");
            for (int i = 0; i < vertex; i++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[current][i] > 0 && !visited[i]) {
                    stack.push(i);
                }
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(Integer vertex, AdjacencyMatrix adjacencyMatrix, boolean[] visitedvertices) {
        if(visitedvertices[vertex]) return;

        visitedvertices[vertex] = true;
        System.out.print(vertex + ", ");
        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            if (adjacencyMatrix.getAdjacencyMatrix()[vertex][i] != 0 && !visitedvertices[i]) {
                executeDFSRecursive(i, adjacencyMatrix, visitedvertices);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5, true, false);
        // Add edges
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(3, 4);
        adjacencyMatrix.displayGraph();

        DFSAdjacencyMatrix dfs = new DFSAdjacencyMatrix();
        dfs.executeDFSIterative(0, adjacencyMatrix);
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getVertexCount()];
        dfs.executeDFSRecursive(0, adjacencyMatrix, visitedVertices);
        System.out.println();
    }
}
