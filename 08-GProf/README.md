## Aim
Demonstrate execution profiling of native C programs using the GNU Profiler (GProf) to measure function execution times, call counts, and call-graph hierarchies.

### How to Execute
- **Prerequisites:** GCC compiler with GProf support (`gcc`, `gprof`).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/08-GProf
  ```
- **Compilation Command (with profiling instrumentation):**
  ```bash
  gcc -pg GProfDemo.c -o GProfDemo
  ```
- **Execution Command (generates runtime profile data `gmon.out`):**
  ```bash
  ./GProfDemo
  ```
- **Profile Analysis Command:**
  ```bash
  gprof ./GProfDemo gmon.out
  ```
- **Verification:** Ensure `./GProfDemo` runs and creates `gmon.out`, then confirm `gprof` outputs a flat profile listing `sumOfSquares` and `sumOfCubes` along with their call graph.
- **Notes:** GProf instrumentation requires the program to terminate normally so that the profiling runtime flushes `gmon.out` to disk.

## Input
Predefined computational workloads inside the program with loop limit `n = 10000`. No runtime user input is required.

```c
int n = 10000;
long long sq = sumOfSquares(n);
long long cu = sumOfCubes(n);
```

## Algorithm
1. Implement computational worker functions (`sumOfSquares` accumulating `i²` and `sumOfCubes` accumulating `i³`).
2. Main invokes each function and outputs the calculated totals.
3. Compile the source with the `-pg` compiler option to inject profiling hooks (`mcount`) at function entry points.
4. Execute the resulting binary; during execution, sample counts and function calls are tracked and written to `gmon.out` upon exit.
5. Invoke `gprof` with the executable and `gmon.out` to parse and render:
   - **Flat Profile:** Total time spent in each function and call counts.
   - **Call Graph:** Parent-child caller relationships and time propagation.

## Output
Program execution output:
```text
Sum of squares up to 10000: 333383335000
Sum of cubes   up to 10000: 2500500025000000
```

Representative GProf flat profile snippet:
```text
Flat profile:
Each sample counts as 0.01 seconds.
  %   cumulative   self              self     total           
 time   seconds   seconds    calls  ms/call  ms/call  name    
100.00      0.01     0.01        1    10.00    10.00  sumOfCubes
  0.00      0.01     0.00        1     0.00     0.00  sumOfSquares
```

## Complexity Explanation
- **Function Workload:** Both `sumOfSquares` and `sumOfCubes` execute a single deterministic loop of size `n`, taking O(n) computational steps each with O(1) auxiliary space.
- **Profiling Tool Behavior:** GProf is an empirical profiling utility, not an algorithm. Its overhead adds slight instrumentation instructions at function boundaries and periodic timer interrupts. Actual profile timings vary based on host CPU speed, compiler optimization, and system load.
