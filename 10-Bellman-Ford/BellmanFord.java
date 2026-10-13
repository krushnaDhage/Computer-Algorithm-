public class BellmanFord {

    public static void main(String[] args) {
        int V = 5;
        // Each edge: {from, to, weight}
        int[][] edges = {
            {0, 1, -1},
            {0, 2,  4},
            {1, 2,  3},
            {1, 3,  2},
            {1, 4,  2},
            {3, 2,  5},
            {3, 1,  1},
            {4, 3, -3}
        };

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = INF;
        dist[0] = 0;

        // Relax V-1 times
        for (int pass = 0; pass < V - 1; pass++)
            for (int[] e : edges)
                if (dist[e[0]] != INF && dist[e[0]] + e[2] < dist[e[1]])
                    dist[e[1]] = dist[e[0]] + e[2];

        // Detect negative cycle
        boolean negCycle = false;
        for (int[] e : edges)
            if (dist[e[0]] != INF && dist[e[0]] + e[2] < dist[e[1]]) {
                negCycle = true;
                break;
            }

        if (negCycle) {
            System.out.println("Graph contains a negative-weight cycle.");
        } else {
            System.out.println("Shortest distances from source 0:");
            for (int i = 0; i < V; i++)
                System.out.println("  Vertex " + i + " : " + (dist[i] == INF ? "INF" : dist[i]));
        }
    }
}
