import math

# Dataset: 2D points
points = [
    [1, 1], [1, 2], [2, 1],
    [8, 8], [9, 8], [8, 9],
    [5, 5], [5, 6], [6, 5]
]

K = 3
MAX_ITER = 100

# Initialize centroids as first K points
centroids = [points[i][:] for i in range(K)]

def distance(a, b):
    return math.sqrt(sum((a[i] - b[i]) ** 2 for i in range(len(a))))

def assign_clusters(points, centroids):
    clusters = [[] for _ in range(K)]
    for p in points:
        nearest = min(range(K), key=lambda i: distance(p, centroids[i]))
        clusters[nearest].append(p)
    return clusters

def update_centroids(clusters):
    new_centroids = []
    for cluster in clusters:
        if cluster:
            centroid = [sum(p[d] for p in cluster) / len(cluster) for d in range(len(cluster[0]))]
        else:
            centroid = [0.0, 0.0]
        new_centroids.append(centroid)
    return new_centroids

for iteration in range(MAX_ITER):
    clusters = assign_clusters(points, centroids)
    new_centroids = update_centroids(clusters)
    if new_centroids == centroids:
        break
    centroids = new_centroids

print("Final Clusters:")
for i, cluster in enumerate(clusters):
    print(f"  Cluster {i + 1}: {cluster}")

print("\nFinal Centroids:")
for i, c in enumerate(centroids):
    print(f"  Centroid {i + 1}: [{c[0]:.2f}, {c[1]:.2f}]")
