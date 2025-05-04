package GraphPreparations.practice.day16;

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
        public DisjointSet(int v) {
            this.rank = new int[v];
            this.parent = new int[v];
            for(int i = 0; i < v; i++) parent[i] = i;
        }

        public int find(int v) {
            if (v != parent[v]) {
                parent[v] = find(parent[v]);
            }

            return parent[v];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU ==  rootV) return false;
            
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        
    }
}
