import sys
from collections import defaultdict, deque

input = sys.stdin.readline

def bfs(start, graph):
    queue = deque([start])
    visited = [False] * (n + 1)
    visited[start] = True
    count = 1  # 시작 노드 포함

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1
    return count

# 입력
n, m = map(int, input().split())
graph = defaultdict(list)

# 그래프 입력 (역방향 저장)
for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

# 결과 계산
max_hacks = 0
result = []
counts = [0] * (n + 1)  # 각 노드에서 해킹 가능한 컴퓨터 수

# 각 노드에 대해 BFS 수행
for i in range(1, n + 1):
    counts[i] = bfs(i, graph)
    if counts[i] > max_hacks:
        max_hacks = counts[i]
        result = [i]
    elif counts[i] == max_hacks:
        result.append(i)

# 출력
print(*sorted(result))
