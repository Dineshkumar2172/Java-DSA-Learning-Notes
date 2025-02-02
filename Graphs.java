public class Graphs {
    
    private int[][] adjMatrix;
    private int V; // number of vertices in graph
    private int E; // number of edges in graph

    public Graphs(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v){
        // in undirected graph, nodes are birectional
        // relationship between em will go both ways, so both are set to 1
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
        this.E++; // increase the edges as we add nodes
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            stringBuilder.append(v + " : ");
            for (int w : adjMatrix[v]) {
                stringBuilder.append(w + " ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /**
         * What is a Graph?
         *      1. It's a non linear data structure used for storing data.
         *      2. It is a set of vertices and a collection of edges that connects a pair of vertices.
         *      3. Nodes are the vertex of graph and each line connecting them is called as edge.
         *      3. Graphs help us implement social networking sites such as Facebook, Twitter etc. It can be called as social networking graph.
         *      4. Names of people represent vertices of graph and friendship between two people can be represented as an edge of graph.
         *          (https://youtu.be/2ZLl8GAk1X4?t=113979)
         */

         // Adjacency Matrix Representation (Undirected Graph)
         // What is an undirected graph?
         //     1. Example - social networking graph is an undirected graph.
         //     2. If John is a friend to max, then max is also a friend to john.
         
         // Adjacency Matrix Implementation (Undirected Graph)
         Graphs graphs = new Graphs(4);
         graphs.addEdge(0, 1);
         graphs.addEdge(1, 2);
         graphs.addEdge(2, 3);
         graphs.addEdge(3, 0);
         System.out.println(graphs);

         // Number of Islands - https://youtu.be/2ZLl8GAk1X4?t=122166
         Graphs graphs2 = new Graphs(4);
         graphs2.addEdge(0, 1);
         graphs2.addEdge(0, 0);
         graphs2.addEdge(2, 2);
         graphs2.addEdge(3, 3);
         System.out.println(graphs2);
         System.out.println(graphs2.numIslands(graphs2.adjMatrix));

    }


    public int numIslands(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    numIslands++; // once we traverse through the islands, increment islands count
                }
            }
        }

        return numIslands;
    }


    public void dfs(int[][] grid, int row, int col, boolean[][] visited){
        // base case
        // 1. if row or col exceeds the actualy size of matrix (either negatively or positively)
        // 2. if the current vertex is already visited.
        // 3. if the current vertex is a water surrounding the island (0)
        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            visited[row][col] || grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true; // since this node is visited

        // recusive search on horizontal and vertical elements
        dfs(grid, row, col-1, visited); // go left
        dfs(grid, row-1, col, visited); // go up
        dfs(grid, row, col+1, visited); // go right
        dfs(grid, row+1, col, visited); // go down
    }
}
