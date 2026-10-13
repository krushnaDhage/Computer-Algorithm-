# Computer Algorithms Practical

A collection of clean, self-contained, and runnable algorithm implementations tailored for college Computer Algorithms laboratory practicals and examinations. Each practical is located in its own dedicated directory with complete source code and a standardized `README.md`.

## Practicals List

| No. | Practical Name | Language | Directory |
|:---:|---|:---:|---|
| 01 | K-Means Clustering | Python | `01-KMeans-Clustering/` |
| 02 | Huffman Coding | Java | `02-Huffman-Coding/` |
| 03 | Parallel Programming (MPI) | C | `03-Parallel-Programming-MPI/` |
| 04 | Currency Arbitrage (Bellman–Ford) | Java | `04-Currency-Arbitrage/` |
| 05 | Matrix Chain Multiplication | Java | `05-Matrix-Chain-Multiplication/` |
| 06 | Nested Boxes (Dynamic Programming) | Java | `06-Nested-Boxes/` |
| 07 | Quick Sort | Java | `07-Quick-Sort/` |
| 08 | Performance Profiling with GProf | C | `08-GProf/` |
| 09 | Roofline Model | Python | `09-Roofline-Model/` |
| 10 | Bellman–Ford Shortest Path | Java | `10-Bellman-Ford/` |
| 11 | Dijkstra Shortest Path | Java | `11-Dijkstra/` |

## Required Tools and Prerequisites

- **Java JDK (8 or newer)**: Required to compile and run all Java practicals (`javac`, `java`).
- **Python (3.x)**: Required to execute Python scripts (`python` or `python3`).
- **C Compiler (GCC / MinGW / Clang)**: Required to compile C source files.
- **MPI Implementation (OpenMPI, MPICH, or MS-MPI)**: Required for the parallel MPI practical (`mpicc`, `mpirun` or `mpiexec`).
- **GNU Profiler (GProf)**: Required for performance profiling demonstrations (`gprof`).

> **Note:** Java programs require an installed JDK. Python programs run with standard Python 3 without third-party dependencies. C and MPI programs require their respective compiler and runtime toolchains.

## Algorithmic Complexity Summary

| Practical | Time Complexity | Auxiliary Space | Key Concept |
|---|---|---|---|
| 01. K-Means | O(I × N × K × D) | O(N + K) | Iterative centroid convergence |
| 02. Huffman Coding | O(N log N) | O(N) | Greedy min-heap merge |
| 03. Parallel MPI Sum | O(N / P) + O(log P) reduce | O(1) per process | Domain decomposition & tree reduction |
| 04. Currency Arbitrage | O(V × E) | O(V + E) | Negative-log edge transformation & cycle detection |
| 05. Matrix Chain Multiplication | O(N³) | O(N²) | Dynamic programming cost table |
| 06. Nested Boxes | O(N² × D) | O(N) | Box dimension sorting & LIS-style DP |
| 07. Quick Sort | O(N log N) avg / O(N²) worst | O(log N) stack | In-place partitioning & recursion |
| 08. GProf Demonstration | Profiling native execution | Profiling overhead | Function call intercept & statistical sampling |
| 09. Roofline Model | O(1) | O(1) | Arithmetic intensity vs. memory bandwidth ceiling |
| 10. Bellman–Ford | O(V × E) | O(V) | Edge relaxation passes & negative-cycle detection |
| 11. Dijkstra | O((V + E) log V) | O(V + E) | Priority-queue accelerated greedy traversal |

## Directory Navigation

Navigate to the repository root and enter any practical folder to inspect its code and documentation:

```bash
cd Computer-Algorithms-Practical
cd 01-KMeans-Clustering   # Example: entering practical 01
cat README.md
```

Each practical directory features its own `README.md` containing exactly five sections: Aim (including execution guide), Input, Algorithm, Output, and Complexity Explanation.

## Quick-Start Commands

### Python Practical (e.g., K-Means Clustering)
```bash
cd Computer-Algorithms-Practical/01-KMeans-Clustering
python KMeans.py
```

### Java Practical (e.g., Quick Sort)
```bash
cd Computer-Algorithms-Practical/07-Quick-Sort
javac QuickSort.java
java QuickSort
```

### Parallel MPI Practical (e.g., Sum of 100 Numbers)
```bash
cd Computer-Algorithms-Practical/03-Parallel-Programming-MPI
mpicc MPIExample.c -o MPIExample
mpirun -np 4 ./MPIExample
```

### GProf Profiling Practical
```bash
cd Computer-Algorithms-Practical/08-GProf
gcc -pg GProfDemo.c -o GProfDemo
./GProfDemo
gprof ./GProfDemo gmon.out
```
