package GraphPreparations.practice.day11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    // reference 
    // 1. It's a greedy algorithm used for MST - minimum spanning tree.
    // 2. It works by selecting next smallest vertex based on weight.
    // 3. We use parent array, visited vertices array and minEdgeWeight arrray.
    // 4. It works on undirected and weighted graphs.
    public void executePrims(int startVertex, AdjacencyList adjacencyList) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[1])); // mind heap based on distance
        Integer[] minMstWeights = new Integer[adjacencyList.getNumberOfVertices()];
        boolean[] visited = new boolean[adjacencyList.getNumberOfVertices()];
        Integer[] parent = new Integer[adjacencyList.getNumberOfVertices()];

        Arrays.fill(minMstWeights, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        minMstWeights[startVertex] = 0;
        pq.add(new Integer[]{startVertex, 0}); // vertex, distance

        int mstWeight = 0;
        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();

            if (visited[current[0]]) continue;

            visited[current[0]] = true;
            mstWeight += current[1];

            for (Integer[] neigh: adjacencyList.getAdjacencyList().get(current[0])) {
                int neighVertex = neigh[0], neighWeight = neigh[1];
                if (!visited[neighVertex] && neighWeight < minMstWeights[neighVertex]) {
                    minMstWeights[neighVertex] = neighWeight;
                    pq.add(new Integer[]{neighVertex, minMstWeights[neighVertex]});
                    parent[neighVertex] = current[0];
                }
            }
        }

        System.out.println("Minimum spanning tree edges : ");
        for (int i = 0; i < adjacencyList.getNumberOfVertices(); i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + " (weight: " + minMstWeights[i] + ")");
            }
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public void executePrimsMatrix(Integer startVertex, AdjacencyMatrix adjacencyMatrix) {
        
    }

    public static void main(String[] args) {
        AdjacencyList weightedAdjacencyList = new AdjacencyList(6, false, true);

        weightedAdjacencyList.addEdge(0, 1, 3);
        weightedAdjacencyList.addEdge(0, 2, 3);
        weightedAdjacencyList.addEdge(1, 2, 3);
        weightedAdjacencyList.addEdge(1, 3, 3);
        weightedAdjacencyList.addEdge(2, 3, 3);
        weightedAdjacencyList.addEdge(2, 4, 3);
        weightedAdjacencyList.addEdge(3, 4, 3);
        weightedAdjacencyList.addEdge(4, 5, 3); // Ensure all nodes are connected for MST

        PrimsAlgorithm prims = new PrimsAlgorithm();
        prims.executePrims(0, weightedAdjacencyList);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(6, false, true);
        adjacencyMatrix.addEdge(0, 1, 3);
        adjacencyMatrix.addEdge(0, 2, 3);
        adjacencyMatrix.addEdge(1, 2, 3);
        adjacencyMatrix.addEdge(1, 3, 3);
        adjacencyMatrix.addEdge(2, 3, 3);
        adjacencyMatrix.addEdge(2, 4, 3);
        adjacencyMatrix.addEdge(3, 4, 3);
        adjacencyMatrix.addEdge(4, 5, 3);

        prims.executePrimsMatrix(0, adjacencyMatrix);
    }
}
