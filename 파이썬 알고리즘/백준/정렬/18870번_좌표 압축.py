''' 
N개의 좌표에 좌표 압축 적용
Xi 좌표 압축 -> Xj / Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같음
좌표 압축을 적용한 결과를 출력하자
앞에는 인덱스, 뒤에는 원래 Xi 좌표가 오도록 배열 생성
'''
import sys
input = sys.stdin.readline

n = int(input())
field = list(map(int, input().split()))
coor = [(field[i], i) for i in range(n)]

coor.sort()

compressed = {}
rank = 0
for i in range(n):
    if coor[i][0] not in compressed:
        compressed[coor[i][0]] = rank
        rank += 1

print(compressed)
result = [0] * n
for value, idx in coor:
    result[idx] = compressed[value]

print(' '.join(map(str, result)))