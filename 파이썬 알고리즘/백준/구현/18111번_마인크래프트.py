import sys
from collections import Counter
input = sys.stdin.readline

N, M, B = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(N)] 

counter = Counter([height for row in field for height in row]) # 높이별 빈도수
min_h, max_h = min(counter.keys()), max(counter.keys()) # 필드의 최소 / 최대 높이

best_time = float('inf')
best_height = 0

for h in range(min_h, max_h + 1):
    add_blocks, remove_blocks = 0, 0

    for height, freq in counter.items(): # 가능한 모든 높이 검사
        if height < h: # 현재 높이보다 낮은 경우
            add_blocks += (h-height) * freq 
        elif height > h: # 현재 높이보다 높은 경우
            remove_blocks += (height - h) * freq

    if remove_blocks + B >= add_blocks: # 블록 수가 충분한지 검사
        time = remove_blocks * 2 + add_blocks 
        if time < best_time or (time == best_time and h > best_height):
            best_time = time
            best_height = h

print(best_time, best_height)