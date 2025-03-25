'''import sys
from collections import Counter

input = sys.stdin.readline

과일을 두 종류 이하로 사용하기
막대기의 앞, 뒤를 빼서 두 종류 이하만 남김 = N - (a+b) 개의 과일이 남음
-> 과일의 개수가 가장 많은 탕후루의 과일 개수 구하기

N = int(input()) # 과일 개수
fruits = list(map(int, input().split()))
fruit_type = set(fruits)

while len(set(fruits)) > 2:
    front_remove = fruits[1:]
    back_remove = fruits[:-1]


    front_count = Counter(front_remove).most_common(1)[0][1]
    # 가장 많이 등장한 요소를 빈도순으로 내림차순 정렬 
        # -> n개 반환 (과일, 개수) -> 개수 저장
    back_count = Counter(back_remove).most_common(1)[0][1]

    if front_count >= back_count: # 앞을 제거한 게 과일 개수가 많은 경우
        fruits = front_remove
    else:
        fruits = back_remove # 뒤를 제거한 게 과일 개수가 많은 경우

print(sum(Counter(fruits).values()))
'''

# 투 포인터 방식
import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
fruits = list(map(int, input().split()))

left = 0
fruit_count = defaultdict(int) 
max_length = 0 

for right in range(N):
    fruit_count[fruits[right]] += 1 # right 포인터로 이동하면서 새로운 과일 추가

    while len(fruit_count) > 2: # 종류가 3개 이상이면
        fruit_count[fruits[left]] -= 1 # 한 종류 제거
        if fruit_count[fruits[left]] == 0:
            del fruit_count[fruits[left]] # 개수가 0이 되면 제거
        left += 1 # 윈도우 왼쪽 이동

    max_length = max(max_length, right - left + 1)

print(max_length)