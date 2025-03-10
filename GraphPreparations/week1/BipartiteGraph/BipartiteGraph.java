package GraphPreparations.week1.BipartiteGraph;

import java.util.LinkedList;
import java.util.Queue;

import GraphPreparations.week1.GraphRepresentations.AdjacencyList;

public class BipartiteGraph {
    // reference - https://youtu.be/-vu34sct1g8
    // when a two adjacent vertices has a same color - then it's not bipartite
    // when none of the adjacent vertices has a same color - then it's bipartite graph.
    // A graph is bipartite if and only if it does not contain an odd-length cycle. (odd-length cycles are non-bipartites)

    // using the same BFS implementation but with colors array instead of visitedVertices array
    public boolean isBipartiteGraph(AdjacencyList adjacencyList) {
        int[] colors = new int[adjacencyList.getNumberOfVertices()]; // 0: uncolored, 1: red, -1: blue
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1;

                while (!queue.isEmpty()) {
                    Integer current = queue.poll();
                    for (Integer neighbor : adjacencyList.getAdjList()[current]) {
                        if (colors[neighbor] == 0) { // if the neighbor is not visited
                            colors[neighbor] = -colors[current]; // assign opposite color
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[current]) { // if the neighbor is visited and it's color is the same as current
                            return false; // conflict detected (non bipartite)
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        AdjacencyList adjacencyList = new AdjacencyList(4, true);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 0);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(2, 1);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 0);
        adjacencyList.addEdge(3, 2);
        System.out.println(bipartiteGraph.isBipartiteGraph(adjacencyList));


        AdjacencyList adjacencyList2 = new AdjacencyList(4, true);
        adjacencyList2.addEdge(0, 1);
        adjacencyList2.addEdge(0, 2);
        adjacencyList2.addEdge(0, 3);
        adjacencyList2.addEdge(1, 0);
        adjacencyList2.addEdge(1, 2);
        adjacencyList2.addEdge(2, 0);
        adjacencyList2.addEdge(2, 1);
        adjacencyList2.addEdge(2, 3);
        adjacencyList2.addEdge(3, 0);
        adjacencyList2.addEdge(3, 2);
        System.out.println(bipartiteGraph.isBipartiteGraph(adjacencyList2));
    }
}
