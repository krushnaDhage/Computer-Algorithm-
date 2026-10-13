## Aim
Compute single-source shortest paths in a directed edge-weighted graph containing positive and negative edge weights using the Bellman–Ford algorithm, and detect reachable negative-weight cycles.

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/10-Bellman-Ford
  ```
- **Compilation Command:**
  ```bash
  javac BellmanFord.java
  ```
- **Execution Command:**
  ```bash
  java BellmanFord
  ```
- **Verification:** Confirm that shortest distances from source vertex 0 to vertices 0 through 4 are printed (`0, -1, 2, -2, 1`).
- **Notes:** Self-contained implementation without package declarations.

## Input
Predefined directed graph with 5 vertices (0 to 4) and 8 weighted edges, with source vertex `0`. No runtime user input is required.

```java
int V = 5;
int[][] edges = {
    {0, 1, -1}, {0, 2,  4},
    {1, 2,  3}, {1, 3,  2}, {1, 4,  2},
    {3, 2,  5}, {3, 1,  1},
    {4, 3, -3}
};
```

## Algorithm
1. Create a distance array `dist` of size V.
2. Set `dist[source] = 0` and initialize all other entries to infinity (`Integer.MAX_VALUE`).
3. Perform V − 1 relaxation passes over all edges:
   - For each edge `(u, v, weight)`:
     - If `dist[u] != INF` and `dist[u] + weight < dist[v]`, update `dist[v] = dist[u] + weight`.
4. Perform a V-th relaxation pass to check for negative-weight cycles:
   - If any edge can still be relaxed, a reachable negative cycle exists.
5. If a negative cycle is detected, print a warning message; otherwise, print the final shortest distances from the source to every vertex.

## Output
```text
Shortest distances from source 0:
  Vertex 0 : 0
  Vertex 1 : -1
  Vertex 2 : 2
  Vertex 3 : -2
  Vertex 4 : 1
```

## Complexity Explanation
- **Time Complexity:** O(V × E), where V is the number of vertices (5) and E is the number of edges (8). The algorithm executes V − 1 main relaxation passes followed by 1 negative-cycle detection pass, with each pass inspecting all E edges.
- **Auxiliary Space:** O(V) auxiliary space for the `dist` array holding tentative distances.
