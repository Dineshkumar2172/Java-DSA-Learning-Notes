package GraphPreparations.week1.GraphTraversals;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.week1.GraphRepresentations.AdjacencyList;

public class BreadthFirstSearch {

    private LinkedList<Integer>[] adjList;

    public void bfs(Integer vertex, AdjacencyList adjacencyList) {
        if (!adjacencyList.isValidVertex(vertex)) {
            System.out.println("Invalid start vertex");
            return;
        }

        this.adjList = adjacencyList.getAdjList();
        boolean[] visitedVertices = new boolean[adjacencyList.getNumberOfVertices()];
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

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(10, false);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(3, 4);
        adjacencyList.addEdge(3, 5);
        adjacencyList.addEdge(5, 6);
        adjacencyList.addEdge(3, 7);
        adjacencyList.addEdge(7, 8);
        adjacencyList.addEdge(8, 9);
        adjacencyList.addEdge(9, 5);
        adjacencyList.addEdge(5, 8);
        
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.bfs(0, adjacencyList);        
    }
}
