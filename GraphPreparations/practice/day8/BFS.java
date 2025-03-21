package GraphPreparations.practice.day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFS {
	public void executeBFS(int srcVertex, List<List<Integer>> adjList) {
		int n = adjList.size();
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(srcVertex);
		visited[srcVertex] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			// operation, assume I print here
			System.out.print(current + ", ");
			for (Integer neighbor: adjList.get(current)) {
				if (!visited[neighbor]) {
					queue.offer(neighbor);
					visited[neighbor] = true;
                } 
			}
		}

        System.out.println();
    }

    public void executeBFS(int srcVertex, int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(srcVertex);
        visited[srcVertex] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");
            for (int i = 0; i < n; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
	
	public static void main(String[] args) {
		// build the input adjacency matrix / list
		// create a object for the BFS and access executeBFS func by keeping
		// adjacency matrix / list as an input.
        int v = 6;
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 5}, {4, 5}
        };

        // adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        BFS bfs = new BFS();
        bfs.executeBFS(0, adjList);

        // adjacency matrix implementation
        int[][] adjMatrix = new int[v][v];
        for (int[] edge: edges) {
            adjMatrix[edge[0]][edge[1]] = 1;
        }
        bfs.executeBFS(0, adjMatrix);
	}
}

