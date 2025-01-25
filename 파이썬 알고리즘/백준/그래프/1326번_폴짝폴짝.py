import sys
from collections import deque

input = sys.stdin.readline

n = int(input())  # 징검다리의 수
num = list(map(int, input().split()))  # 징검다리에 적힌 수
a, b = map(int, input().split())  # 시작과 목표 징검다리

def bfs(start, end):
    queue = deque([(start, 0)])  # (현재 위치, 점프 횟수)
    visited = [False] * (n + 1)  # 방문 체크
    visited[start] = True

    while queue:
        current, jumps = queue.popleft()

        # 목표에 도달하면 점프 횟수를 반환
        if current == end:
            return jumps

        # 현재 위치에서 점프 가능한 위치 계산
        step = num[current - 1]  # 현재 징검다리 숫자
        for direction in [-1, 1]:  # 왼쪽(-)과 오른쪽(+) 점프
            next_pos = current + direction * step
            while 1 <= next_pos <= n:  # 범위를 벗어나지 않도록
                if not visited[next_pos]:  # 방문하지 않았다면
                    visited[next_pos] = True
                    queue.append((next_pos, jumps + 1))
                next_pos += direction * step  # 같은 방향으로 다음 점프

    # 목표에 도달할 수 없는 경우
    return -1

# a번째 징검다리에서 b번째 징검다리로 가는 최소 점프 횟수 출력
print(bfs(a, b))
