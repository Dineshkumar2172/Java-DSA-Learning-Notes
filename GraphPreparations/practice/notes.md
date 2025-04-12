# 📚 Graph Algorithm Comparison

This document provides a comparison of common graph algorithms based on their applicability to different types of graphs and their ideal use cases.

---

## 📊 Algorithm Feature Comparison Table

| **Algorithm**         | **Directed** | **Undirected** | **Positive Weights** | **Negative Weights** | **Handles Positive Cycles** | **Handles Negative Cycles** | **When to Use** |  **Time Complexity** |
|------------------------|--------------|----------------|------------------------|------------------------|-------------------------------|-------------------------------|------------------|----------------------|
| **BFS (Breadth-First Search)**    | ✅ Yes       | ✅ Yes         | ❌ Not weight-based   | ❌ Not weight-based   | ✅ Yes                        | ✅ Yes                        | Finding shortest path in **unweighted** graphs |  `O(V + E)` |
| **DFS (Depth-First Search)**      | ✅ Yes       | ✅ Yes         | ❌ Not weight-based   | ❌ Not weight-based   | ✅ Yes                        | ✅ Yes                        | **Cycle detection**, **component finding**, topological sort |  `O(V + E)` |
| **Dijkstra's Algorithm**          | ✅ Yes       | ✅ Yes         | ✅ Yes               | ❌ No                | ✅ Yes                        | ❌ No                        | Shortest path with **non-negative** weights |  `O((V + E) log V)` with PQ |
| **Bellman-Ford Algorithm**        | ✅ Yes       | ❌ Rare        | ✅ Yes               | ✅ Yes               | ✅ Yes                        | ✅ Yes                        | Shortest path when **negative weights** are present |  `O(V * E)` |
| **Floyd-Warshall Algorithm**      | ✅ Yes       | ✅ Yes         | ✅ Yes               | ✅ Yes               | ✅ Yes                        | ✅ Yes                        | **All-pairs shortest path**, small graphs |  `O(V³)` |
| **Prim's Algorithm (MST)**        | ❌ No        | ✅ Yes         | ✅ Yes               | ❌ No                | ✅ N/A                       | ❌ N/A                       | **Minimum Spanning Tree**, dense graphs |  `O(E + V log V)` (with PQ) |
| **Kruskal's Algorithm (MST)**     | ❌ No        | ✅ Yes         | ✅ Yes               | ❌ No                | ✅ N/A                       | ❌ N/A                       | **MST**, sparse graphs |  `O(E log E)` |
| **Topological Sort**              | ✅ Yes       | ❌ No          | ❌ Not weight-based   | ❌ Not weight-based   | ❌ No (DAG only)             | ❌ No                        | Task scheduling, **DAG traversal**, prerequisites |  `O(V + E)` |
| **Tarjan’s SCC / Kosaraju’s**     | ✅ Yes       | ❌ No          | ❌ Not weight-based   | ❌ Not weight-based   | ✅ Yes                        | ✅ Yes                        | Finding **Strongly Connected Components** |  `O(V + E)` |
| **Johnson’s Algorithm**           | ✅ Yes       | ❌ Rare        | ✅ Yes               | ✅ Yes               | ✅ Yes                        | ❌ No                        | **All-pairs shortest path** in sparse graphs with negative weights but **no negative cycles** |  `O(V² log V + VE)` |

---

## 📝 Notes

- **BFS/DFS** are best for exploring graph structure, not for shortest paths with weights.
- **Dijkstra’s** is very fast with heaps (PQ), but fails with negative weights.
- **Bellman-Ford** is slower but supports negative weights and detects negative cycles.
- **Floyd-Warshall** is excellent for small graphs where all-pairs shortest paths are needed.
- **Prim/Kruskal** are used in undirected MST problems.
- **Topological Sort** is essential in scheduling and dependency resolution.
- **Tarjan/Kosaraju** are used in graph component analysis (e.g., in compilers, circuit analysis).
- **Johnson’s** is a hybrid algorithm useful when you need all-pairs shortest paths with sparse edges and some negative weights.

---
