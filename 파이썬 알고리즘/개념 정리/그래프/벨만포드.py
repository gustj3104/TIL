def bellman_ford(graph, start, vertice):
    # 초기값 무한대로 설정
    distance = {node: float('inf') for node in graph}
    distance[start] = 0

    for _ in range(vertice - 1):
        for node in graph:
            for neighbor, weight in graph[node].items():

                # 더 짧은 경로를 발견한 경우
                if distance[node] + weight < distance[neighbor]:
                    distance[neighbor] = distance[node] + weight

    # 음수 사이클 검사
    for node in graph:
        for neighbor, weight in graph[node].items():
            if distance[node] + weight < distance[neighbor]:
                return "음수 사이클"
    
    return distance
