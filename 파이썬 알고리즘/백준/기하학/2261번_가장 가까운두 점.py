'''
import sys
# from collections import defaultdict
input = sys.stdin.readline
field = list()
distance = list()

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    field.append([x, y])

for x1, y1 in field:
    for x2, y2 in field:
        d = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)
        if d != 0:
            distance.append(d)

print(min(distance))
'''

import sys
import math

def find_closest(points):
    def distance(p1, p2): # 점 간 거리 계산
        return(p1[0]-p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
    
    def closest_in_strip(strip, min_dist):
        min_d = min_dist
        # strip : 분할된 영역 주변 점 -> mid_dist = 발견된 최소 거리 제곱
        strip.sort(key = lambda p: p[1]) # y 기준 정렬

        # 가까운 점 쌍만 비교해 최소 거리 갱신
        for i in range(len(strip)):
            for j in range(i+1, len(strip)):
                if (strip[j][1] - strip[i][1]) ** 2 >= min_d: # 거리가 충분히 멀면 루프 중단
                    break
                min_d = min(min_d, distance(strip[i], strip[j]))
        return min_d

    def closest_recursive(sorted_points):
        # sorted_points : x기준 정렬 점 리스트
        if len(sorted_points)<=3:
            return min(distance(sorted_points[i], sorted_points[j]) 
                       for i in range(len(sorted_points))
                       for j in range(i+1, len(sorted_points)))
            
        mid = len(sorted_points) // 2
        mid_points = sorted_points[mid]

        # 왼쪽에서의 최소 거리
        left_min = closest_recursive(sorted_points[:mid])
        # 오른쪽에서의 최소 거리
        right_min = closest_recursive(sorted_points[mid:])
        # 왼쪽 / 오른쪽 중 최소 선택 
        min_d = min(left_min, right_min)

        # 중앙 분할선 근처 점들에 대해 추가적인 최소 거리 계산
        strip = [p for p in sorted_points if abs(p[0] - mid_points[0]) ** 2 < min_d]
        return min(min_d, closest_in_strip(strip, min_d))

    sorted_points = sorted(points)  
    return closest_recursive(sorted_points)

n = int(input().strip())
points = [tuple(map(int, input().strip().split())) for _ in range(n)]   
print(find_closest(points))

   