'''
오름차순 정렬

(1번 시도 -> 메모리 초과)
n=int(input())
lst = []
for i in range(n):
    m = int(input())
    lst.append(m)
    
lst.sort()

for i in lst:
    print(i)
'''

# 2번 시도 - 계수 정렬
import sys
input = sys.stdin.readline

n = int(input())
lst = [0] * (10000+1)

# 각 입력값에 해당하는 인덱스의 값 +1
for _ in range(n):
    lst[int(input())] += 1

print(lst)

for i in range(len(lst)):
    if lst[i] != 0: #0이 아닌 데이터 출력
        print("lst[i]:",lst[i])
        for _ in range(lst[i]):
            print(i)

'''
계수 정렬: 카운트할 배열을 선언하고, 정렬할 배열 요소가 몇 개가 있는지 카운트 배열 각 인덱스에 담는다.
예시 arr = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2] - 정렬할 리스트
cnt = [0] * (max(arr) + 1) - 카운트 배열

for i in range(len(arr)):
    cnt[arr[i]] += 1

for i in range(len(cnt)):
    for _ in range(cnt[i]):
        print(i, end=" ")
'''