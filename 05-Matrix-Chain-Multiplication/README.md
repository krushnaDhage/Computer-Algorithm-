## Aim
Compute the minimum number of scalar multiplications required to multiply a given sequence of matrices using Dynamic Programming.

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/05-Matrix-Chain-Multiplication
  ```
- **Compilation Command:**
  ```bash
  javac MatrixChainMultiplication.java
  ```
- **Execution Command:**
  ```bash
  java MatrixChainMultiplication
  ```
- **Verification:** Verify that the program computes and prints `Minimum number of multiplications: 4500`.
- **Notes:** Simple single-file program with predefined matrix dimensions.

## Input
Predefined dimension array for 3 matrices: A1 (10×30), A2 (30×5), and A3 (5×60). No runtime user input is required.

```java
int[] p = {10, 30, 5, 60};
// Matrix i has dimension p[i] x p[i+1]
```

## Algorithm
1. Let `n` be the number of matrices (here `n = 3`).
2. Construct a 2D dynamic programming table `dp[n][n]`.
3. Set base cases: `dp[i][i] = 0` for all `0 <= i < n` (a single matrix incurs 0 multiplications).
4. Iterate through chain length `len` from 2 to `n`:
   - For each starting matrix `i` and ending matrix `j = i + len - 1`:
     - Initialize `dp[i][j]` to infinity.
     - Try every split position `k` from `i` to `j - 1`:
       `cost = dp[i][k] + dp[k+1][j] + p[i] * p[k+1] * p[j+1]`
     - Store the minimum cost in `dp[i][j]`.
5. The entry `dp[0][n-1]` contains the minimum scalar multiplications for the full chain.
6. Print `dp[0][n-1]`.

## Output
```text
Minimum number of multiplications: 4500
```

## Complexity Explanation
- **Time Complexity:** O(N³), where N is the number of matrices (3). The solution uses three nested loops: one for chain lengths (2 to N), one for start indices (0 to N − len), and one for split positions k (i to j − 1).
- **Auxiliary Space:** O(N²) auxiliary space to store the `dp` cost matrix of size N × N.
