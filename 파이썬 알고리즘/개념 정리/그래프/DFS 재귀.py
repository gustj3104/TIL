# 재귀함수를 통한 DFS 구현
def dfs(graph, start, visited = []):
    visited.append(start)

    for node in graph[start]:
        if node not in visited:
            dfs(graph, node, visited)
    
    return visited

