import sys
input = sys.stdin.readline

ans = list()
data = [i for i in range(1, 51)]
while True:
    n = int(input())
    if n == 0:
        break
    else:
        ans.append(n)

def binary_search(target, data):
    data.sort()
    start = 0 			# 맨 처음 위치
    end = len(data) - 1 	# 맨 마지막 위치
    result = []

    while start <= end:
        mid = (start + end) // 2 # 중간값
        result.append(data[mid])

        if data[mid] == target:
            return result 		# target 위치 반환

        elif data[mid] > target: # target이 작으면 왼쪽을 더 탐색
            end = mid - 1
        else:                    # target이 크면 오른쪽을 더 탐색
            start = mid + 1
    return result


for i in ans:
    l = binary_search(i, data)
    for k in l:
        print(k, end=' ')
    print()