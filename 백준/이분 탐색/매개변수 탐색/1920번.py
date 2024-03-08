'''N개의 정수가 주어졌을 때 X가 존재하는지 알아내기
첫 번째 줄에 자연수가 주어짐
두 번째 줄에 N개의 정수가 주어짐 A[1]. A[2] --- A[N]
다음 줄 M
다음줄 M개의 수
이 수들이 A안에 존재하는지 
M개의 줄에 답을 출력 존재하면 1, 존재하지 않으면 0 출력

start=1
end=int(max(k_list))

'''

import sys
from bisect import bisect_left

def binary_search(array, target):
    index=bisect_left(array, target) #탐색 위치 저장
    if index < len(array) and array[index] == target:
        return 1
    return 0

n=int(sys.stdin.readline())
n_list=list(map(int, sys.stdin.readline().split()))
n_list.sort()

m=int(sys.stdin.readline())
m_list=list(map(int, sys.stdin.readline().split()))
 
for num in m_list:
    print(binary_search(n_list, num))
    


