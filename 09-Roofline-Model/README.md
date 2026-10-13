## Aim
Calculate attainable computational performance using the Roofline Model given hardware peak performance, memory bandwidth, and application arithmetic intensity, and classify the workload as memory-bound or compute-bound.

### How to Execute
- **Prerequisites:** Python 3.x (no external packages required).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/09-Roofline-Model
  ```
- **Execution Command:**
  ```bash
  python RooflineModel.py
  ```
  *(or `python3 RooflineModel.py` on Linux/macOS)*
- **Verification:** Verify that the memory bandwidth limit is calculated as `40.0 GFLOP/s`, attainable performance as `40.0 GFLOP/s`, and the regime is classified as `Bound: Memory-bound`.
- **Notes:** Standard Python without third-party mathematical or plotting libraries.

## Input
Predefined hardware and workload specifications:
- Peak Compute Performance: `100.0 GFLOP/s`
- Memory Bandwidth: `10.0 GB/s`
- Arithmetic Intensity: `4.0 FLOP/Byte`

No runtime user input is required.

## Algorithm
1. Define the system parameters:
   - `peak_compute = 100.0` (GFLOP/s)
   - `mem_bandwidth = 10.0` (GB/s)
   - `arith_intensity = 4.0` (FLOP/Byte)
2. Compute the memory bandwidth ceiling:
   `memory_limit = mem_bandwidth * arith_intensity` (GB/s × FLOP/Byte = GFLOP/s)
3. Compute the attainable performance as the minimum of the two physical ceilings:
   `attainable_perf = min(peak_compute, memory_limit)`
4. Determine the performance bottleneck:
   - If `memory_limit < peak_compute`, the workload is **Memory-bound**.
   - Otherwise, the workload is **Compute-bound**.
5. Print all calculated metric values and the bound classification.

## Output
```text
Peak Compute Performance : 100.0 GFLOP/s
Memory Bandwidth         : 10.0 GB/s
Arithmetic Intensity     : 4.0 FLOP/Byte
Memory Bandwidth Limit   : 40.0 GFLOP/s
Attainable Performance   : 40.0 GFLOP/s
Bound: Memory-bound
```

## Complexity Explanation
- **Time Complexity:** O(1), involving a constant number of basic arithmetic and comparison operations.
- **Auxiliary Space:** O(1), requiring storage for a fixed set of floating-point scalar variables.
