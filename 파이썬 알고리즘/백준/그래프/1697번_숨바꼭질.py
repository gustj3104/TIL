from collections import deque

n, k = map(int, input().split())

def bfs(start, target):
    queue = deque([(start, 0)])  # 현재 위치, 시간 저장
    visited = [False] * 100001  # 방문 여부
    visited[start] = True

    while queue:
        current, time = queue.popleft()

        # 동생 위치에 도달하면 반환
        if current == target:
            return time

        # 이동 가능한 경우를 모두 탐색
        for next_pos in (current - 1, current + 1, current * 2):
            if 0 <= next_pos <= 100000 and not visited[next_pos]:
                visited[next_pos] = True
                queue.append((next_pos, time + 1))

print(bfs(n, k))
