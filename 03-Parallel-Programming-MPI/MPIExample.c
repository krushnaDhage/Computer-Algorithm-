#include <stdio.h>
#include <mpi.h>

int main(int argc, char *argv[]) {
    int rank, size;
    long local_sum = 0, total_sum = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* Divide numbers 1..100 among processes */
    int start = rank * (100 / size) + 1;
    int end   = (rank == size - 1) ? 100 : start + (100 / size) - 1;

    for (int i = start; i <= end; i++)
        local_sum += i;

    MPI_Reduce(&local_sum, &total_sum, 1, MPI_LONG, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("Number of processes: %d\n", size);
        printf("Sum of first 100 numbers: %ld\n", total_sum);
    }

    MPI_Finalize();
    return 0;
}
