# 리스트를 활용한 DFS 구현
def dfs(graph, start):
    # need_visited는 리스트 또는 Deque 구조로 관리함.
    need_visited, vistied = list(), list()
    need_visited.append(start)

    while need_visited:
        node = need_visited.pop()
        if node not in vistied:
            vistied.append(node)

            # 인접한 노드를 방문 목록에 저장
            need_visited.extend(graph[node])

    return vistied

