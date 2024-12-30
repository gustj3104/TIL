def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])  
    return parent[x]

def union(parent, rank, x, y):
    root_x = find(parent, x)
    root_y = find(parent, y)

    if root_x != root_y:
        if rank[root_x] > rank[root_y]:
            parent[root_y] = root_x
        elif rank[root_x] < rank[root_y]:
            parent[root_x] = root_y
        else:
            parent[root_y] = root_x
            rank[root_x] += 1

def kruskal(graph, edges, vertices):
    parent = {i: i for i in range(vertices)}
    rank = {i: 0 for i in range(vertices)}
    mst = []
    edges.sort(key=lambda x: x[2])  

    for u, v, weight in edges:
        if find(parent, u) != find(parent, v):
            union(parent, rank, u, v)
            mst.append((u, v, weight))

    return mst
