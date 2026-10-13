#include <stdio.h>

/* Compute sum of squares up to n */
long long sumOfSquares(int n) {
    long long sum = 0;
    for (int i = 1; i <= n; i++)
        sum += (long long)i * i;
    return sum;
}

/* Compute sum of cubes up to n */
long long sumOfCubes(int n) {
    long long sum = 0;
    for (int i = 1; i <= n; i++)
        sum += (long long)i * i * i;
    return sum;
}

int main() {
    int n = 10000;
    long long sq = sumOfSquares(n);
    long long cu = sumOfCubes(n);
    printf("Sum of squares up to %d: %lld\n", n, sq);
    printf("Sum of cubes   up to %d: %lld\n", n, cu);
    return 0;
}
