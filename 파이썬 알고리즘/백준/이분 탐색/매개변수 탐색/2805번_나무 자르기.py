# 적어도 m미터의 나무를 집에 가져가기 위한 절단기 설정 최대값
import sys
input = sys.stdin.readline

def wood_length(tree, height):
    return sum(max(0, t - height) for t in tree)

def find_max(tree, m):
    left, right = 0, max(tree)
    result = 0

    while left <= right:
        mid = (left + right) // 2
        wood = wood_length(tree, mid)
        if wood >= m:
            result = mid
            left = mid + 1
        else:
            right = mid - 1

    return result

n, m = map(int, input().split()) # n: 나무 수, m: 가져갈 나무 길이
tree = list(map(int, input().split()))


print(find_max(tree, m))