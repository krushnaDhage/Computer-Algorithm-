import java.util.Arrays;

public class NestedBoxes {

    // Each box is represented as {d1, d2, d3} with d1 <= d2 <= d3
    static int[][] boxes = {
        {1, 2, 3},
        {2, 3, 4},
        {3, 4, 5},
        {1, 1, 1},
        {4, 5, 6}
    };

    static boolean fits(int[] inner, int[] outer) {
        for (int i = 0; i < inner.length; i++)
            if (inner[i] >= outer[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        // Sort each box dimensions
        for (int[] box : boxes) Arrays.sort(box);

        int n = boxes.length;

        // Sort boxes by first dimension
        Arrays.sort(boxes, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (fits(boxes[j], boxes[i]) && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;

        int maxNesting = 0;
        for (int v : dp) maxNesting = Math.max(maxNesting, v);

        System.out.println("Maximum nesting length: " + maxNesting);
    }
}
