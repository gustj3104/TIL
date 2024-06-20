'''
N개의 수가 주어졌을 때, 오름차순 정렬
'''
import sys
n = int(input())
num= []

for _ in range(n):
    a = int(input())
    num.append(a)

def quicksort():
    pivot = num[0]
    for i in num:
        if i < pivot:
            i, pivot = pivot, i
    print(num)

quicksort()

