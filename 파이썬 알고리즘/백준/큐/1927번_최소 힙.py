'''
1. 배열에 자연수 x 넣기
2. 배열에서 가장 작은 값 출력, 그 값 배열에서 제거

- 입력에서 0이 주어진 횟수만큼 답 출력
배열이 비어있는 경우, 가장 작은 값 출력 -> 0 출력

x 가  자연수라면 x 추가 연산, 0이라면 배열에서 가장 작은 값 출력 + 값 제거거
'''
import sys
import heapq
input = sys.stdin.readline

n = int(input()) # 연산 개수

heap = []
for i in range(n):
    x = int(input())
    if x > 0:
        heapq.heappush(heap, x)
    elif x == 0:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap))