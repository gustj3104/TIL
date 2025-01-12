#2-친구가 가장 많은 사람이 2-친구 수 출력력

import sys
from collections import defaultdict, deque
input = sys.stdin.readline
friend = defaultdict(list)
n = int(input()) #사람 수
        
def bfs(start, graph):
    queue = deque([(start, 0)])
    visited = [False] * (n+1)
    visited[start] = True
    count = 0

    while queue:
        current, depth = queue.popleft()
        if depth == 2:
            continue
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append((neighbor, depth + 1))
                count += 1

    return count


for k in range(n):
    s = input().strip()
    for i, ch in enumerate(s):
        if ch == "Y":
            friend[k+1].append(i + 1)

max_two_friends = 0

for i in range(1, n+1):
    count = bfs(i, friend)
    if count > max_two_friends:
        max_two_friends = count

print(max_two_friends)