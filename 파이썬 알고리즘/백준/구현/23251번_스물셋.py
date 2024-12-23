from collections import deque

# 23으로 이루어진 숫자 리스트 생성
def generate_list_23():
    powers = []
    current = "23"
    for _ in range(12):  # 최대 12자리까지 생성
        powers.append(int(current))
        current += "23"
    return powers

# k번째로 작은 수 찾기
def find_k(k):
    list_23 = generate_list_23()
    queue = deque(list_23)  # BFS 큐 초기화
    seen = set(list_23)     # 중복 방지

    count = 0
    while queue:
        # 가장 작은 값을 꺼냄
        smallest = queue.popleft()
        count += 1

        # k번째 값 도달 시 반환
        if count == k:
            return smallest

        # 새로운 조합 생성
        for num in list_23:
            new_sum = smallest + num
            if new_sum not in seen:
                queue.append(new_sum)
                seen.add(new_sum)

# 입력 및 처리
T = int(input())
for _ in range(T):
    k = int(input())
    print(find_k(k))

''' 
import sys

t = int(sys.stdin.readline())
for _ in range(t):
    num = int(sys.stdin.readline())
    print(num * 23)

'''