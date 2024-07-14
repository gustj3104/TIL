'''
숫자 카드 N개

1 - 숫자 카드 수 N
2 - 카드에 적혀있는 정수 N개
3 - 구할 수가 적힌 카드 수 M
4 - 구할 수 M개


n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))
result = []
cnt = 0

for i in m_list:
    for j in n_list:
        if i == j:
            cnt += 1
    result.append(cnt)
    cnt = 0

print(' '.join(map(str, result)))

시간 초과 -> 딕셔너리 활용
'''

import sys
N = int(sys.stdin.readline().strip())
N_s = list(map(int, sys.stdin.readline().strip().split()))
M = int(sys.stdin.readline().strip())
M_s = list(map(int, sys.stdin.readline().strip().split()))

n_dic = {}
for n in N_s:
    if n in n_dic:
        n_dic[n] +=1
    else:
        n_dic[n] = 1

for m in M_s:
    if m in n_dic:
        print(n_dic[m], end = ' ')
    else:
        print(0, end = ' ')
        