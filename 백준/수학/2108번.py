'''
통계학
- 산술평균 : N개의 수들의 합을 N으로 나눈 값
- 중앙값 : N개의 수들을 증가순으로 정렬했을 때 중앙값
- 최빈값 : 가장 많이 나타나는 값
- 범위 : 최댓값 - 최솟값
--> N이 주어졌을 때, 네 가지 통계값 출력
'''
import math
import sys

n=int(input())
num=[]
for i in range(n):
    a=int(sys.stdin.readline())
    num.append(a)

s_mean=sum(num)/n #산술평균
s_mean = round(s_mean)

num.sort()
s_middle=num[n//2] #중앙값

frequency={}
for i in num:
    if i in frequency:
        frequency[i] +=1
    else:
        frequency[i] = 1

max_freq = max(frequency.values())
modes = [k for k, v in frequency.items() if v == max_freq]
if len(modes) > 1:
    modes.sort()
    s_max=modes[1]
else:
    s_max = modes[0] #최빈값

s_range=max(num)-min(num) #범위

print(s_mean)
print(s_middle)
print(s_max)
print(s_range)