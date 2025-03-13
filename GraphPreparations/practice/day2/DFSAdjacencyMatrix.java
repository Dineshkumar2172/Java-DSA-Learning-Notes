package GraphPreparations.practice.day2;

import java.util.Stack;

public class DFSAdjacencyMatrix {
    
    public void executeDFSIterative(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        boolean[] visitedVertices = new boolean[adjacencyMatrix.getVertexCount()];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.empty()) {
            Integer currentVertex = stack.pop();

            if (visitedVertices[currentVertex]) continue;

            System.out.print(currentVertex + ", ");
            visitedVertices[currentVertex] = true;
            
            for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[currentVertex][i] > 0 && !visitedVertices[i]) {
                    stack.push(i);
                }   
            }
        }

        System.out.println();
    }

    public void executeDFSRecursive(Integer vertex, AdjacencyMatrix adjacencyMatrix, boolean[] visitedvertices) {
        if (visitedvertices[vertex]) return;

        System.out.print(vertex + ", ");
        visitedvertices[vertex] = true;

        for (int i = 0; i < adjacencyMatrix.getVertexCount(); i++) {
            if (adjacencyMatrix.getAdjacencyMatrix()[vertex][i] > 0 && !visitedvertices[i]) {
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
