## Aim
Compute single-source shortest paths in an undirected graph with non-negative edge weights using Dijkstra's algorithm accelerated with a binary min-heap (`PriorityQueue`).

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/11-Dijkstra
  ```
- **Compilation Command:**
  ```bash
  javac Dijkstra.java
  ```
- **Execution Command:**
  ```bash
  java Dijkstra
  ```
- **Verification:** Confirm that shortest distances from vertex 0 are printed (`Vertex 0: 0, Vertex 1: 4, Vertex 2: 6, Vertex 3: 5, Vertex 4: 3`).
- **Notes:** Standard Java Collections (`List`, `PriorityQueue`) are used without third-party graph dependencies.

## Input
Predefined weighted undirected graph with 5 vertices (0 to 4) and 9 undirected edges (all edge weights are non-negative), with source vertex `0`. No runtime user input is required.

```java
int V = 5;
int[][] edges = {
    {0, 1, 10}, {0, 4, 3},
    {1, 2,  2}, {1, 4, 4},
    {2, 3,  9}, {3, 2, 7},
    {4, 1,  1}, {4, 2, 8},
    {4, 3,  2}
};
```

## Algorithm
1. Represent the graph using an adjacency list where each node stores pairs of `(neighbor, weight)`.
2. Initialize an array `dist` with `dist[source] = 0` and all other entries set to infinity (`Integer.MAX_VALUE`).
3. Insert `(distance=0, vertex=source)` into a min-priority queue (`PriorityQueue`).
4. While the priority queue is not empty:
   a. Extract the pair `(d, u)` with the minimum tentative distance.
   b. If `d > dist[u]`, skip processing (stale heap entry).
   c. For each adjacent edge `(v, weight)` from `u`:
      - If `dist[u] + weight < dist[v]`:
        - Update `dist[v] = dist[u] + weight`.
        - Insert `(dist[v], v)` into the priority queue.
5. Print the shortest distance from the source vertex to all vertices.

## Output
```text
Shortest distances from vertex 0:
  Vertex 0 : 0
  Vertex 1 : 4
  Vertex 2 : 6
  Vertex 3 : 5
  Vertex 4 : 3
```

## Complexity Explanation
- **Time Complexity:** O((V + E) log V), where V is the number of vertices (5) and E is the number of directed edges in the adjacency list (18, since each undirected edge is stored in both directions). Each vertex is extracted from the priority queue at most once (`poll` costs O(log V)), and each edge relaxation may push an entry into the priority queue (`offer` costs O(log V)).
- **Auxiliary Space:** O(V + E) auxiliary space for the adjacency list representation, distance array, and the priority queue.
