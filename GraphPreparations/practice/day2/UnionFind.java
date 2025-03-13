package GraphPreparations.practice.day2;

public class UnionFind {
    
    static class Edge {
        Integer src;
        Integer dest;
        Integer weight;
        public Edge(Integer src, Integer dest, Integer weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int vertex) {
            this.parent = new int[vertex];
            this.rank = new int[vertex];
            // each parent is a parent of itself
            for (int i = 0; i < vertex; i++) parent[i] = i; 
        }

        public int find(int vertex) {
            // if the vertex is not a parent of itself
            if (vertex != parent[vertex]) {
                // find the parent, find the root parent of current vertex
                parent[vertex] = find(parent[vertex]);
            }
            
            return parent[vertex];
        }

        public boolean union(int u, int v){
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) return false; // there is a cycle in the graph

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV] > rank[rootU]) {
                parent[rootU] = rootV;
            } else {
                // if both the ranks are same
                // can use any of em as parent and trhe other one as child
                parent[rootU] = rootV;
                rank[rootV]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        
    }
}
