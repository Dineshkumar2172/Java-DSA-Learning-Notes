package GraphPreparations.practice.day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {

    public void dfs(Integer vertex, boolean[] visitedVertices, Stack<Integer> stack, AdjacencyList adjacencyList) {
        
    }

    public void executeTopologicalSortDFS(AdjacencyList adjacencyList) {
       
    }

    public void executeTopologicalSortBFS(AdjacencyList adjacencyList) {
        
    }


    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false, false);
        adjacencyList.addEdge(5, 2);
        adjacencyList.addEdge(5, 0);
        adjacencyList.addEdge(4, 0);
        adjacencyList.addEdge(4, 1);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 1);

        TopologicalSorting topoSort = new TopologicalSorting();
        topoSort.executeTopologicalSortDFS(adjacencyList);
        topoSort.executeTopologicalSortBFS(adjacencyList);
    }
}
