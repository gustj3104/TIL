def topological_sorting(graph, vertice):
    visited = [False] * vertice
    stack = list()

    def dfs(node):
        visited[node] = True
        for neighbor in graph[node]:
            if not visited[neighbor]:
                dfs(neighbor)
        stack.append(node)

    for v in range(vertice):
        if not visited[v]:
            dfs(v)

    return stack[::-1]