import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        int V = 5;
        // Adjacency list: list of {neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Undirected edges
        int[][] edges = {
            {0, 1, 10},
            {0, 4,  3},
            {1, 2,  2},
            {1, 4,  4},
            {2, 3,  9},
            {3, 2,  7},
            {4, 1,  1},
            {4, 2,  8},
            {4, 3,  2}
        };
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int src = 0;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // PriorityQueue: {distance, vertex}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];
            if (d > dist[u]) continue;
            for (int[] nb : adj.get(u)) {
                int v = nb[0], w = nb[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println("  Vertex " + i + " : " + dist[i]);
    }
}
