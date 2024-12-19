import sys
from collections import deque

input = sys.stdin.readline

# 입력 받기
n, m = map(int, input().split())

# 그래프 초기화
graph = {i: [] for i in range(1, n+1)}

# 친구 관계 입력 받기
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# BFS 함수
def bfs(start):
    visited = [-1] * (n+1) # 리스트 -1로 초기화(-1 : 방문하지 않음)
    queue = deque([start]) 
    visited[start] = 0 # 시작 노드를 방문 상태로 변경
    total_distance = 0 # 거리 계산 변수 초기화

    while queue:
        user = queue.popleft()
        for friend in graph[user]: #인접 노드 탐색
            if visited[friend] == -1: #방문하지 않았다면
                visited[friend] = visited[user] + 1 # 1단계 이동했다는 의미
                total_distance += visited[friend] # 거리값을 누적함
                queue.append(friend)
            print("user", user, ", Freind", friend)
            print("graph[user]", graph[user])
            print("visted", visited)
            print("visted[friend]", visited[friend])
    
    return total_distance

# 케빈 베이컨 수 계산
result = [bfs(i) for i in range(1, n+1)]

# 결과 출력 (최소 값의 인덱스 + 1)
print(result.index(min(result)) + 1)
