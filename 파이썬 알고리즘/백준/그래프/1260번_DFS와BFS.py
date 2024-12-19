import sys
from collections import deque

input = sys.stdin.readline

# DFS 함수 (스택)
def dfs(graph, start):
    visited = []
    need_visited = []

    need_visited.append(start)

    while need_visited:
        node = need_visited.pop()
        if node not in visited:
            visited.append(node)
            need_visited.extend(sorted(graph[node], reverse=True))

    print(*visited)

# BFS 함수 (큐)
def bfs(graph, start):
    need_visited = deque([start])
    visited = []

    while need_visited:
        node = need_visited.popleft()
        if node not in visited:
            visited.append(node)
            need_visited.extend(sorted(graph[node]))

    print(*visited)

# 입력 받기
n, m, v = map(int, input().split())
graph = {i: [] for i in range(1, n+1)}

# 간선 정보 저장
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 탐색 실행
dfs(graph, v)
bfs(graph, v)
