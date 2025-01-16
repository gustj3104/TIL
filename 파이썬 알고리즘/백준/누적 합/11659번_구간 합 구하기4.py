'''
수 n개에서 i번째 수부터 j번째 수까지 합 구하기기

[1차 시도도]
import sys
input = sys.stdin.readline

def get_sum(k, j):
    result = 0
    for k in range(i-1, j):
        result += num[k]

    return result

n, m = map(int, input().split()) # n: 수의 개수, m: 합을 구해야 하는 횟수
num = list(map(int, input().split()))

for _ in range(m):
    i, j = map(int, input().split())
    print(get_sum(i, j))
'''

import sys
input = sys.stdin.readline

def prefix_sum(arr):
    psum = [0] * (len(arr) + 1)
    for i in range(1, len(arr) + 1):
        psum[i] = psum[i-1] + arr[i-1]
    return psum

n, m = map(int, input().split())
num = list(map(int, input().split()))

psum = prefix_sum(num)

for _ in range(m):
    i, j = map(int, input().split())
    print(psum[j] - psum[i-1])