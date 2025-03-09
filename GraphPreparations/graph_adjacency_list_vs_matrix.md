# 📌 Final Study Plan (4 Weeks) - Graph Algorithms for MAANG Interviews

## 📅 **Week 1: Fundamentals & Graph Traversals**
✔ Learn **Adjacency List vs. Adjacency Matrix** (When to use which).  
✔ Implement **Graph Representation** from scratch in C/Java/Python.  
✔ Master **BFS & DFS** (Both iterative and recursive).  
✔ Solve **5-8 problems** on:
   - Connected components
   - Detecting cycles in graphs
   - Bipartite graph check

---

## 📅 **Week 2: Shortest Path Algorithms**
✔ Learn & Implement:
   - **Dijkstra’s Algorithm** (Priority Queue-based)
   - **Bellman-Ford Algorithm** (Handles negative weights)
   - **Floyd-Warshall Algorithm** (All-pairs shortest path)

✔ Solve **8-10 problems** on:
   - Shortest path in weighted graphs
   - Handling negative weights
   - Graphs with cycles

---

## 📅 **Week 3: Minimum Spanning Tree (MST) & Topological Sorting**
✔ Learn & Implement:
   - **Prim’s Algorithm** (Using both Min Heap & Adjacency Matrix)
   - **Kruskal’s Algorithm** (Using Union-Find)
   - **Topological Sorting** (Both Kahn’s Algorithm & DFS-based)

✔ Solve **8-10 problems** on:
   - MST applications
   - DAG problems & Topological sorting

---

## 📅 **Week 4: Advanced Topics & Mock Interviews**
✔ Learn:
   - **Strongly Connected Components (SCC)**
   - **Cycle detection in Directed & Undirected Graphs**
   - **Network Flow Algorithms (Bonus)**

✔ Solve **10+ mixed problems** from LeetCode/Codeforces/GeeksForGeeks.  
✔ Practice **mock interviews** (Simulate 45-minute coding rounds).

---

## ✅ **Final Checklist Before the Interview**
🔲 Can you implement **BFS & DFS** from scratch in <5 minutes?  
🔲 Can you code **Dijkstra, Bellman-Ford, Floyd-Warshall** without errors?  
🔲 Can you apply **Prim’s & Kruskal’s** efficiently in different scenarios?  
🔲 Are you comfortable with **both Adjacency List & Matrix**?  
🔲 Have you solved **30+ graph problems on LeetCode**?  

---


# Graph Algorithms: Adjacency List vs. Adjacency Matrix

## 📝 When to Learn Both vs. Only One

| **Algorithm**        | **Adjacency List** | **Adjacency Matrix** | **Do You Need Both?** |
|----------------------|------------------|------------------|----------------|
| **DFS** (Graph Traversal) | ✅ | ❌ | ❌ Only List |
| **BFS** (Graph Traversal) | ✅ | ❌ | ❌ Only List |
| **Dijkstra (Shortest Path)** | ✅ (Heap-based) | ✅ (Naïve \(O(V^2)\)) | ✅ Prefer List but Matrix is also possible |
| **Bellman-Ford (Shortest Path with Negatives)** | ✅ | ❌ | ❌ Only List |
| **Floyd-Warshall (All-Pairs Shortest Path)** | ❌ | ✅ | ❌ Only Matrix |
| **Prim’s Algorithm (MST)** | ✅ (Heap-based) | ✅ (Matrix for dense graphs) | ✅ Learn Both |
| **Kruskal’s Algorithm (MST)** | ✅ (Edge List) | ❌ | ❌ Only List |
| **Topological Sort (DAGs)** | ✅ | ❌ | ❌ Only List |
