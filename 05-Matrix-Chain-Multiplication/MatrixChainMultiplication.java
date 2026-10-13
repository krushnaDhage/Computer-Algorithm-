public class MatrixChainMultiplication {

    public static void main(String[] args) {
        // Dimensions: matrix i has size p[i] x p[i+1]
        // A1=10x30, A2=30x5, A3=5x60
        int[] p = {10, 30, 5, 60};
        int n = p.length - 1; // number of matrices

        int[][] dp = new int[n][n];

        // Chain length from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + p[i] * p[k+1] * p[j+1];
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }

        System.out.println("Minimum number of multiplications: " + dp[0][n-1]);
    }
}
