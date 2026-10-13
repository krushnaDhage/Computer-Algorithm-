## Aim
Demonstrate parallel computing with MPI by partitioning the first 100 natural numbers (1 to 100) across multiple processes, computing local sums, and aggregating the total sum using `MPI_Reduce`.

### How to Execute
- **Prerequisites:** C compiler with MPI library (OpenMPI, MPICH, or MS-MPI).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/03-Parallel-Programming-MPI
  ```
- **Compilation Command:**
  ```bash
  mpicc MPIExample.c -o MPIExample
  ```
- **Execution Command (4 processes):**
  ```bash
  mpirun -np 4 ./MPIExample
  ```
  *(or `mpiexec -n 4 ./MPIExample` on Windows MS-MPI)*
- **Verification:** Verify that the output reports 4 processes and dynamically computes the sum of the first 100 natural numbers as `5050`.
- **Environment Notes:** If running MPI in containers or environments with restricted root execution, use `mpirun --allow-run-as-root -np 4 ./MPIExample` or follow local cluster permission guidelines.

## Input
- The first 100 natural numbers: 1, 2, 3, ..., 100.
- Number of processes passed dynamically at runtime via the `-np` / `-n` flag (e.g., `-np 4`).

## Algorithm
1. Initialize the MPI execution environment with `MPI_Init(&argc, &argv)`.
2. Retrieve the process rank (`MPI_Comm_rank`) and total process count (`MPI_Comm_size`).
3. Compute the start and end indices of numbers assigned to the current process:
   - `start = rank * (100 / size) + 1`
   - `end = (rank == size - 1) ? 100 : start + (100 / size) - 1`
4. Iterate from `start` to `end` to compute the partial sum `local_sum`.
5. Call `MPI_Reduce` with operator `MPI_SUM` to combine all `local_sum` values into `total_sum` at root (rank 0).
6. Rank 0 prints the total process count and the final calculated sum (`5050`).
7. Clean up and terminate the MPI environment with `MPI_Finalize()`.

## Output
```text
Number of processes: 4
Sum of first 100 numbers: 5050
```

## Complexity Explanation
- **Time Complexity:** O(N / P) local computation per process, where N = 100 and P is the number of MPI processes. The `MPI_Reduce` collective communication step requires O(log P) tree-reduction steps across processes. Total wall-clock time is influenced by communication overhead and hardware latency.
- **Auxiliary Space:** O(1) auxiliary space per process for storing local scalars (`local_sum`, `start`, `end`).
