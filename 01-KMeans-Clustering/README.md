## Aim
Demonstrate the K-Means clustering algorithm on a small 2D dataset, grouping points into K clusters by iteratively updating centroids.

### How to Execute
- **Prerequisites:** Python 3.x (uses only built-in standard libraries).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/01-KMeans-Clustering
  ```
- **Execution Command:**
  ```bash
  python KMeans.py
  ```
  *(or `python3 KMeans.py` on Linux/macOS)*
- **Verification:** Verify that 9 points are partitioned into 3 distinct clusters and final centroid coordinates are displayed.
- **Notes:** No third-party packages (such as NumPy or scikit-learn) are required.

## Input
Predefined dataset of 9 two-dimensional points and K = 3 clusters. No user input is required.

```python
points = [[1, 1], [1, 2], [2, 1], [8, 8], [9, 8], [8, 9], [5, 5], [5, 6], [6, 5]]
K = 3
```

## Algorithm
1. Initialize K centroids as the first K points of the dataset.
2. For each point, compute the Euclidean distance to every centroid.
3. Assign the point to the cluster whose centroid is nearest.
4. Recalculate each centroid as the mean of all points assigned to it.
5. Repeat steps 2–4 until centroids do not change or the maximum iteration limit is reached.
6. Print the final cluster assignments and centroid coordinates.

## Output
```text
Final Clusters:
  Cluster 1: [[1, 1], [1, 2], [2, 1]]
  Cluster 2: [[8, 8], [9, 8], [8, 9]]
  Cluster 3: [[5, 5], [5, 6], [6, 5]]

Final Centroids:
  Centroid 1: [1.33, 1.33]
  Centroid 2: [8.33, 8.33]
  Centroid 3: [5.33, 5.33]
```

## Complexity Explanation
- **Time Complexity:** O(I × N × K × D), where I is the number of iterations until convergence, N is the number of data points (9), K is the number of clusters (3), and D is the dimensionality of each point (2). Each iteration computes distances from all N points to K centroids and updates coordinates across D dimensions.
- **Auxiliary Space:** O(N + K) auxiliary space to store cluster memberships and centroid coordinates.
