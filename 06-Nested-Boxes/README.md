## Aim
Find the maximum length of a nesting sequence for a collection of 3D boxes using sorting and dynamic programming, where a box fits inside another only if every corresponding dimension is strictly smaller.

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/06-Nested-Boxes
  ```
- **Compilation Command:**
  ```bash
  javac NestedBoxes.java
  ```
- **Execution Command:**
  ```bash
  java NestedBoxes
  ```
- **Verification:** Confirm that the output reports `Maximum nesting length: 4`.
- **Notes:** Boxes can be rotated in 3D; sorting dimensions of each box standardizes orientation before comparison.

## Input
Predefined set of 5 three-dimensional boxes. No runtime user input is required.

```java
int[][] boxes = {
    {1, 2, 3},
    {2, 3, 4},
    {3, 4, 5},
    {1, 1, 1},
    {4, 5, 6}
};
```
Dimensional rule: Box A `(a1, a2, a3)` strictly nests inside Box B `(b1, b2, b3)` if and only if `a1 < b1`, `a2 < b2`, and `a3 < b3` after sorting dimensions within each box.

## Algorithm
1. Standardize each box by sorting its three dimensions in non-decreasing order.
2. Sort all boxes in ascending order based on their primary dimension (`boxes[i][0]`).
3. Define an array `dp` of length N with all elements initialized to 1 (`dp[i]` represents the length of the longest nesting chain ending with box `i`).
4. For each box `i` from 1 to N − 1:
   - Compare with every preceding box `j` (where `0 <= j < i`).
   - If box `j` fits strictly inside box `i` across all three dimensions and `dp[j] + 1 > dp[i]`, update `dp[i] = dp[j] + 1`.
5. Determine the maximum value in `dp`.
6. Print the resulting maximum nesting length.

## Output
```text
Maximum nesting length: 4
```

## Complexity Explanation
- **Time Complexity:** O(N² × D), where N is the number of boxes (5) and D is the number of dimensions (3). Sorting dimensions for all boxes takes O(N × D log D), sorting boxes takes O(N log N × D), and the nested dynamic programming comparison loops take O(N² × D).
- **Auxiliary Space:** O(N) auxiliary space for the `dp` array tracking maximum chain lengths.
