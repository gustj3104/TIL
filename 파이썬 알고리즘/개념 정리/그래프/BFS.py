from collections import deque

def bfs(graph, start):
    need_visited = deque([start])
    visited = []

    while need_visited:
        # 삽입된 순서대로 꺼내기기
        node = need_visited.popleft()
        if node not in visited:
            visited.append(node)

            # 방문하지 않은 인접 노드 큐에 삽입입
            need_visited.extend(sorted(graph[node]))