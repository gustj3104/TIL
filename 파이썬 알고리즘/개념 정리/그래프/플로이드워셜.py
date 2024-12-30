def floyd_warshall(graph, vertices):
    # 초기값 무한대로 설정
    dist = [[float('inf')] * vertices for _ in range(vertices)]
    
    # 자기 자신으로 향하는 거리는 0으로 설정
    for u in range(vertices):
        dist[u][u] = 0

    for u in range(vertices):
        for v, weight in graph[u].items():
            dist[u][v] = weight

    for k in range(vertices):
        for i in range(vertices):
            for j in range(vertices):
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

    return dist