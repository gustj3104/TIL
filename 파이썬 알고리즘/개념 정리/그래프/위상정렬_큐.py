from collections import deque

def topological_sorting(graph, vertice):
    indegree = [0] * vertice
    for node in graph:
        for neighbor in graph[node]:
            indegree[neighbor] += 1 

    queue = deque([v for v in range(vertice) if indegree[v] == 0])
    result = []

    while queue:
        node = queue.popleft()
        result.append(node)

        for neighbor in graph[node]:
            indegree[neighbor] -= 1
            if indegree[neighbor] == 0:
                queue.append(neighbor)

    return result