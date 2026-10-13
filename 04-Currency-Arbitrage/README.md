## Aim
Detect currency arbitrage opportunities by mapping foreign exchange rates to a directed graph with negative log weights and applying the Bellman–Ford algorithm to detect negative-weight cycles.

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/04-Currency-Arbitrage
  ```
- **Compilation Command:**
  ```bash
  javac CurrencyArbitrage.java
  ```
- **Execution Command:**
  ```bash
  java CurrencyArbitrage
  ```
- **Verification:** Verify that the program analyzes the currency graph and reports `Arbitrage opportunity exists!`.
- **Notes:** Standard Java runtime only; no external matrix or graphing libraries needed.

## Input
Predefined 3×3 foreign exchange table across USD, EUR, and GBP. No runtime user input is required.

```java
String[] names = {"USD", "EUR", "GBP"};
double[][] rates = {
    {1.00, 0.85, 0.75},  // USD -> USD, EUR, GBP
    {1.18, 1.00, 0.88},  // EUR -> USD, EUR, GBP
    {1.33, 1.14, 1.00}   // GBP -> USD, EUR, GBP
};
```

## Algorithm
1. Treat each currency as a vertex (V = 3) and each exchange path as a directed edge.
2. Transform each positive exchange rate `r` into edge weight `w = -Math.log(r)`. A profitable conversion cycle where the product of rates exceeds 1.0 translates to a cycle whose sum of weights is negative.
3. Initialize the distance array with `dist[0] = 0` and all other distances to infinity.
4. Execute V − 1 relaxation passes over all edges:
   - If `dist[u] + w < dist[v]`, update `dist[v] = dist[u] + w`.
5. Run an additional verification pass:
   - If any edge can still be relaxed, a negative cycle exists, indicating an arbitrage opportunity.
6. Print the resulting decision.

## Output
```text
Arbitrage opportunity exists!
```

## Complexity Explanation
- **Time Complexity:** O(V × E), where V is the number of currencies (3) and E = V(V − 1) is the number of currency pairs (6). Bellman–Ford runs V − 1 relaxation rounds followed by 1 cycle-detection round across all E edges.
- **Auxiliary Space:** O(V + E) auxiliary space to store currency distances and the flattened edge array representation.
