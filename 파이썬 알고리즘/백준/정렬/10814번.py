'''
나이순 정렬
'''
import sys

n=int(input())
member_list = []

for _ in range(n):
    member = input().split()
    #첫 요소만 정수로 변환
    member[0] = int(member[0])
    member_list.append(member)

#첫 번째 요소를 기준으로 정렬
member_list.sort(key=lambda x:x[0])

for m in member_list:
    print(m[0], m[1])