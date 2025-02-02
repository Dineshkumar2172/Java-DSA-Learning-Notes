import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Adjacency list is nothing by an array of linkedlist
public class GraphsAdjacencyList {
    private LinkedList<Integer>[] adj; // array of linkedlist
    private int V; // number of vertices
    private int E; // number of edges

    public GraphsAdjacencyList(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes]; // initialising array of linkedlist with number of nodes
        // representation of adj after initialisation - [null, null, nukl, null] (assuming nodes is 4)
        // array elements points to null since the array is empty after initialising
        
        // reference - https://youtu.be/2ZLl8GAk1X4?t=115564
        for (int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>(); // creating empty linkedlist in each index head pointing to nukl
        }
    }


    public void addEdge(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u); // since its undirected graph
        this.E++;
    }


    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(V + " vertices, " + E + " edges \n");
        for (int v = 0; v < V; v++) {
            stringBuilder.append(v + ": ");
            for (int w : adj[v]) {
                stringBuilder.append(w + " ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        
        /* ADJACENCY LIST REPRESENTATION (Undirected Graph) */
        
        // Each index in the array represents the vertex and holds linkedlist repredenting edges
        // reference - https://youtu.be/2ZLl8GAk1X4?t=115634
        GraphsAdjacencyList graphsAdjacencyList = new GraphsAdjacencyList(5);
        graphsAdjacencyList.addEdge(0, 1); // creates node 1 in linkedlist present in 0th index (head -> 1 -> null) and also created node 0 on index 1 ( head -> 0 -> null )
        graphsAdjacencyList.addEdge(1, 2); // similar to above operation but does for index 1 and 2
        graphsAdjacencyList.addEdge(2, 3); // similar to above operation but does for index 2 and 3
        graphsAdjacencyList.addEdge(3, 0); // similar to above operation but does for index 3 and 0
        graphsAdjacencyList.addEdge(2, 4);
        System.out.println(graphsAdjacencyList);
        graphsAdjacencyList.bfs(0);
        graphsAdjacencyList.dfs(0);
        // graphsAdjacencyList.addEdge(5, 5);
        graphsAdjacencyList.recursiveDfs();
        System.out.println();
    }


    public void bfs(int s){
        boolean[] visited = new boolean[this.V]; // to keep track of the vertices
        // using queue since we need to traverse level by level
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true; // node where we are starting from should be marked as visited
        q.offer(s); // updating queue with the starting vertex to start traversing
        while (!q.isEmpty()) { // if queue is not empty
            int u = q.poll(); // get the data from queue
            System.out.print(u + ", "); // print it down

            // update the connecting vertices to queue for traversing 
            for (int v : adj[u]) {
                if (!visited[v]) {
                    q.offer(v); // updating queue with unvisited vertex
                    visited[v] = true; // mark the updated node as visited
                    
                }
            }
        }
        System.out.println();
    }


    // Depth First Search Using Iterative Approach
    public void dfs(int s){
        boolean[] visited = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                System.out.print(u + ", ");
                visited[u] = true;
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
        System.out.println();
    }


    // Recursive Depth First Search (Undirected Graph)
    public void recursiveDfs() {
        boolean[] visited = new boolean[V];
        // this iteration is kept in place cover those vertices
        // that are not linked with any of the other vertices
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                // this recursive function will actually traverse all 
                // the connected vertices that are linked.
                recursiveDfs(v, visited);
            }
        }
    }


    public void recursiveDfs(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + ", ");
        for(int w: adj[v]){
            if (!visited[w]) {
                recursiveDfs(w, visited);
            }
        }
    }
}
