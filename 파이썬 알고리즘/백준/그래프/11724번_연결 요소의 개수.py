# 방향 없는 그래프에서 연결 요소의 개수 구하기
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

def bfs(start, graph, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)

# n: 정점의 개수, m: 간선의 개수
n, m = map(int, input().split())

graph = defaultdict(list)
visited = [False] * (n+1)
count = 0

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, n+1):
    if not visited[i]:
        bfs(i, graph, visited)
        count += 1

print(count)