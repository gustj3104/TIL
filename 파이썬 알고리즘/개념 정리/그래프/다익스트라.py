import heapq

def dikjstra(graph, start):
    # 초기값 무한대로 설정
    distance = {node: float('inf') for node in graph}
    distance[start] = 0
    
    # (거리, 노드) 저장 우선순위 큐
    priority_queue = [(0, start)] 

    while priority_queue:
        current_distance , current_node = heapq.heappop(priority_queue)

        # 이미 처리된 경우
        if current_distance > distance[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            # 더 짧은 경로를 발견한 경우
            if distance < distance[neighbor]:
                distance[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))

    return distance