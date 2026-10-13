public class CurrencyArbitrage {

    public static void main(String[] args) {
        // Currencies: 0=USD, 1=EUR, 2=GBP
        String[] names = {"USD", "EUR", "GBP"};

        double[][] rates = {
            {1.00, 0.85, 0.75},
            {1.18, 1.00, 0.88},
            {1.33, 1.14, 1.00}
        };

        int V = names.length;

        // Build edge list with weight = -log(rate)
        int E = V * V - V;
        int[] from = new int[E];
        int[] to   = new int[E];
        double[] weight = new double[E];
        int idx = 0;
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (i != j) {
                    from[idx]   = i;
                    to[idx]     = j;
                    weight[idx] = -Math.log(rates[i][j]);
                    idx++;
                }

        // Bellman-Ford from source 0
        double[] dist = new double[V];
        for (int i = 0; i < V; i++) dist[i] = Double.MAX_VALUE;
        dist[0] = 0.0;

        for (int pass = 0; pass < V - 1; pass++)
            for (int e = 0; e < E; e++)
                if (dist[from[e]] != Double.MAX_VALUE &&
                    dist[from[e]] + weight[e] < dist[to[e]])
                    dist[to[e]] = dist[from[e]] + weight[e];

        // Extra pass: detect negative cycle
        boolean arbitrage = false;
        for (int e = 0; e < E; e++)
            if (dist[from[e]] != Double.MAX_VALUE &&
                dist[from[e]] + weight[e] < dist[to[e]]) {
                arbitrage = true;
                break;
            }

        if (arbitrage)
            System.out.println("Arbitrage opportunity exists!");
        else
            System.out.println("No arbitrage opportunity found.");
    }
}
