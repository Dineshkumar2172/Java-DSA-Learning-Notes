package GraphPreparations.practice.day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    // information on dijkstra
    // 1. Greedy algorithm - single source shortest path algorithm.
    // 2. Dijkstra's algorithm only cares about visiting the smallest known distance nodes first, making it independent of directionality.
    // 3. Supports only positive weighted graphs and positive weighted cycle.

    public void executeDijkstra(Integer startVertex, AdjacencyList adjacencyList) {
        Integer[] shortestDistance = new Integer[adjacencyList.getNumberOfVertices()];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[startVertex] = 0; // distance to a vertex from itself is always 0

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[1])); // priority queue based on weight
        pq.offer(new Integer[]{startVertex, 0});

        while (!pq.isEmpty()) {
            Integer currentInfo[] = pq.poll();
            Integer currentVertex = currentInfo[0], currentVertexWeight = currentInfo[1];

            if (currentVertexWeight > shortestDistance[currentVertex]) continue;
            for (Integer[] neighbor: adjacencyList.getAdjacencyList().get(currentVertex)) {
                Integer neighborVertex = neighbor[0];
                Integer neighborVertexWeight = currentVertexWeight + neighbor[1];
                if (neighborVertexWeight < shortestDistance[neighborVertex]) {
                    shortestDistance[neighborVertex] = neighborVertexWeight;
                    pq.add(new Integer[]{neighborVertex, neighborVertexWeight});
                }
            }
        }

        System.out.println("Shortest distance from the source vertex +" + startVertex + ": ");
        for (int i = 0; i < shortestDistance.length; i++) {
            System.out.println("From vertex 0 to " + i + ": " + shortestDistance[i]);
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(6, false, true);
        adjacencyList.addEdge(0, 1, 4);
        adjacencyList.addEdge(0, 2, 4);
        adjacencyList.addEdge(1, 2, 2);
        adjacencyList.addEdge(2, 3, 3);
        adjacencyList.addEdge(2, 4, 1);
        adjacencyList.addEdge(3, 5, 2);
        adjacencyList.addEdge(4, 5, 3);
        adjacencyList.displayGraph();

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.executeDijkstra(0, adjacencyList);
    }
}
