import heapq

def prim(graph, vertices):
    mst = []
    visited = [False] * vertices
    priority_queue = [(0, 0)]  # (가중치, 정점)

    while priority_queue:
        weight, node = heapq.heappop(priority_queue)

        if not visited[node]:
            visited[node] = True
            mst.append((weight, node))

            for neighbor, cost in graph[node].items():
                if not visited[neighbor]:
                    heapq.heappush(priority_queue, (cost, neighbor))

    return mst
