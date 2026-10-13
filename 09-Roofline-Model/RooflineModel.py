# Roofline Model parameters
peak_compute    = 100.0   # GFLOP/s  (peak CPU performance)
mem_bandwidth   = 10.0    # GB/s     (memory bandwidth)
arith_intensity = 4.0     # FLOP/Byte (flops per byte of memory traffic)

# Roofline limits
memory_limit      = mem_bandwidth * arith_intensity   # GFLOP/s
attainable_perf   = min(peak_compute, memory_limit)

print(f"Peak Compute Performance : {peak_compute:.1f} GFLOP/s")
print(f"Memory Bandwidth         : {mem_bandwidth:.1f} GB/s")
print(f"Arithmetic Intensity     : {arith_intensity:.1f} FLOP/Byte")
print(f"Memory Bandwidth Limit   : {memory_limit:.1f} GFLOP/s")
print(f"Attainable Performance   : {attainable_perf:.1f} GFLOP/s")

if memory_limit < peak_compute:
    print("Bound: Memory-bound")
else:
    print("Bound: Compute-bound")
