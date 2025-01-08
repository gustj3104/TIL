import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n = int(input()) # 컴퓨터 수
links = int(input()) # 컴퓨터 쌍의 수

graph = defaultdict(list)
for _ in range(links):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start, graph):
    queue = deque([start])
    visited = [False] * (n + 1)
    visited[start] = True
    count = 0

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1

    return count

print(bfs(1, graph))


