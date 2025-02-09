'''
각 숫자 사이 1cm 여백
1은 2cm, 0은 4cm, 나머지는 3cm
경계와 숫자 사이 1cm 여백
-> 호수판의 너비 구하기
'''
import sys
input = sys.stdin.readline

while True:
    width = 0
    num = int(input())
    if num == 0:
        break
    
    num = list(map(int, str(num)))
    width += 2 #경계와 숫자 사이 여백
    for i in num:
        if i == 1:
            width += 2
        elif i == 0:
            width += 4
        else:
            width += 3
    width += 1 * (len(num) - 1) #숫자 사이 여백
    print(width)
