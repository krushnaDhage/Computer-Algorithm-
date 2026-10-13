## Aim
Demonstrate the Quick Sort divide-and-conquer algorithm using an explicit partition method to sort an integer array in ascending order.

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/07-Quick-Sort
  ```
- **Compilation Command:**
  ```bash
  javac QuickSort.java
  ```
- **Execution Command:**
  ```bash
  java QuickSort
  ```
- **Verification:** Verify that the original unsorted array is displayed first, followed by the correctly sorted array in ascending order.
- **Notes:** Pure standalone implementation without reliance on `Arrays.sort()`.

## Input
Predefined integer array of 5 elements. No runtime user input is required.

```java
int[] arr = {64, 25, 12, 22, 11};
```

## Algorithm
1. Choose the last element of the current sub-array `arr[high]` as the pivot.
2. Partition the sub-array:
   - Maintain a pointer `i` for elements smaller than or equal to the pivot.
   - Scan each element `arr[j]` from `low` to `high - 1`.
   - If `arr[j] <= pivot`, increment `i` and swap `arr[i]` with `arr[j]`.
   - Finally, swap `arr[i + 1]` with `arr[high]` to place the pivot in its correct sorted position.
   - Return partition index `i + 1`.
3. Recursively call `quickSort` on the left sub-array (`low` to `pi - 1`).
4. Recursively call `quickSort` on the right sub-array (`pi + 1` to `high`).
5. Terminate recursion when `low >= high`.
6. Print the array before and after sorting.

## Output
```text
Before sorting: [64, 25, 12, 22, 11]
After sorting:  [11, 12, 22, 25, 64]
```

## Complexity Explanation
- **Time Complexity:**
  - **Average Case:** O(N log N), where partitioning takes O(N) linear time and the recursion tree has a balanced depth of O(log N).
  - **Worst Case:** O(N²), which occurs when the pivot consistently partitions the array into highly unbalanced sub-arrays (e.g., already sorted array with the end element chosen as pivot).
- **Auxiliary Space:** O(log N) auxiliary space for recursive call stack frames on average (O(N) in the worst case).
