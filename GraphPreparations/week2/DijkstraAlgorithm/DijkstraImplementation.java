package GraphPreparations.week2.DijkstraAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraImplementation {

    public void ExecuteDijkstra(Integer startVertex, WeightedAdjacencyList weightedAdjacencyList) {
        int[] shortestDistance = new int[weightedAdjacencyList.getVertexCount()];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE); // equivalent to setting the weight as infinity before exploring
        shortestDistance[startVertex] = 0; // distance for a startVertex from itself is always 0

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        pq.offer(new Integer[]{startVertex, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            Integer[] current = pq.poll();
            Integer currentVertex = current[0], currentWeight = current[1];

            if (currentWeight > shortestDistance[currentVertex]) continue; // skip if distance is outdated.

            for (Integer[] neighbor: weightedAdjacencyList.getAdjacencyList()[currentVertex]) {
                Integer nextVertex = neighbor[0], weight = neighbor[1];
                Integer newWeight = currentWeight + weight;

                if (newWeight < shortestDistance[nextVertex]) {
                    shortestDistance[nextVertex] = newWeight;
                    pq.offer(new Integer[]{nextVertex, newWeight});
                }
            }

        }

        System.out.println("Shortest distance from the source vertex " + startVertex + ":");
        for (int i = 0; i < shortestDistance.length; i++) {
            System.out.println("To node " + i + " -> " + (shortestDistance[i] == Integer.MAX_VALUE ? "INF" : shortestDistance[i]));
        }
    }

    public static void main(String[] args) {
        WeightedAdjacencyList weightedAdjacencyList = new WeightedAdjacencyList(6, true);
        weightedAdjacencyList.addEdge(0, 1, 4);
        weightedAdjacencyList.addEdge(0, 2, 4);
        weightedAdjacencyList.addEdge(1, 2, 2);
        weightedAdjacencyList.addEdge(2, 3, 3);
        weightedAdjacencyList.addEdge(2, 4, 1);
        weightedAdjacencyList.addEdge(3, 5, 2);
        weightedAdjacencyList.addEdge(4, 5, 3);

        DijkstraImplementation dijkstraImplementation = new DijkstraImplementation();
        dijkstraImplementation.ExecuteDijkstra(0, weightedAdjacencyList);
    }
}
